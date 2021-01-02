package com.awesome.team.ticket.mapper.sync;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 陈建业
 * @since 2021-01-02 22:56:48
 */
@Mapper
@Repository
public interface TblDocStockMapper extends BaseMapper<TblDocStock> {

}
