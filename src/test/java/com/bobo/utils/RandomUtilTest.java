package com.bobo.utils;

import org.junit.Test;

public class RandomUtilTest {

	@Test
	public void testNextInt() {
		System.out.println(RandomUtil.nextInt());
	}

	@Test
	public void testNextIntInt() {
		for (int i = 0; i <10; i++) {
			System.out.println(RandomUtil.nextInt(5));
		}
	
	}

	@Test
	public void testNextIntIntInt() {
		
		for (int i = 0; i <10; i++) {
			System.out.println(RandomUtil.nextInt(5,10));
		}
	}

	@Test
	public void testSubIntegers() {
		int[] is = RandomUtil.subIntegers(5,10,3);	
	
	}

	@Test
	public void testNextCharacter() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(RandomUtil.nextCharacter());
		}
		
	}

	@Test
	public void testNextString() {
		String string = RandomUtil.nextString(6);
		System.out.println(string);
	}

	@Test
	public void testNextSimplifiedChineseCharacter() {
	}

	@Test
	public void testNextSimplifiedChineseString() {
	}

	@Test
	public void testGenerateChinesePersonName() {
	}

	@Test
	public void testUuid() {
	}

}
