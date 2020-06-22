package com.bobo.utils;

import org.junit.Test;

public class NumberUtilTest {

	@Test
	public void testIsNUmber() {
		System.out.println(NumberUtil.isNUmber("abc"));
		System.out.println(NumberUtil.isNUmber("123"));
		System.out.println(NumberUtil.isNUmber("0.123"));
	}

	@Test
	public void testIsReal() {
		System.out.println(NumberUtil.isReal("abc"));
		System.out.println(NumberUtil.isReal("ab2c"));
		System.out.println(NumberUtil.isReal("123"));
		System.out.println(NumberUtil.isReal("0.123"));
		System.out.println(NumberUtil.isReal("-0.123"));
	}

	@Test
	public void testAdd() {
		System.out.println(NumberUtil.add(0.1, 0.2));
	}

	@Test
	public void testSub() {
		System.out.println(NumberUtil.sub(0.1, 0.2));
	}

	@Test
	public void testMul() {
		System.out.println(NumberUtil.mul(0.1, 0.2));
	}

	@Test
	public void testDiv() {
		System.out.println(NumberUtil.div(10, 0.000,3));
	}

	@Test
	public void testRound() {
		double x=3.1415926;
		System.out.println(NumberUtil.round(x, 3));
	}

}
