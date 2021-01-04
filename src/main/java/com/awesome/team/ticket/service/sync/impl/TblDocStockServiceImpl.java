package com.awesome.team.ticket.service.sync.impl;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.awesome.team.ticket.mapper.sync.TblDocStockMapper;
import com.awesome.team.ticket.service.sync.TblDocStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 陈建业
 * @since 2021-01-02 22:58:09
 */
@Service
public class TblDocStockServiceImpl extends ServiceImpl<TblDocStockMapper, TblDocStock> implements TblDocStockService {

    @Resource
    protected JobLauncher jobLauncher;

    @Resource
    private Job syncJob;

    @Override
    public void syncData() throws Exception {
        JobParameters jobParameters =
                new JobParametersBuilder()
                        .addDate("date", new Date())
                        .toJobParameters();

        jobLauncher.run(syncJob, jobParameters);
    }
}
