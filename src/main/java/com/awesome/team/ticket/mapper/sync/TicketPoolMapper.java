package com.awesome.team.ticket.mapper.sync;

import com.awesome.team.ticket.entity.sync.TicketPool;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 陈建业
 * @since 2021-01-03 13:08:14
 */
@Mapper
@Repository
public interface TicketPoolMapper extends BaseMapper<TicketPool> {
}
