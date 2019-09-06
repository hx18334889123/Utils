package com.hanxin.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOUtil {

  private IOUtil() {
  }

  public static void closeStream(Closeable... closeables) {
    try {
      for (Closeable temp : closeables) {
        temp.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 读取文本文件，使用缓冲流
   * @param file
   * @return
   * @throws Exception
   */
  public static String readTextFile(File file) throws Exception {
    if (file == null)
      return null;
    StringBuffer buffer = new StringBuffer();

    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

    Scanner scanner = new Scanner(bis);

    while (scanner.hasNextLine()) {
      buffer.append(scanner.nextLine());
    }
    scanner.close();
    return buffer.toString();
  }

  /**
  * 读取文本文件，使用缓冲流
  * @param file
  * @return
  * @throws Exception 
  * @throws Exception
  */
  @SuppressWarnings("resource")
  public static List<String> readTextFileScanner(String path) throws Exception {
    List<String> list = new ArrayList<String>();
    File file = new File(path);
    Scanner sc = new Scanner(file, "utf-8");
    while (sc.hasNextLine()) {
      list.add(sc.nextLine());
    }
    return list;
  }

  //复制
  public static void copyTo(InputStream input, OutputStream output, boolean needCloseInput,
    boolean needCloseOutput) throws IOException {

    if (input == null || output == null)
      return;

    BufferedInputStream bis = new BufferedInputStream(input);
    BufferedOutputStream bos = new BufferedOutputStream(output);

    byte[] buffer = new byte[1024];

    while (bis.read(buffer) != -1) {
      bos.write(buffer);
    }

    // 由于使用了缓冲输出流。如果没有关闭该 流，则必须flush，如果关闭了这个流，在关闭时会自动flush
    bos.flush();

    if (needCloseInput) {
      closeStream(input);
    }

    if (needCloseOutput) {
      closeStream(output);
    }

  }

  //写入文本文件
  public static void inFileWrite(String content, File file) throws IOException {
    OutputStream os = new FileOutputStream(file);
    byte[] bytes = content.getBytes();
    os.write(bytes, 0, bytes.length);
    os.close();
  }
  
//  //网络文件下载
//  public static void downloadFile(InputStream is,HttpServletResponse response,boolean closeInputStream,
//      boolean closeResponse) throws IOException {
//    OutputStream os = response.getOutputStream();
//    //输入流缓冲区
//    BufferedInputStream bis = new BufferedInputStream(is);
//    // 输出流 缓冲区
//    BufferedOutputStream bos = new BufferedOutputStream(os);
//        byte[] buffer = new byte[1024];
//        int bytesRead = bis.read(buffer);
//        while (bytesRead != -1){ //重点
//           bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
//           bytesRead=bis.read(buffer);
//        }
//        if(closeInputStream) {
//          closeStream(bis,is);
//        }
//        if(closeResponse) {
//          closeStream(bos,os);
//        }
//  }

 
}
