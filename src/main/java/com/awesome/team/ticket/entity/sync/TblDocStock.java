package com.awesome.team.ticket.entity.sync;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author 陈建业
 * @since 2021-01-02 22:44:33
 */
@Data
@TableName(value = "Tbl_Doc_Stock")
public class TblDocStock extends Model<TblDocStock> {

    @TableField(value = "Batch_ID")
    private Integer batchId;

    @TableField(value = "AgentIATA")
    private String agentIATA;

    @TableField(value = "AwbPrefix")
    private String  awbPrefix;

    @TableField(value = "StartNo")
    private String startNo;

    @TableField(value = "EndNo")
    private String endNo;

    @TableField(value = "AwbPostfix")
    private String  awbPostfix;

    @TableField(value = "DocCount")
    private Integer docCount;

    @TableField(value = "Op_Date")
    private Date opDate;

    @TableField(value = "AwbType")
    private String awbType;

}
