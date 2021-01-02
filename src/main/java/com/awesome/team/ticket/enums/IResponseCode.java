package com.awesome.team.ticket.enums;

import java.io.Serializable;

/**
 * 响应码接口
 *
 * @author 陈建业
 * @since 2020-11-10 23:24:36
 */
public interface IResponseCode extends Serializable {

    /**
     * 获取响应码
     *
     * @return
     */
    String getCode();

    /**
     * 获取响应信息
     *
     * @return
     */
    String getMessage();


    /**
     * 考虑到， 同一个状态码，可能会表达多种信息，
     * 例如 参数不允许为空 这个状态码。 但是参数不允许为空，可以具体到哪个参数不能为空。所以提供可以可以设响应信息
     *
     * @param message
     * @return
     * @date 22:21 2020/12/15
     * @author LH
     **/
    default void setMessage(String message) {
        
    }

}
