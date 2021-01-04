package com.awesome.team.ticket.processor;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.awesome.team.ticket.entity.sync.TicketPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 陈建业
 * @since 2021-01-03 00:23:14
 */
@Slf4j
@Component
public class SyncProcessor extends CommonProcessorInstance<TblDocStock, TicketPool> {


    @Override
    public void processor(TicketPool o, TblDocStock tblDocStock) {
        o.setStartNo(Integer.valueOf(tblDocStock.getStartNo()));
        o.setEndNo(Integer.valueOf(tblDocStock.getEndNo()));
        o.setTicketCount(tblDocStock.getDocCount());
        log.info(tblDocStock.getBatchId().toString());
    }
}
