package com.jwf.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @ClassName: StreamUtil
 * @Description: 流处理
 * 
 * @author: jwf
 * @date: 2020年6月24日 上午8:17:30
 */
public class StreamUtil {
	/**
	 * 功能：批量关闭流。
	 *
	 * @param AutoCloseable... closeables 多个可关闭的对象
	 */
	public static void closings(AutoCloseable... closeables) {

		if (closeables == null || closeables.length == 0)
			throw new RuntimeException("参数不能为空");
		for (AutoCloseable autoCloseable : closeables) {
			try {
				autoCloseable.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * 功能：读取文本流，也可以将流转成字符串，默认编码为UTF-8
	 *
	 * @param InputStream inputStream 输入流
	 * @param boolean     isClose 读完后是否关闭流
	 *
	 * @return 字符串
	 */
	public static String asString(InputStream inputStream, boolean isClose) throws IOException {

		byte[] b = new byte[1024];// 每次读取1024的字节

		int m;
		StringBuffer sb = new StringBuffer();
		while ((m = inputStream.read(b)) != -1) {

			sb.append(new String(b, 0, m, "utf-8"));
		}
		if (isClose) {// 是否需要关闭流
			closings(inputStream);
		}
		return sb.toString();

	}

	/**
	 * 功能：按行读取文本文件，返回一个List集合，默认编码为UTF-8，默认关闭流
	 *
	 * @param File    textFile 文本文件
	 * @param String  encode 指定编码
	 * @param boolean isClose 处理完成后是否关闭流
	 *
	 * @return 字符串集合
	 */
	public static List<String> readingLineFormTextFile(File textFile) throws IOException {
		/*
		 * LinkedList<String> list = new LinkedList<String>(); BufferedReader reader =
		 * new BufferedReader(new FileReader(textFile)); String str = ""; while ((str =
		 * reader.readLine()) != null) { list.add(str); }
		 */
		return readingLineFormTextFile(new FileInputStream(textFile));
	}

	public static List<String> readingLineFormTextFile(InputStream inputStream) throws IOException {
		LinkedList<String> list = new LinkedList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String str = "";
		while ((str = reader.readLine()) != null) {
			list.add(str);
		}
		return list;

	}

}
