package com.awesome.team.ticket.config;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.awesome.team.ticket.entity.sync.TicketPool;
import com.awesome.team.ticket.mapper.sync.TblDocStockMapper;
import com.awesome.team.ticket.mapper.sync.TicketPoolMapper;
import com.awesome.team.ticket.processor.SyncProcessor;
import com.awesome.team.ticket.reader.CommonMybatisItemReader;
import com.awesome.team.ticket.writer.CommonMybatisItemWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批处理操作配置
 *
 * @author 陈建业
 * @since 2021-01-02 23:50:46
 */
@Configuration
@EnableBatchProcessing
@Slf4j
public class SpringBatchConfig extends DefaultBatchConfigurer {

    @Value(value = "${spring.batch.reader.chunk-size}")
    private Integer chunkSize;

    @Value(value = "${spring.batch.reader.page-size}")
    private Integer pageSize;

    public static final String SYNC_JOB = "SYNC_JOB";

    public static final String SYNC_STEP = "SYNC_STEP";

    /**
     * 会话工厂
     */
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 任务创建工厂
     */
    @Resource
    private JobBuilderFactory jobBuilderFactory;

    /**
     * 步骤创建工厂
     */
    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Resource
    private DataSource dataSource;

    @Resource
    private SyncProcessor syncProcessor;

    @Override
    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
        factoryBean.setTransactionManager(new ResourcelessTransactionManager());
        factoryBean.setDataSource(dataSource);
        factoryBean.setIsolationLevelForCreate("ISOLATION_DEFAULT");
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    /**
     * 执行任务
     *
     * @return {@link Job}
     */
    @Bean
    public Job syncJob() {
        return this.jobBuilderFactory.get(SYNC_JOB)
                .start(syncStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    /**
     * 同步步骤
     *
     * @return Step
     */
    @Bean
    public Step syncStep() {
        return stepBuilderFactory.get(SYNC_STEP)
                .<TblDocStock, List<TicketPool>>chunk(chunkSize)
                .reader(ticketReader())
                .processor(syncProcessor)
                .writer(ticketWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<TblDocStock> ticketReader() {
        String queryId = TblDocStockMapper.class.getName() + ".select" + TblDocStock.class.getSimpleName() + "List";
        Map<String, Object> parameterValues = new HashMap<>(8);
        parameterValues.put("key", "value");
        CommonMybatisItemReader<TblDocStock> mybatisItemReader = new CommonMybatisItemReader<>(sqlSessionFactory, queryId, parameterValues);
        mybatisItemReader.setPageSize(pageSize);
        return mybatisItemReader;
    }

    @Bean
    @StepScope
    public CommonMybatisItemWriter<List<TicketPool>> ticketWriter() {
        String queryId = TicketPoolMapper.class.getName()  + ".insert" + TicketPool.class.getSimpleName();
        return new CommonMybatisItemWriter<>(sqlSessionFactory, queryId);
    }

}
