package com.example.demo.Utils.Data;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:36 下午
 *
 */

public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(0, "成功"),



    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),

    USER_NOT_EXIT(500,"用户不存在"),

    USER_FALSE_PASSWORD(10002,"密码错误"),


    /* 用户错误：20001-29999*/
    USER_HAS_EXISTED(20001, "用户已存在");





    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
