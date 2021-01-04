package com.awesome.team.ticket.entity.sync;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author 陈建业
 * @since 2021-01-03 00:57:53
 */
@Data
@TableName(value = "ticket_pool")
public class TicketPool extends Model<TicketPool> {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 批次ID
     */
    private Integer batchId;

    /**
     * IATA
     */
    @TableField(value = "AgentIATA")
    private String agentIATA;

    /**
     * 前缀
     */
    private String  awbPrefix;

    /**
     * 后缀
     */
    private String  awbPostfix;

    /**
     * 票证类型
     */
    private String awbType;

    /**
     * 票号
     */
    private String ticketNo;

    /**
     * 代理代码
     */
    private String agentCode;

    /**
     * 业务日期
     */
    private Date operateDate;

    /**
     * 号段
     */
    private String ticketPeriod;

    /**
     * 同一批次即票号段的起始票号
     */
    private Integer startNo;

    /**
     * 同一批次即票号段的结束票号
     */
    private Integer endNo;

    /**
     * 同一批次即票号段的总票量
     */
    private Integer ticketCount;
}
