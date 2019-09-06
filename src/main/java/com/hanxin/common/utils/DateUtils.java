package com.hanxin.common.utils;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	private DateUtils() {}
	
	
	/**
	 * 根据输入的生日日历对象，计算其年龄大小
	 * @param birthday
	 * @return
	 */
	public static int calcAge(Calendar birthday) {
		if (birthday == null) {
			return 0;
		}
		
		int age = 0;
		
		// 获得日历日期中的年月日信息1999-10-05
		int year = birthday.get(Calendar.YEAR);
		int month = birthday.get(Calendar.MONTH);
		int date = birthday.get(Calendar.DATE);
		
		Calendar toDay = new GregorianCalendar();
		
		age = toDay.get(Calendar.YEAR) - year;// 2019-08-08
		
		if (month > toDay.get(Calendar.MONTH)) {
			age--;
		} else if (month == toDay.get(Calendar.MONTH)) {
			if (date > toDay.get(Calendar.DATE)) {
				age--;
			}
		}
		
		return age;
	}
	
	/**
	 * 根据输入的日期对象，计算年龄大小
	 * @param birthday
	 * @return
	 */
	public static int calcAge(Date birthday) {
		// 创建一个日历对象，表示当前日期
		//Calendar c = new GregorianCalendar();
		Calendar c = Calendar.getInstance();
		
		// 使用birthday日期对象 来改变日历对象 的时间
		c.setTime(birthday);
		return calcAge(c);
	}
	
	/**
	 * 计算未来时间到今天的间隔天数
	 * @param future
	 * @return
	 */
	public static int calcDaysFromFuture(Date future) {
		
		int result = 0;
		long futureTime = future.getTime();
		long today = new Date().getTime();
		
		result = (int)((futureTime - today)/1000/60/60/24);
		
		return result+1;
	}
	
	/**
	 * 
	 * @param future
	 * @return
	 */
	public static int calcDaysFromFuture(Calendar future) {
		return calcDaysFromFuture(future.getTime());
	}
	
	/**
	 * 判断给定日期是否为本周内的日期
	 * @param target
	 * @return
	 */
	public static boolean isInThisWeek(Calendar target) {
		boolean result = false;
		
		if (target == null) return false;
		
		// 初始化当前日期
		Calendar toDay = new GregorianCalendar();
		toDay.setTime(new Date());
		
		@SuppressWarnings("unused")
    int toDayInWeek = toDay.get(Calendar.WEEK_OF_MONTH);
		if (toDay.get(Calendar.YEAR) == target.get(Calendar.YEAR)) {
			if (toDay.get(Calendar.MONTH)== target.get(Calendar.MONTH)) {
				if(toDay.get(Calendar.WEEK_OF_MONTH) == target.get(Calendar.WEEK_OF_MONTH)) {
					return true;
				}
					
			}
		}
		
		return result;
	}
	
	public static void initToFirstDateOfMonth(Calendar target) {
		
		target.set(Calendar.DATE, 1);
		target.set(Calendar.HOUR,0);
		target.set(Calendar.MINUTE,0);
		target.set(Calendar.SECOND,0);
	}
	
	public static void setToLastDateOfMonth(Calendar target) {
		int targetMonth = target.get(Calendar.MONTH);
		
		if(targetMonth == 2) {
			
			if (isLeapYear(target.get(Calendar.YEAR))) {
				target.set(Calendar.DATE, 29);
			} else {
				target.set(Calendar.DATE, 28);
			}
			
		} else {
			switch(targetMonth) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				target.set(Calendar.DATE, 31);
				break;
			default:
				target.set(Calendar.DATE, 30);
				break;
			}
		}
		target.set(Calendar.HOUR,0);
		target.set(Calendar.MINUTE,0);
		target.set(Calendar.SECOND,0);
	}


	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
	/**
	 * 比较两个日期的大小
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		return date1.compareTo(date2);
	}
}
