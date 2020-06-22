package com.bobo.utils;

/**
 * 
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @author: charles
 * @date: 2020年6月19日 下午3:04:47
 */
public class StringUtil {

	private static final String EMAIL_REGEX = "^([a-z0-9A-Z]+[-|_|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";// 邮箱正则
	private static final String PHONE_REGEX = "^1[3|4|5|7|8]\\\\d{9}$";// 手机正则

	private static final String LETTER_REGEX = "[a-zA-Z]+";

	/**
	 * 功能：隐藏字符串 示例：StringUtil.hidden("13856237928", 3,7) -> "138****7928"
	 * 参数1：src，源字符串 参数2：start，从开始的位置隐藏，如果为空，则全部不隐藏，
	 * 参数3：end，结束位置，如果为空或为-1，则直到末尾都隐藏，如果超过源字符串长度，则只到末尾 返回值：隐藏结果
	 */
	public static String hidden(String src, Integer start, Integer end) {
		if (!StringUtil.hasText(src))
			return "源字符串不能为空";
		//0 检查输入开始和结束位置是否合适
		if (start > end)
		return "输入的参数不合适";
		// 1.根据开始和结束位置截取要隐藏的内容
		String hiddenStr = src.substring(start, end);
		// 2.生成要替换成的*
		String replaceStr = "";
		for (int i = 0; i < hiddenStr.length(); i++) {
			replaceStr += "*";
		}
		// 3. 执行替换
		return src.replaceFirst(hiddenStr, replaceStr);

	}

	/**
	 * 功能：反转字符串 示例："abcd" → "dcba"
	 *
	 * 参数1：src，源字符串 返回值：反转的字符串
	 */
	public static String reverse(String src) {
		// 判断字符是否有值
		if (!hasText(src))
			return "字符串不能为空";
		return new StringBuffer(src).reverse().toString();
	}

	/**
	 * 功能：判断是否全部为字母 示例： StringUtil.isLetter(null) -> false StringUtil.isLetter("")
	 * -> false StringUtil.isLetter(".com") -> false StringUtil.isLetter("howSun")
	 * -> true
	 */
	public static boolean isLetter(String src) {
		// 判断字符是否有值
		if (!hasText(src))
			return false;
		return src.matches(LETTER_REGEX);
	}

	/**
	 * 功能：验证是否为合格手机号码 示例： StringUtil.isPhone(null) -> false StringUtil.isPhone("")
	 * -> false StringUtil.isPhone("14312039428") -> false
	 * StringUtil.isPhone("13900139000") -> true
	 */
	public static boolean isPhone(String src) {
		// 判断字符是否有值
		if (!hasText(src))
			return false;
		return src.matches(PHONE_REGEX);
	}

	/**
	 * 功能：验证是否为合格邮箱 示例： StringUtil.isEmail(null) -> false StringUtil.isEmail("") ->
	 * false StringUtil.isEmail("zhangjihao@") -> false
	 * StringUtil.isEmail("zhangjihao@sohu") -> false
	 * StringUtil.isEmail("zhangjihao@sohu.com") -> true
	 */
	public static boolean isEmail(String email) {
		// 判断字符是否有值
		if (!hasText(email))
			return false;
		return email.matches(EMAIL_REGEX);
	}

	/**
	 * 功能：检查包含空白字符在内的字符系列长度，并处理过滤前后空格 示例： StringUtil.hasText(null) -> false
	 * StringUtil.hasText("") -> false StringUtil.hasText(" ") -> false
	 * StringUtil.hasText("Hello") -> true
	 */
	public static boolean hasText(String src) {

		return src != null && src.trim().length() > 0;

	}

	/**
	 * 功能：检查包含空白字符在内的字符系列长度 示例： StringUtil.hasLength(null) -> false
	 * StringUtil.hasLength("") -> false StringUtil.hasLength(" ") -> true
	 * StringUtil.hasLength("Hello") -> true
	 */
	public static boolean hasLength(String src) {

		return src != null && src.length() > 0;
	}

}
