package com.shadow.utils;

/**
 * @author WCZ
 * @date 2020-03-29
 * @Description:
 **/
public class RespUtil<T> {
    private String code;

    private String msg;

    private T data;

    public RespUtil() {
    }

    public static RespUtil success(){
        RespUtil respUtil = new RespUtil();
        respUtil.code="100";
        respUtil.msg="处理成功";
        return  respUtil;
    }

    public static RespUtil fail(){
        RespUtil respUtil = new RespUtil();
        respUtil.code="200";
        respUtil.msg="处理失败";
        return  respUtil;
    }

    public RespUtil data(T data){
        this.data=data;
        return this;
    }

    public RespUtil code(String code) {
        this.code = code;
        return this;
    }

    public RespUtil msg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
