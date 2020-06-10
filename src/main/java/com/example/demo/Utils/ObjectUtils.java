package com.example.demo.Utils;

import com.example.demo.Utils.Expection.BizException;
import com.google.common.base.Strings;

/**
 * @author Liu YaXue
 * @since 1.0.0
 */
public final class ObjectUtils {

  public static <T> T requireNonNull(T t, String message) {
    if (t == null){
      throw new BizException(message);
    }
    return t;
  }

  public static String requireNonEmpty(String s, String message){
    if (Strings.isNullOrEmpty(s)){
      throw new BizException(message);
    }
    return s;
  }
}
