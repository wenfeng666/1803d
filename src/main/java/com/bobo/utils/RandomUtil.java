package com.bobo.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @ClassName: RandomUtil
 * @Description: 随机数工具类
 * @author: charles
 * @date: 2020年6月22日 上午9:33:06
 */
public class RandomUtil {

	/**
	 * 功能：获取随机正整数
	 *
	 * @return int 正整数
	 */
	public static int nextInt() {
		Random r = new Random();
		return Math.abs(r.nextInt());
	}

	/**
	 * 功能：获取指定最大范围的随机正整数 示例：max=5，那么返回0-5(包括5)之间任意一个数
	 *
	 * @param int max 最大范围，要包含最大范围值。
	 * @return 随机数
	 */
	public static int nextInt(int max) {

		Random r = new Random();

		return r.nextInt(max + 1);// r.nextInt（5）返回 0=<x<5 的范围的值
	}

	/**
	 * 功能：获取指定最大范围的随机正整数 示例：min=5,max=10，那么返回5-10(包括5和10)之间任意一个数
	 *
	 * @param int min 最小范围，要包含最小范围值。
	 * @param int max 最大范围，要包含最大范围值。
	 * @return 随机数
	 */
	public static int nextInt(int min, int max) {
		Random r = new Random();
		// 0,1,2,3,4,5 5
		return r.nextInt(max - min + 1) + min;
	}

	/**
	 * 功能：在最小值与最大值之间截取随机数 场景：在List集合中截取多个的随机记录。
	 * 
	 * 5 -10 没有重复的三个3值 567 556 789 778 788
	 *
	 * @param int min 起始值。
	 * @param int max 结束值。
	 * @return 多个随机数
	 */
	public static int[] subIntegers(int min, int max, int subLength) {

		int[] x = new int[subLength];//定义数组用来存放结果值
		//定义set集合用来过滤重复数据
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size()!=subLength) {
			set.add(nextInt(min,max));
		}
		//把set转数组
		int i=0;
		for (Integer integer : set) {
		   x[i]=integer;
		   i++;
		}
		return x;
	}

	/**
	 * 功能：获取1-9,a-Z之间的随机字符，即包括数字或字母(含大小写)的字符
	 *
	 * @return 随机字符
	 */
	public static char nextCharacter() {
		String str="123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		return str.charAt(nextInt(str.length() -1));
	}

	/**
	 * 功能：获取指定长度的随机字符数 场景：创建验证码
	 *
	 * @param int length 长度。
	 * @return 随机字符串
	 */
	public static String nextString(int length) {
		StringBuffer sb =new StringBuffer();
		for (int i = 0; i <length; i++) {
			sb.append(nextCharacter());
		}
		return sb.toString();
	}

	/**
	 * 功能：获取一个随机中文字符
	 *
	 * @return 随机简体中文字符
	 */
	public static String nextSimplifiedChineseCharacter() {
		return null;
		// TODO 实现代码
	}

	/**
	 * 功能：获取指定长度的随机中文字符串
	 *
	 * @param int length 长度
	 * @return 随机简体中文字符串
	 */
	public static String nextSimplifiedChineseString(int length) {
		return null;
		// TODO 实现代码
	}

	/**
	 * 功能：创建一个中文姓名
	 *
	 * @return 人名
	 */
	public static String generateChinesePersonName() {
		return null;
		// TODO 实现代码
	}

	/**
	 * 功能：获取不带横线的UUID 场景：上传文件时作为新文件名
	 *
	 * @return 不带横线的UUID
	 */
	public static String uuid() {
		return null;
		// TODO 实现代码
	}
}
