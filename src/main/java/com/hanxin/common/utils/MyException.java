/**
 * Create Date:2019年8月8日
 */
package com.hanxin.common.utils;


/**
 * <br>Title:TODO 类标题
 * <br>Description:TODO 类功能描述
 * <br>Author:韩新(535486768@qq.com)
 * <br>Date:2019年8月8日
 */
public class MyException extends RuntimeException{
  /**
   * <br>Description:TODO 变量描述
   * <br>Author:韩新(535486768@qq.com)
   * <br>Date:2019年9月6日
   */
  private static final long serialVersionUID = 1L;
  public MyException(){
    
  }
  public MyException(String message){
    super(message);
  }
 

}
