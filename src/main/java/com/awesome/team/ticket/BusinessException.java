package com.awesome.team.ticket;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 通用异常
 *
 * @author 陈建业
 * @since 2020-10-18 20:49:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    /**
     * 返回码
     */
    private transient IResponseCode responseCode;

    /**
     * 异常
     */
    private Throwable throwable;


    public BusinessException(final IResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public BusinessException(final IResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
        this.responseCode.setMessage(message);
    }

    public BusinessException(final IResponseCode responseCode, final Throwable throwable) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
        this.throwable = throwable;
    }

}
