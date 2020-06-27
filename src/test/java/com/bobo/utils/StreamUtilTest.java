package com.bobo.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testClosings() {
	}

	@Test
	public void testAsString() throws IOException {
		
		 InputStream inputStream = this.getClass().getResourceAsStream("/data.txt");
		String string = StreamUtil.asString(inputStream, true);
		System.out.println(string);
	}

	@Test
	public void testReadingLineFormTextFile() throws IOException {
		String path ="D:\\class\\1803D\\source\\bobo-common\\src\\test\\resources\\data.txt";
		List<String> list = StreamUtil.readingLineFormTextFile(new File(path));
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testReadingLineFormTextFile2() throws IOException  {
		
		List<String> list = StreamUtil.readingLineFormTextFile(this.getClass().getResourceAsStream("/data.txt"));
		for (String string : list) {
			System.out.println(string);
		}
	}

}
