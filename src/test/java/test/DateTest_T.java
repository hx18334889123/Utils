package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.hanxin.common.utils.DateUtil_T;
public class DateTest_T {
	
	@Test
	public void test01() throws ParseException {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2001-09-06");
		// 日期对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
		int age = DateUtil_T.getAge(calendar);
		System.out.println(age);
	}
	
	@Test
	public void test02() throws ParseException {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-06");
		// 日期对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
		int futrueDays = DateUtil_T.getFutrueDays(calendar);
		System.out.println(futrueDays);
	}
	
	@Test
	public void tset03() throws ParseException {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-05");
		// 日期对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
		int futrueDays = DateUtil_T.getPastDays(calendar);
		System.out.println(futrueDays);
	}
	
	@Test
	public void test04() throws ParseException {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2029-09-05");
		// 日期对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
		boolean inThisDay = DateUtil_T.isInThisDay(calendar);
		System.out.println(inThisDay);
	}
	
	@Test
	public void test05() throws ParseException {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-07");
		// 日期对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
		boolean inThisDay = DateUtil_T.isInThisWeek(calendar);
		System.out.println(inThisDay);
	}
	
	@Test
	public void test06() throws ParseException {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-31");
		// 日期对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
		boolean inThisMonth = DateUtil_T.isInThisMonth(calendar);
		
		System.out.println(inThisMonth);
	}
	
	
	@Test
	public void test07() throws ParseException {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-31");
		// 日期对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
//		System.out.println(calendar);
		DateUtil_T.initDateTime(calendar);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
	}
	@Test
	public void test08() throws ParseException  {
		Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-31");
		
		Date parse1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-31");
		int compareDate = DateUtil_T.compareDate(parse, parse1);
		System.out.println(compareDate);
	}
}
