package com.example.demo.domain;
/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:35 下午
 *
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huajishaonian
 * @time : 2020-06-2020/6/10-2:35 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResResult<T> {

  /**
   * 1.status状态值：代表本次请求response的状态结果。
   */
  private Integer code;
  /**
   * 2.response描述：对本次状态码的描述。
   */
  private String desc;
  /**
   * 3.data数据：本次返回的数据。
   */
  private T data;

  public ResResult<T> setStatus(Integer code) {
    this.code = code;
    return this;
  }

  public ResResult<T> setDesc(String desc) {
    this.desc = desc;
    return this;
  }

  public ResResult<T> setData(T data) {
    this.data = data;
    return this;
  }


  /**
   * 成功，创建ResResult：没data数据
   */
  public static ResResult suc() {
    ResResult result = new ResResult();
    result.setResultCode(ResultCode.SUCCESS);
    return result;
  }

  /**
   * 成功，创建ResResult：有data数据
   */
  public static ResResult suc(Object data) {
    ResResult result = new ResResult();
    result.setResultCode(ResultCode.SUCCESS);
    result.setData(data);
    return result;
  }

  /**
   * 失败，指定status、desc
   */
  public static ResResult fail(Integer code, String desc) {
    ResResult result = new ResResult();
    result.setStatus(code);
    result.setDesc(desc);
    return result;
  }

  /**
   * 失败，指定ResultCode枚举
   */
  public static ResResult fail(ResultCode resultCode) {
    ResResult result = new ResResult();
    result.setResultCode(resultCode);
    return result;
  }

  /**
   * 把ResultCode枚举转换为ResResult
   */
  private void setResultCode(ResultCode code) {
    this.code = code.code();
    this.desc = code.message();
  }
}