package com.hanxin.common.utils;

import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author zhaoming.li
 *
 */
public class StringUtil {

  private StringUtil() {

  }

  /**
   * 判断源字符中是否有值
   * @param src
   * @return
   */
  public static boolean hasLength(String src) {
    return src != null && src.length() > 0;
  }

  /**
   * 判断传入的源自符串是否为非空
   * @param src
   * @return
   */
  public static boolean isNotEmpty(String src) {
    boolean result = false;

    // 1、判断src是否为null，或者是否为空串，如果是则返回false;
    result = StringUtil.hasLength(src);
    if (!result)
      return result;
    else {
      // 2、判断src中所有字符是否全部为空格，如果是则返回false
      // （1）将字符串转换成字符数组
      // （2）遍历这个字符数组，如果发现一个非空格字符，则将result设置true,然后退出循环

      // 重新初始化返回结果
      result = false;

      char[] temp = src.toCharArray();

      for (int i = 0; i < temp.length; i++) {
        if (temp[i] != ' ') {
          result = true;
          break;
        }
      }

    }

    return result;
  }

  /**
   * 判断传入的字符串是否为手机号码
   * @param mobile
   * @return
   */
  public static boolean isMobileNumber(String mobile) {
    return mobile.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$");
  }

  /**
   * 判断输入的源字符中是否都英文字母
   * @param src
   * @return
   */
  public static boolean isAllAlphabetic(String src) {
    boolean result = false;

    if (!StringUtil.isNotEmpty(src))
      return result;

    char[] temp = src.toCharArray();

    for (char c : temp) {
      if (!Character.isAlphabetic(c)) {
        result = false;
        break;
      }
      result = true;
    }

    return result;
  }

  public static String genRandomString(int n) {
    StringBuffer buffer = new StringBuffer();

    for (int i = 0; i < n; i++) {
      char randomChar = (char) ((Math.random() * 58) + 65);
      randomChar = randomChar > 90 && randomChar < 97 ? (char) (randomChar + 8) : randomChar;
      buffer.append(randomChar);
    }

    return buffer.toString();
  }

  /**
   * 
   * @param in
   * @return
   */
  public static String genChineseString(int n) {
    StringBuffer buffer = new StringBuffer();

    int start = Integer.valueOf("4e00", 16);
    int end = Integer.valueOf("9fa5", 16);

    // 生成中文字符的算法如下：
    for (int i = 0; i < n; i++) {
      char randomChar = (char) ((Math.random() * (end - start + 1)) + start);
      buffer.append(randomChar);
    }

    return buffer.toString();
  }

  public static boolean isNumber(String str) {
    boolean reslut = false;
    try {
      @SuppressWarnings("unused")
      Double i = Double.valueOf(str);
      reslut = true;
    } catch (NumberFormatException e) {
      reslut = false;
    }
    return reslut;
  }

  /*
  * 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值。
  * 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
  */
  public static String getPlaceholderValue(String src, String regex) {
    int i = src.lastIndexOf(".");
    int j = src.lastIndexOf("-");
    String string = src.substring(j+1, i);
    if(Pattern.matches(regex, string)){
      return string;
    }
    return null;
    
  }
  


}
