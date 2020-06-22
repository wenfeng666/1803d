package com.bobo.utils;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: NumberUtil
 * @Description: 数字工具类
 * @author: charles
 * @date: 2020年6月20日 上午8:33:32
 */
public class NumberUtil {
	
	private static final String NUMBER_REGEX="[0-9]+";//全是数字正则

	private static final String REAL_REGEX="^(-)?[0-9]+(\\.[0-9]+)?$";
	/**
	 * 功能：判断是否全部为数字 示例：
	 *  NumberUtil.isNUmber("abc") -> false
	 * NumberUtil.isNUmber("5.6") -> false 
	 * NumberUtil.isNUmber("1234") -> true
	 */
	public static boolean isNUmber(String src) {
		if(!StringUtil.hasText(src))//如果为空则返回false
			return false;
		
		return src.matches(NUMBER_REGEX);
	}

	/**
	 * 功能：判断是否全部为实数 示例：
	 *  NumberUtil.isNUmber("abc") -> false
	 * NumberUtil.isNUmber("5.6") -> true
	 *  NumberUtil.isNUmber("1234") -> true
	 */
	public static boolean isReal(String src) {
		if(!StringUtil.hasText(src))//如果为空则返回false
			return false;
		return src.matches(REAL_REGEX);
	}

	/**
	 * 功能：提供精确的加法运算。
	 *
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		//通过BigDecimal 处理两个数字相加
		BigDecimal value1 =new BigDecimal(Double.toString(v1));
		BigDecimal value2 =new BigDecimal(Double.toString(v2));
		return value1.add(value2).doubleValue();
	}

	/**
	 * 功能：提供精确的减法运算。
	 *
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		//通过BigDecimal 处理两个数字相加
		BigDecimal value1 =new BigDecimal(Double.toString(v1));
		BigDecimal value2 =new BigDecimal(Double.toString(v2));
		return value1.subtract(value2).doubleValue();
	}

	/**
	 * 功能：提供精确的乘法运算。
	 * 
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		//通过BigDecimal 处理两个数字相加
		BigDecimal value1 =new BigDecimal(Double.toString(v1));
		BigDecimal value2 =new BigDecimal(Double.toString(v2));
		return value1.multiply(value2).doubleValue();
	}

	/**
	 * 功能：提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
	 *
	 * @param double v1 被除数
	 * @param double v2 除数
	 * @param int    scale 位数，需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if(v2==0)
		throw new RuntimeException("除数不能为0");
		//通过BigDecimal 处理两个数字相加
		BigDecimal value1 =new BigDecimal(Double.toString(v1));
		BigDecimal value2 =new BigDecimal(Double.toString(v2));
		return 	value1.divide(value2, scale,  BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 功能：提供精确的小数位四舍五入处理。
	 * 
	 * @param double 需要四舍五入的数字
	 * @param int    小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
	    BigDecimal value = new BigDecimal(v);
		return  value.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
