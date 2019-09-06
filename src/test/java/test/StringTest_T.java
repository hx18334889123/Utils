package test;

import org.junit.Test;

import com.hanxin.common.utils.StringUtil_T;

public class StringTest_T {
  @Test
  public void test01() {
    boolean empty = StringUtil_T.isEmpty("   ");
    System.out.println(empty);
  }

  @Test
  public void test02() {
    boolean emptyAndSpace = StringUtil_T.isEmptyAndSpace("a   ");
    System.out.println(emptyAndSpace);
  }

  @Test
  public void test03() {
    boolean phoneNum = StringUtil_T.isPhoneNum(null);
    System.out.println(phoneNum);
  }

  @Test
  public void test04() {
    boolean email = StringUtil_T.isEmail("1232313124");
    System.out.println(email);
  }

  @Test
  public void test05() {
    boolean letter = StringUtil_T.isLetter("c-d");
    System.out.println(letter);
  }

  @Test
  public void test06() {
    String randomLetter = StringUtil_T.randomLetter(5);
    System.out.println(randomLetter);
  }

  @Test
  public void test07() {
    String randomLetter = StringUtil_T.randomLetterAndNumber(15);
    System.out.println(randomLetter);
  }

  @Test
  public void test08() {
    String word = StringUtil_T.getWord(5);
    System.out.println(word);
  }

  @Test
	public void Test09(){
	  String str = "外汇局：美国认定中国“汇率操纵”根本站不住脚|http://news.cnstock.com/news,yw-201908-4413224.htm|8|2019-08-08 07:37:32\",\r\n" + 
	    "   \"二线城市房贷利率接连上调 房贷利率区间波动或成常态|http://news.cnstock.com/news,yw-201908-4413229.htm|5|\",\r\n" + 
	    "   \"资产负债管理顶层设计亮相 引导险企向高质量发展转型|http://news.cnstock.com/news,yw-201908-4413222.htm||2019-08-08 07:36:50\",\r\n" + 
	    "   \"泰康在线获泰康集团增资20亿元|http://news.cnstock.com/news,jg-201908-4413369.htm|7|2019-08-08 09:25:53\",\r\n" + 
	    "   \"人民银行：中国7月外汇储备为3.1037万亿美元|http://news.cnstock.com/news,bwkx-201908-4412982.htm|10|2019-08-07 16:43:13\",\r\n" + 
	    "   \"百度战略投资有赞 布局电商小程序|http://news.cnstock.com/news,bwkx-201908-4413414.htm||2019-08-08 10:57:59\",\r\n" + 
	   "";
	  String string = StringUtil_T.changeText(str);
	  System.out.println(string);
	}
}
