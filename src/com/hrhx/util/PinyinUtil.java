package com.hrhx.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
 * @version 20150902
 * @author duhongming
 *
 */

@SuppressWarnings("rawtypes")
public class PinyinUtil implements Comparator {
	
	/**
	 * 拼接拼音字符串
	 * @param pinyinArray
	 * @return
	 */
	private String concatPinyinStringArray(String[] pinyinArray) {
		StringBuffer pinyinStrBuf = new StringBuffer();
		if ((null != pinyinArray) && (pinyinArray.length > 0)) {
			for (int i = 0; i < pinyinArray.length; i++) {
				pinyinStrBuf.append(pinyinArray[i]);
			}
		}
		String outputString = pinyinStrBuf.toString();
		return outputString;
	}

	/**
	 * 比较字符串顺序
	 */
	public int compare(Object o1, Object o2) {
		char c1 = ((String) o1).charAt(0);
		char c2 = ((String) o2).charAt(0);
		return concatPinyinStringArray(PinyinHelper
				.toHanyuPinyinStringArray(c1))
				.compareTo(concatPinyinStringArray(PinyinHelper
						.toHanyuPinyinStringArray(c2)));
	}

	/**
	 * 汉字转拼音（全拼）
	 * @param input
	 * @return
	 */
	public String toPinyin(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c <= 'ÿ') {
				sb.append(c);
			} else {
				String pinyin = null;
				try {
					HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
					format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
					format.setVCharType(HanyuPinyinVCharType.WITH_V);
					String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
					pinyin = pinyinArray[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				if (pinyin != null) {
					sb.append(pinyin);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 汉字转拼音（首字母）
	 * @param input
	 * @return
	 */
	public String getPinyinFirstChar(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c <= 'ÿ') {
				sb.append(c);
			} else {
				String pinyin = null;
				try {
					HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
					format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
					format.setVCharType(HanyuPinyinVCharType.WITH_V);
					String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
					pinyin = pinyinArray[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				if (pinyin != null) {
					sb.append(pinyin.charAt(0));
				}
			}
		}
		return sb.toString();
	}
	
	public String getPinyinFirstCharExt(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c <= 'ÿ') {
				sb.append(c);
			} else {
				String pinyin = null;
				try {
					HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
					format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
					format.setVCharType(HanyuPinyinVCharType.WITH_V);
					String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
					pinyin = pinyinArray[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				if (pinyin != null) {
					if(i==0){
						sb.append(pinyin);
					}else{
						sb.append(pinyin.charAt(0));
					}
					
				}
			}
		}
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		String[] data = { "孙", "孟", "宋", "尹", "廖", "张三", "蚪", "窦鸿槟", "徐", "昆","曹", "曾", "怡", "a", "。"};
		
		List list = Arrays.asList(data);
		Arrays.sort(data, new PinyinUtil());
		System.out.println("汉字排序："+list);
		
		PinyinUtil obj = new PinyinUtil();
		String firstStr = obj.toPinyin("杜洪明");
		System.out.println("登录名(大唐)："+firstStr);
		
		String AllStr = obj.getPinyinFirstChar("杜洪明");
		System.out.println("登录名（未用）："+AllStr.toUpperCase());
		
		String AllStrExt = obj.getPinyinFirstCharExt("杜洪明");
		System.out.println("登录名（和风）："+AllStrExt);
	}
}