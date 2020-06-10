package com.example.demo.Utils.Expection;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-1:38 下午
 *
 */

import lombok.Data;
import lombok.SneakyThrows;
import org.json.JSONObject;

@Data
public class ResultBody {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ResultBody() {
    }

    public ResultBody(BaseExceptionInterfance errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResMsg();
    }


    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonException.SUCCESS.getResultCode());
        rb.setMessage(CommonException.SUCCESS.getResMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseExceptionInterfance baseExceptionInterfance) {
        ResultBody rb = new ResultBody();
        rb.setCode(baseExceptionInterfance.getResultCode());
        rb.setMessage(baseExceptionInterfance.getResMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error( String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @SneakyThrows
    @Override
    public String toString() {
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("code",this.code);
        jsonObject.put("msg",this.message);
        jsonObject.put("result",this.result);
        return jsonObject.toString();
    }

}