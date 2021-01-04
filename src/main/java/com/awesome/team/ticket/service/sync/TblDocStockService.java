package com.awesome.team.ticket.service.sync;

import com.awesome.team.ticket.entity.sync.TblDocStock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 陈建业
 * @since 2021-01-02 22:57:47
 */
public interface TblDocStockService extends IService<TblDocStock> {

    /**
     * 同步数据
     *
     * @throws Exception 异常
     */
    void syncData() throws Exception;
}
