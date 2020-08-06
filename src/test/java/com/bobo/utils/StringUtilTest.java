package com.bobo.utils;

import java.util.Date;

import org.junit.Test;

import com.jwf.utils.StringUtil;

public class StringUtilTest {
	
	
	
	
	@Test
	public void testGetValue() {
		//Date date = new Date(1595028754000l);
		//System.out.println(date);
		String url ="http://news.cnstock.com/news,yw-201908-a4413224.htm";
		
		
		String value = StringUtil.getPlaceholderValue(url, "[0-9]+(?=[^0-9]*$)");
		System.out.println(value);
	}
	@Test
	public void testHidden() {
		String hidden = StringUtil.hidden("abcdedfg", 1, 7);
		System.out.println(hidden);
	}
	
	
	@Test
	public void testReverse() {
		System.out.println(StringUtil.reverse("abcd"));
		System.out.println(StringUtil.reverse("恭喜发财"));
	}
	
	
	@Test
	public void testIsLetter() {
		System.out.println(StringUtil.isLetter("abc"));
		System.out.println(StringUtil.isLetter("abc123"));
	}
	
	@Test
	public void testIsPhone() {
		System.out.println(StringUtil.isPhone("110"));
		System.out.println(StringUtil.isPhone("138999999"));
		System.out.println(StringUtil.isPhone("29999999999"));
		System.out.println(StringUtil.isPhone("19000000000"));
		System.out.println(StringUtil.isPhone("13888888888"));
	}
	
	@Test
	public void testisEmail() {
		System.out.println(StringUtil.isEmail(null));
		System.out.println( StringUtil.isEmail(""));
		System.out.println( StringUtil.isEmail("zhangjihao@"));
		System.out.println( StringUtil.isEmail("zhangjihao@sohu"));
		System.out.println( StringUtil.isEmail("zhangjihao@sohu.com"));
		
	}
	
	@Test
	public void testHasText() {
		System.out.println(StringUtil.hasText(null));
		System.out.println(StringUtil.hasText(""));
		System.out.println(StringUtil.hasText(" "));
		System.out.println(StringUtil.hasText("hello"));
	}

	@Test
	public void testHasLength() {
		System.out.println(StringUtil.hasLength(null));
		System.out.println(StringUtil.hasLength(""));
		System.out.println(StringUtil.hasLength(" "));
		System.out.println(StringUtil.hasLength("hello"));
	}

}
