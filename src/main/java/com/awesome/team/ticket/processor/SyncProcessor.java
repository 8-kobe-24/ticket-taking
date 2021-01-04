package com.awesome.team.ticket.processor;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.awesome.team.ticket.entity.sync.TicketPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈建业
 * @since 2021-01-03 00:23:14
 */
@Slf4j
@Component
public class SyncProcessor implements ItemProcessor<TblDocStock, List<TicketPool>> {


//    @Override
//    public void processor(List<TicketPool> list, TblDocStock tblDocStock) {
//        for (int i = Integer.parseInt(tblDocStock.getStartNo()); i < Integer.parseInt(tblDocStock.getEndNo()); i++) {
//            TicketPool ticketPool = list.get(i);
//            ticketPool.setStartNo(Integer.valueOf(tblDocStock.getStartNo()));
//            ticketPool.setEndNo(Integer.valueOf(tblDocStock.getEndNo()));
//            ticketPool.setAgentIATA(tblDocStock.getAgentIATA());
//            ticketPool.setTicketNo(i + "");
//            ticketPool.setAgentCode(tblDocStock.getAgentIATA());
//            ticketPool.setAwbPostfix(tblDocStock.getAwbPostfix());
//            ticketPool.setAwbPrefix(tblDocStock.getAwbPrefix());
//            ticketPool.setTicketPeriod(tblDocStock.getStartNo() + "-" + tblDocStock.getEndNo());
//            ticketPool.setTicketCount(tblDocStock.getDocCount());
//            ticketPool.setAwbType(tblDocStock.getAwbType());
//            ticketPool.setBatchId(tblDocStock.getBatchId());
//            ticketPool.setOperateDate(tblDocStock.getOpDate());
//        }
//
//        log.info(tblDocStock.getBatchId().toString());
//    }

    @Override
    public List<TicketPool> process(TblDocStock tblDocStock) throws Exception {
        List<TicketPool> list = new ArrayList<>(tblDocStock.getDocCount());
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
            list.add(ticketPool);
        }
        log.info("count---->{}", list.size());
        return list;
    }
}
