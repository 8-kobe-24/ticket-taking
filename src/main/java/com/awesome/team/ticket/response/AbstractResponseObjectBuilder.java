package com.awesome.team.ticket.response;


import com.awesome.team.ticket.IResponseCode;

/**
 * 响应构造器
 *
 * @author 陈建业
 * @since 2020-11-10 23:34:23
 */
public interface AbstractResponseObjectBuilder {

    /**
     * 成功返回
     *
     * @return {@link ResponseObject <Void>}
     */
    static ResponseObject<Void> buildSuccess() {
        ResponseObject<Void> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_SUCCESS);
        return responseObject;
    }

    /**
     * 成功返回
     *
     * @param responseCode 响应码枚举
     * @return {@link ResponseObject <Void>}
     */
    static ResponseObject<Void> buildSuccess(IResponseCode responseCode) {
        ResponseObject<Void> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_SUCCESS);
        responseObject.setCode(responseCode.getCode());
        responseObject.setMessage(responseCode.getMessage());
        return responseObject;
    }

    /**
     * 成功返回
     *
     * @param data 返回数据
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildSuccess(T data) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_SUCCESS);
        responseObject.setData(data);
        return responseObject;
    }

    /**
     * 成功返回
     *
     * @param data         返回数据
     * @param responseCode 响应码枚举
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildSuccess(T data, IResponseCode responseCode) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_SUCCESS);
        responseObject.setCode(responseCode.getCode());
        responseObject.setMessage(responseCode.getMessage());
        responseObject.setData(data);
        return responseObject;
    }

    /**
     * 成功返回
     *
     * @param data 返回数据
     * @param code 响应码枚举
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildSuccess(T data, String code) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_SUCCESS);
        responseObject.setCode(code);
        responseObject.setData(data);
        return responseObject;
    }

    /**
     * 成功返回
     *
     * @param data    返回数据
     * @param code    响应码
     * @param message 响应信息
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildSuccess(T data, String code, String message) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_SUCCESS);
        responseObject.setCode(code);
        responseObject.setMessage(message);
        responseObject.setData(data);
        return responseObject;
    }

    /**
     * 失败返回
     *
     * @return {@link ResponseObject <Void>}
     */
    static ResponseObject<Void> buildFail() {
        ResponseObject<Void> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_FAIL);
        return responseObject;
    }

    /**
     * 失败返回
     *
     * @param data 返回数据
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildFail(T data) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_FAIL);
        responseObject.setData(data);
        return responseObject;
    }

    /**
     * 失败返回
     *
     * @param data         返回数据
     * @param responseCode 响应码枚举
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildFail(T data, IResponseCode responseCode) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_FAIL);
        responseObject.setCode(responseCode.getCode());
        responseObject.setMessage(responseCode.getMessage());
        responseObject.setData(data);
        return responseObject;
    }

    /**
     * 失败返回
     *
     * @param data 返回数据
     * @param code 响应码
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildFail(T data, String code) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_FAIL);
        responseObject.setCode(code);
        responseObject.setData(data);
        return responseObject;
    }

    /**
     * 失败返回
     *
     * @param data    返回数据
     * @param code    响应码
     * @param message 响应信息
     * @return {@link ResponseObject <T>}
     */
    static <T> ResponseObject<T> buildFail(T data, String code, String message) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setStatus(ResponseObject.STATUS_FAIL);
        responseObject.setCode(code);
        responseObject.setData(data);
        responseObject.setMessage(message);
        return responseObject;
    }
}
