package com.hanxin.common.utils;

// 完成字符串的工具类
public class StringUtil_T {
	
	private final static String letters="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	private final static String number="123456790";
	
	private StringUtil_T() {}
	
	//判断源字符串是否有值，空引号也算没值
	public static boolean isEmpty(String str) {
		return str!=null && !"".equals(str);
	}
	
	//	判断源字符串是否有值，空引号和空格也算没值
	public static boolean isEmptyAndSpace(String str) {
		return str!=null && !"".equals(str.trim());
	}
	
	//判断是否为手机号码
	public static boolean isPhoneNum(String phoneNum) {
		if(!isEmpty(phoneNum)) {
			return false;
		}
		//  验证是否为手机号 需要使用正则表达式
		String reg_phone="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
		boolean matches = phoneNum.matches(reg_phone);
		return matches;


	}
	
	//判断是否为邮箱
	public static boolean isEmail(String email) {
		if(!isEmpty(email)) {
			return false;
		}
			//  验证是否为手机号 需要使用正则表达式
			String reg_email="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
			boolean matches = email.matches(reg_email);
			return matches;
	}
	
	// 判断是否全部为字母
	public static boolean isLetter(String letter) {
		if(!isEmpty(letter)) {
			return false;
		}
		String reg_letter="^[a-zA-Z]+$";
		boolean matches = letter.matches(reg_letter);
		return matches;
	}
	
	//获取n位随机英文字符串
	public static String randomLetter(int length) {
		StringBuffer sb=new StringBuffer();
		char[] charArray = letters.toCharArray();
		for(int i=0;i<length;i++) {
			int num=(int)(Math.random()*charArray.length);
			sb.append(charArray[num]);
		}
		return sb.toString();
	}
	//获取n位随机英文和数字字符串
	public static String randomLetterAndNumber(int length) {
		StringBuffer sb=new StringBuffer();
		char[] charArray = (letters+number).toCharArray();
		for(int i=0;i<length;i++) {
			int num=(int)(Math.random()*charArray.length);
			sb.append(charArray[num]);
		}
		return sb.toString();
	}
	
	//获取n个随机中文字符串
	public static  String getWord(int length) {
//		4e00~9fa5
		StringBuffer sb=new StringBuffer();
		int parseInt1 = Integer.parseInt("4e00",16);
		int parseInt2 = Integer.parseInt("9fa5",16);
		// 随机数= Math.random()*(最大值-最小值+1)+最小值
		for(int i=0;i<length;i++) {
			int num=(int)(Math.random()*(parseInt2-parseInt1+1)+parseInt1);
			sb.append((char)num);
		}
		return sb.toString();
	}
	
	//windows系统中  如果是： \r\n 替换成 <p></p> 标签  如果是\r 替换成<br>
	public static String changeText(String str){
	  str = str.replaceAll("\r\n", "<p></p>");
	  str = str.replaceAll("\r", "<br>");
    return str;
	  
	}
}
