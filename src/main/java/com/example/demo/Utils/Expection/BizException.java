package com.example.demo.Utils.Expection;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-1:21 下午
 *
 */

import lombok.Data;

//继承运行时异常
@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String code;
    /**
     * 错误信息
     */
    protected String msg;

    public BizException() {
        super();
    }

    public BizException(BaseExceptionInterfance baseExceptionInterfance) {
        super(baseExceptionInterfance.getResultCode());
        this.code = baseExceptionInterfance.getResultCode();
        this.msg = baseExceptionInterfance.getResMsg();
    }

    public BizException(BaseExceptionInterfance errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultCode(), cause);
        this.code = errorInfoInterface.getResultCode();
        this.msg = errorInfoInterface.getResMsg();
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(String code, String msg) {
        super(code);
        this.code = code;
        this.code = code;
    }

    public BizException(String code, String msg, Throwable cause) {
        super(code, cause);
        this.code = code;
        this.msg = msg;
    }




    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }


}
