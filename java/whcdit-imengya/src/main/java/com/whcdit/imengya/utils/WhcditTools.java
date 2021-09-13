package com.whcdit.imengya.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhcditTools {
	/**
	 * 【判定字符串是空值】【宋鹏-18091】【武汉】【2019-10-23】
	 */
	public static boolean strNullEmpty(String param) {
		boolean result = false;
		if (param == null) {
			result = true;
		} else {
			if (param.equals("")) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * 【判定集合是空值】【宋鹏-18091】【武汉】【2019-10-23】
	 */
	public static boolean listNullEmpty(List<?> param) {
		boolean result = false;
		if (param == null) {
			result = true;
		} else {
			if (param.isEmpty()) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	private static final String datePattern22 = "yyyy-MM-dd HH:mm:ss"; // 标准格式

	/**
	 * 【获取秒级字符串】【宋鹏-18091】【武汉】【2019-10-23】
	 */
	public synchronized static String getUnicode(String prefix) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String res = sdf.format(new Date());
		return prefix+res;
	}
	
	/**
	 * 【获取拆分后的年月日数字】【宋鹏-18091】【武汉】【2019-10-23】
	 */
	public  static Map<Integer, Integer> getYMD(Date date) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dstr = sdf.format(date);
		String[] darr = dstr.split("-");
		Map<Integer, Integer> map = new HashMap<>();;
		map.put(1, Integer.valueOf(darr[0]));
		map.put(2, Integer.valueOf(darr[1]));
		map.put(3, Integer.valueOf(darr[2]));
		return map;
	}
	
	/**
	 * 【获取时间】【宋鹏-18091】【武汉】【2019-10-23】
	 */
	public  static Date std(String param) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern22);
		 Date date = null;
		try {
			date = sdf.parse(param);
		} catch (ParseException e) {
			System.out.println("时间字符串格式错误：" + param);
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 【获取时间】【宋鹏-18091】【武汉】【2019-10-23】
	 */
	public  static String dts(Date date) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	
	/**
	 * 【获取无间隔格式的时间】【宋鹏-18091】【武汉】【2019-10-23】
	 */
	public  static String dtyyyyMMdd(Date date) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dstr = sdf.format(date);
		return dstr;
	}

	public  static String dtyyyyMMddKong(Date date) {
		if (date == null) {
			return WhcditConstants.KNULL;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dstr = sdf.format(date);
		return dstr;
	}
	
	public static String getBCDtime(String param) {
		String yyyy = param.substring(0, 4);
		String MM = param.substring(4, 6);
		String dd = param.substring(6, 8);
		String HH = param.substring(8, 10);
		String mm = param.substring(6, 8);
		String ss = param.substring(6, 8);
		return yyyy+"-"+MM+"-"+dd+" "+HH+":"+mm+":"+ss;
	}
			
}
