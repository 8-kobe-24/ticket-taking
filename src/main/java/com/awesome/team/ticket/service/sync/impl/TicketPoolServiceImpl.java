package com.awesome.team.ticket.service.sync.impl;

import com.awesome.team.ticket.entity.sync.TicketPool;
import com.awesome.team.ticket.mapper.sync.TicketPoolMapper;
import com.awesome.team.ticket.service.sync.TicketPoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 陈建业
 * @since 2021-01-05 07:50:32
 */
@Service
public class TicketPoolServiceImpl extends ServiceImpl<TicketPoolMapper, TicketPool> implements TicketPoolService {
}
