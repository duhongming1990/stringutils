package com.hrhx.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 字符串处理
 * @author Administrator
 *
 */
public class StringUtil {
	
	/**
	 * 得到文件的后缀名
	 * @param fileName
	 * @return
	 */
	public static String getFileExtension(String fileName){
		return fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}

	/**
	 * 字符串字符转义
	 * @return
	 */
	public static String replaceStr(String queryWord) {
		queryWord = queryWord.replaceAll("'","\'");// 防止查询中带'报错
		queryWord = queryWord.replaceAll("\r","\\r");// 防止查询中带\r报错
		queryWord = queryWord.replaceAll("\n","\\n");// 防止查询中带\n报错
		queryWord = queryWord.replaceAll("\t","\\t");// 防止查询中带\t报错
		queryWord = queryWord.replaceAll(":","\\:");// 防止查询中带:报错
		queryWord = queryWord.replaceAll("&nbsp;","");// 防止查询中带&nbsp;报错
		//queryWord = queryWord.replaceAll("\\\\","\\\\");// 防止查询中带\\报错
		return queryWord.trim();
	}
	/**
	 * 强制输出到页面
	 * @param response
	 * @param tips
	 * @throws IOException
	 */
	public static void myTipsOutPage(HttpServletResponse response,String tips){
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(tips);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//判断字符串是否为数字：
	public static boolean isNumeric(String str){
	   for (int i = str.length() ; --i>=0 ; ){   
	    if (!Character.isDigit(str.charAt ( i ) ) ){
	     return false;
	    }
	   }
	   return true;
	}
}
