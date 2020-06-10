package com.example.demo.utils;

import com.example.demo.expection.BizException;
import com.google.common.base.Strings;

/**
 * @author Liu YaXue
 * @since 1.0.0
 */
public final class ObjectUtils {

  public static <T> T requireNonNull(T t, String message) {
    if (t == null) {
      throw new BizException("400", message);
    }
    return t;
  }

  public static String requireNonEmpty(String s, String message) {
    if (Strings.isNullOrEmpty(s)) {
      throw new BizException("400", message);
    }
    return s;
  }
}
