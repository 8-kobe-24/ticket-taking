package com.awesome.team.ticket.service.sync.impl;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.awesome.team.ticket.entity.sync.TicketPool;
import com.awesome.team.ticket.mapper.sync.TblDocStockMapper;
import com.awesome.team.ticket.service.sync.TblDocStockService;
import com.awesome.team.ticket.service.sync.TicketPoolService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈建业
 * @since 2021-01-02 22:58:09
 */
@Slf4j
@Service
public class TblDocStockServiceImpl extends ServiceImpl<TblDocStockMapper, TblDocStock> implements TblDocStockService {

    @Resource
    protected JobLauncher jobLauncher;

    @Resource
    private Job syncJob;

    @Resource
    private TicketPoolService ticketPoolService;

    @Override
    public void syncData() throws Exception {
//        JobParameters jobParameters =
//                new JobParametersBuilder()
//                        .addDate("date", new Date())
//                        .toJobParameters();
//
//        jobLauncher.run(syncJob, jobParameters);
        long t1 = System.currentTimeMillis();
        QueryWrapper<TblDocStock> queryWrapper = new QueryWrapper<>();
        int count = this.count(queryWrapper);
        Page<TblDocStock> page = new Page<>(1, 5000);
        IPage<TblDocStock> iPage = this.page(page);
        long t2 = System.currentTimeMillis();
        log.info("cost time ===> {}", t2 - t1);
        List<TblDocStock> list = iPage.getRecords();
        List<TicketPool> ticketPools = new ArrayList<>();
        for (TblDocStock tblDocStock : list) {
            for (int i = Integer.parseInt(tblDocStock.getStartNo()); i <= Integer.parseInt(tblDocStock.getEndNo()); i++) {
                TicketPool ticketPool = new TicketPool();
                ticketPool.setStartNo(Integer.valueOf(tblDocStock.getStartNo()));
                ticketPool.setEndNo(Integer.valueOf(tblDocStock.getEndNo()));
                ticketPool.setAgentIATA(tblDocStock.getAgentIATA());
                ticketPool.setTicketNo(i + "");
                ticketPool.setAgentCode(tblDocStock.getAgentIATA());
                ticketPool.setAwbPostfix(tblDocStock.getAwbPostfix());
                ticketPool.setAwbPrefix(tblDocStock.getAwbPrefix());
                ticketPool.setTicketPeriod(tblDocStock.getStartNo() + "-" + tblDocStock.getEndNo());
                ticketPool.setTicketCount(tblDocStock.getDocCount());
                ticketPool.setAwbType(tblDocStock.getAwbType());
                ticketPool.setBatchId(tblDocStock.getBatchId());
                ticketPool.setOperateDate(tblDocStock.getOpDate());
                ticketPools.add(ticketPool);

            }
        }
        ticketPoolService.saveBatch(ticketPools);
        log.info("size====>{}", ticketPools.size());

    }
}
