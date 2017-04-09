package blog.util.catgetory;

import org.junit.Test;

import com.core.util.catgetory.StringUtil;

import global.BaseTest;

public class StringUtilTest extends BaseTest{
	
	/**
	 * 创建四个测试常量
	 */
	String s1 = null;
	String s2 = "";
	String s3 = "21";
	String s4 = "21jsq!";
	
	@Test
	public void testToInt(){
		System.out.println("testToInt:");
		System.out.println("s1 = " + StringUtil.toInt(s1));
		System.out.println("s2 = " + StringUtil.toInt(s2));
		System.out.println("s3 = " + StringUtil.toInt(s3));
		System.out.println("s4 = " + StringUtil.toInt(s4));
	}
	@Test
	public void testToLong(){
		System.out.println("testToLong:");
		System.out.println("s1 = " + StringUtil.toLong(s1));
		System.out.println("s2 = " + StringUtil.toLong(s2));
		System.out.println("s3 = " + StringUtil.toLong(s3));
		System.out.println("s4 = " + StringUtil.toLong(s4));
	}
	@Test
	public void testIsEmpty(){
		System.out.println("testIsEmpty:");
		System.out.println("s1 = " + StringUtil.isEmpty(s1));
		System.out.println("s2 = " + StringUtil.isEmpty(s2));
		System.out.println("s3 = " + StringUtil.isEmpty(s3));
		System.out.println("s4 = " + StringUtil.isEmpty(s4));
	}
	
	/*public void testSplitToList(){
		System.out.println("testSplitToList:");
		System.out.println("s1 = " + StringUtil.toInt(s1));
		System.out.println("s2 = " + StringUtil.toInt(s2));
		System.out.println("s3 = " + StringUtil.toInt(s3));
		System.out.println("s4 = " + StringUtil.toInt(s4));
	}*/
}
