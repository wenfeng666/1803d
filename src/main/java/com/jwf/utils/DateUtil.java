package com.jwf.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil
 * @Description: 日期处理类
 * @author: jwf
 * @date: 2020年6月20日 上午9:27:33
 */
public class DateUtil {

	// 计算传入日期到现在的月数
	public static int getMonth(Date date) {
		
	   //方法1
	   /*long t1 = date.getTime();//传入的
		 long t2 = new Date().getTime();//当前的
		 int t =(int) ((t2 - t1)/1000/60/60/24/30);
		return t;*/
	//方法2
		
		// 当前的年月
		  Calendar c = Calendar.getInstance();// 
		  int now_year = c.get(Calendar.YEAR);//当前年
		  int now_month = c.get(Calendar.MONTH);//当前月2
		 //传入的年月 
		  Calendar c2 = Calendar.getInstance();// 
		  c2.setTime(date);
		  int param_year= c2.get(Calendar.YEAR);//传入的年 
		  int param_month = c2.get(Calendar.MONTH);//传入的月
		  int month =(now_year -param_year)*12 + (now_month -param_month);// 
		  return month;
	}

	/**
	 * 功能：根据生日计算年龄 示例：现在是2020-6-20，如果生日是2000-6-23，那结果是19
	 * 
	 * @param Date，生日
	 * @return int 年龄
	 */
	public static int getAge(Date birthday) {
		// 1.获取系统的年月日
		Calendar c = Calendar.getInstance();// 用系统时间初始化日历类
		int now_year = c.get(Calendar.YEAR);// 获取系统的年
		int now_month = c.get(Calendar.MONTH);// 获取系统的月
		int now_day = c.get(Calendar.DAY_OF_MONTH);// 获取系统的日
		// 2获取出生日期的年月日
		c.setTime(birthday);// 用生日初始化 日历类
		int b_year = c.get(Calendar.YEAR);// 获取生日的年
		int b_month = c.get(Calendar.MONTH);// 获取生日的月
		int b_day = c.get(Calendar.DAY_OF_MONTH);// 获取生日的哪一天
		int age = now_year - b_year;// 年龄
		if (now_month < b_month)// 还没有到生日月份
			age--;// 让年龄减小1
		if (now_month == b_month && now_day < b_day)
			age--;
		return age;
	}

	/**
	 * 功能：给定时间对象，获取该时间的月初1日0时0分0秒0毫秒 示例：2018-11-11 08:30:16 → 2018-11-01 00:00:00
	 * 使用场景：可用在数据库里查询某月的时间范围
	 *
	 * @param Date 源时间
	 * @return Date 月初时间
	 */
	public static Date getFirstDayOfMonth(Date src) {
		Calendar c = Calendar.getInstance();// 获取系统时间
		// 用传入的日期初始化日历类
		c.setTime(src);
		// 方式1
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
		// 方式2
		// c.set(Calendar.DAY_OF_MONTH, 1);//设置日为月份第一天
		// c.set(Calendar.HOUR_OF_DAY, 0);//设置小时
		// c.set(Calendar.MINUTE, 0);//设置分钟
		// c.set(Calendar.SECOND, 0);//设置秒
		return c.getTime();
	}

	/**
	 * 功能：给定时间对象，获取该时间的月末最后一天的23时23分59秒999毫秒 示例：2018-11-11 08:30:16 → 2018-11-30
	 * 23:23:59 使用场景：可用在数据库里查询某月的时间范围
	 *
	 * @param Date 源时间
	 * @return Date 月末时间
	 */
	public static Date getLastDayOfMonth(Date src) {
		// 思路： 让当前日期的月份加1个月，然后获取月初，再减去1秒
		// 1.获取系统日期
		Calendar c = Calendar.getInstance();
		// 2.用传入的日期初始化日历类
		c.setTime(src);
		// 3让当前日期的月份加1个月
		c.add(Calendar.MONTH, 1);
		// 4.然后获取月初
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
		// 5.再减去1秒
		c.add(Calendar.SECOND, -1);
		return c.getTime();

	}

	/**
	 * 功能：获取当前日期指定天数之前或之后的日期，如果参数为负数，则往前回滚。 示例1：当前是2018-08-08，参数days=5，结果是2018-08-13
	 * 示例2：当前是2018-08-08，参数days=-4，结果是2018-08-04
	 * 
	 * @param int days 偏移的天数，如果为负数则往前回滚。
	 * @return Date 新日期
	 */
	public static Date offsetDate(int days) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days);
		return c.getTime();
	}

	/**
	 * 功能：获取当前季节，如春季、夏季、秋季、冬季。
	 * 
	 * @return Season 季节
	 */
	public static Season getCurrentSeason() {
		Calendar c = Calendar.getInstance();

		int month = c.get(Calendar.MONTH) + 1;// 获取当前系统时间的月份
		// 春：345,夏678,秋：9 10 11,冬： 12 1 2
		if (month < 9 && month > 2) {
			if (month < 6) {
				return Season.春;
			}
			return Season.夏;
		} else {
			if (month >= 9 && month <= 11)
				return Season.秋;
			return Season.冬;
		}

	}

	/**
	 * 功能：获取人性化时间，例如5分钟之内则显示“刚刚”，其它显示16分钟前、2小时前、3天前、4月前、5年前等
	 *
	 * @param Date date 源时间。
	 * @return 人性化时间
	 */
	public static String getDisplayTime(Date date) {
		long t1 = date.getTime();// 获取传入日期的毫米值 。从1970-1-1 到date 的毫米值
		long t2 = new Date().getTime();// 当前系统日期的毫米值。即 从1970-1-1 到现在的毫米值
		long t = t2 - t1;// 获取两个时间的差值
		long minute = t / 1000 / 60;// 分钟
		if (t2 < t1)
			return "未来时间";
		if (minute / 60 / 24 / 30 / 12 >= 1)
			return minute / 60 / 24 / 30 / 12 + "年前";
		else if (minute / 60 / 24 / 30 >= 1)
			return minute / 60 / 24 / 30 + "月前";
		else if (minute / 60 / 24 >= 1)
			return minute / 60 / 24 + "天前";
		else if (minute / 60 >= 1)
			return minute / 60 + "小时前";
		else if (minute > 5)//
			return minute + "分钟前";
		else
			return "刚刚";
	}

}
