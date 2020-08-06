package com.bobo.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.jwf.utils.FileSizeUnit;
import com.jwf.utils.FileUtil;

public class FileUtilTest {

	@Test
	public void testGetUserDir() {
		File file = FileUtil.getUserDir();
		System.out.println(file);
	}

	@Test
	public void testGetUserHomeDir() {
		File file = FileUtil.getUserHomeDir();
		System.out.println(file);
	}

	@Test
	public void testGetTmpDir() {
		File file = FileUtil.getTmpDir();
		System.out.println(file);
	}

	@Test
	public void testGetRoot() {
		File root = FileUtil.getRoot(new File("E:\\pic\\1.jpg"));
		System.out.println(root);
	}

	@Test
	public void testGetFileExtensions() {
	}

	@Test
	public void testGetFileSize() {
		long size = FileUtil.getFileSize(new File("E:\\pic\\1.jpg"), FileSizeUnit.KB);
		System.out.println(size+FileSizeUnit.KB.toString());
		
	}

	@Test
	public void testGetTotalSpace() {
		long space = FileUtil.getTotalSpace(new File("E:\\pic\\1.jpg"), FileSizeUnit.GB);
		System.out.println(space);
	}
	

	@Test
	public void testGetRootTotalSpace() {
		
	}

	@Test
	public void testGetFreeSpace() {
		
	}

	@Test
	public void testDeletes() {
		FileUtil.deletes(new File("e:/test2020"));
	}
	

}
