package com.awesome.team.ticket.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回
 *
 * @author 陈建业
 * @since 2020-11-10 23:26:35
 */
@Data
@ApiModel("统一返回对象")
public class ResponseObject<T> implements Serializable {

    @ApiModelProperty(value = "返回状态")
    private Integer status;

    @ApiModelProperty(value = "返回代码")
    private String code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private transient T data;

    public static final Integer STATUS_FAIL = 0;

    public static final Integer STATUS_SUCCESS = 1;

    public static final Integer STATUS_PROCESSING = 2;

}
