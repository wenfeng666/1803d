package com.bobo.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.jwf.utils.RandomUtil;

public class PersonTest {

	@Test
	public void testPerson() {
	
		for (int i = 0; i < 10000; i++) {
			Person p = new Person();	
		
			
	
		//姓名属性值调用StringUtil.generateChineseName()创建（4分）
		p.setName(RandomUtil.generateChinesePersonName());
		//年龄属性值调用RandomUtil.random()创建，必须在1-120岁之间（4分）
		p.setAge(RandomUtil.nextInt(1, 120));
		//介绍属性值调用StringUtil.randomChineseString()创建，字数为140个随机汉字（4分）
		p.setAbout(RandomUtil.nextSimplifiedChineseString(140));
		//注册日期属性值模拟2010年1月1日至今任意随机时间（4分）。
		Calendar c = Calendar.getInstance();
		c.set(2010, 0, 1);
		p.setCreated(RandomUtil.randomDate(c.getTime(), new Date()));
	System.out.println(p);
		}
	}

}
