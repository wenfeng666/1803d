package com.bobo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.jwf.utils.DateUtil;

public class DateUtilTest {
	
	@Test
	public void testGetMonth() {
		
		//2000-6-23
		Calendar c = Calendar.getInstance();
		//月份 0-11
		c.set(2019, 11, 8);
		int i = DateUtil.getMonth(c.getTime());	
		System.out.println(i);
	}

	@Test
	public void testGetAge() {
		
		//2000-6-23
		Calendar c = Calendar.getInstance();
		//月份 0-11
		c.set(2019, 6, 8);
		System.out.println(DateUtil.getAge(c.getTime()));
	}

	@Test
	public void testGetFirstDayOfMonth() {
		
		Calendar c = Calendar.getInstance();
		c.set(2000, 11, 12);
		
	///	Date date = DateUtil.getFirstDayOfMonth(new Date());
		Date date = DateUtil.getFirstDayOfMonth(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}

	@Test
	public void testGetLastDayOfMonth() {
		Calendar c = Calendar.getInstance();
		c.set(2021, 1, 12);
		//Date date = DateUtil.getLastDayOfMonth(new Date());
		Date date = DateUtil.getLastDayOfMonth(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}

	@Test
	public void testOffsetDate() {
		Date date = DateUtil.offsetDate(-9);
		//Date date = DateUtil.offsetDate(9);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}

	@Test
	public void testGetCurrentSeason() {
		System.out.println(DateUtil.getCurrentSeason());
	}

	@Test
	public void testGetDisplayTime() {
		
		Calendar c = Calendar.getInstance();
		c.set(2021, 1, 12);
		
		
		String time = DateUtil.getDisplayTime(c.getTime());
		System.out.println(time);
	}

}
