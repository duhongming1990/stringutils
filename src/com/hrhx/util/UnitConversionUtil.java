package com.hrhx.util;

import org.junit.Test;

public class UnitConversionUtil {
	//文件大小自动转换
	public  String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else
            return String.format("%d B", size);
    }
	
	public String convertTimeLength(long minutes){
		long h = 60;
		long d = h * 24;
		if(minutes>d){
			return String.format("%d天", minutes/d)+String.format("%d时", (minutes-minutes/d*d)/h)+String.format("%d分", (minutes-minutes/d*d)%h);
		}else if(minutes>h){
			return String.format("%d时", minutes/h)+String.format("%d分", minutes%h);
		}else if(minutes<=h){
			return String.format("%d分",minutes);
		}else{
			return "格式化异常！";
		}
	}
	
	@Test
	public void convertFileSizeTest(){
		System.out.println(convertFileSize(10*1024));
		System.out.println(convertFileSize(10*1024*1024));
		System.out.println(convertFileSize(10*1024*1024*1000));
	}
	
	@Test
	public void convertTimeLength(){
		System.out.println(convertTimeLength(60));
		System.out.println(convertTimeLength(61));
		System.out.println(convertTimeLength(61*10));
		System.out.println(convertTimeLength(60*24*10+61));
	}
}
