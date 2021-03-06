package com.example.demo.exception;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-1:15 下午
 *
 */

public enum CommonException implements BaseExceptionInterfance {

    SUCCESS("200","成功"),

    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    NOT_FOUND("404", "未找到该资源!"),
    DATA_ERROR("444","数据格式错误"),
    ID_CARD_Error("1001","身份证号有误或已实名认证"),
    EXIT_USERNAME("10004","账号已存在"),
    BANLANCE_LESS("20004","您的余额不足"),
    FILED_TRANSTER("10004","转账失败")

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
