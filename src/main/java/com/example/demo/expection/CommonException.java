package com.example.demo.expection;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-1:15 下午
 *
 */

public enum CommonException implements BaseExceptionInterfance {

    SUCCESS("200","成功"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    NOT_FOUND("404", "未找到该资源!"),
    DATA_ERROR("444","数据格式错误")
    ;


    //状态码
    private  String code;

    //描述
    private String msg;

    CommonException(String code, String msg) {
        this.code= code;
        this.msg= msg;
    }

    @Override
    public String getResultCode() {
        return code;
    }

    @Override
    public String getResMsg() {
        return msg;
    }
}
