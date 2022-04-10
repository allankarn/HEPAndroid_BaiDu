package com.enetedu.hep.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressLint("SimpleDateFormat")
public class Date4String {

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	public String date4Str(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy",
				Locale.ENGLISH);
		// February 2 2015 11:39:02
		String strDate = new String();
		try {
			String s1 = s.replaceAll("\\,", "");
			Date date = sdf.parse(s1);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",
					Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
//			Log.e("time", date.toString());
			strDate = df.format(sDate);
			// System.out.println("strDate: " + strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}

	public String date4Str(String s, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
				Locale.ENGLISH);
		String strDate = new String();
		try {
			String s1 = s.replaceAll("\\,", "");
			Date date = sdf.parse(s1);
			SimpleDateFormat df = new SimpleDateFormat(type,
					Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
			strDate = df.format(sDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}

    public String date4Str_(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
                Locale.ENGLISH);
        // February 2 2015 11:39:02
        String strDate = new String();
        try {
            String s1 = s.replaceAll("\\,", "");
            Date date = sdf.parse(s1);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                    Locale.CHINESE);
            java.sql.Date sDate = new java.sql.Date(date.getTime());
//			Log.e("time", date.toString());
            strDate = df.format(sDate);
            // System.out.println("strDate: " + strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strDate;
    }

	public String date4MDStr(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
				Locale.ENGLISH);
		// February 2 2015 11:39:02
		String strDate = new String();
		try {
			String s1 = s.replaceAll("\\,", "");
			Date date = sdf.parse(s1);
			SimpleDateFormat df = new SimpleDateFormat("M月d日",
					Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
//			Log.e("time", date.toString());
			strDate = df.format(sDate);
			// System.out.println("strDate: " + strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}

	public String date4HHMMStr(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
				Locale.ENGLISH);
		// February 2 2015 11:39:02
		String strDate = new String();
		try {
			String s1 = s.replaceAll("\\,", "");
			Date date = sdf.parse(s1);
			SimpleDateFormat df = new SimpleDateFormat("HH:mm",
					Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
//			Log.e("time", date.toString());
			strDate = df.format(sDate);
			// System.out.println("strDate: " + strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}

	public String date4DayStr(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
				Locale.ENGLISH);
		// February 2 2015 11:39:02
		String strDate = new String();
		Calendar c = Calendar.getInstance();
		String Week = "";
		try {
			String s1 = s.replaceAll("\\,", "");
			Date date = sdf.parse(s1);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",
					Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
//			Log.e("time", date.toString());
			strDate = df.format(sDate);

			c.setTime(df.parse(strDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			Week += "天";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 2) {
			Week += "一";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 3) {
			Week += "二";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 4) {
			Week += "三";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 5) {
			Week += "四";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 6) {
			Week += "五";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 7) {
			Week += "六";
		}
		return new StringBuffer().append("星期").append(Week).toString();
	}

	public String date4AMPMStr(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
				Locale.ENGLISH);
		// February 2 2015 11:39:02
		String strDate = new String();

		String APPM = "";
		try {
			String s1 = s.replaceAll("\\,", "");
			Date date = sdf.parse(s1);
			SimpleDateFormat df = new SimpleDateFormat("HH",
					Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
			strDate = df.format(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int time = Integer.parseInt(strDate);
		if(time<12){
			APPM+="上午";
		}else{
			APPM+="下午";
		}

		return APPM;
	}

	public String date4AMPMStrLong(String start, String end) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
				Locale.ENGLISH);
		// February 2 2015 11:39:02
		String strDate = new String();
		String endDate = new String();

		String APPM = "";
		try {
			String s1 = start.replaceAll("\\,", "");
			Date date = sdf.parse(s1);
			SimpleDateFormat df = new SimpleDateFormat("HH",
					Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
			strDate = df.format(sDate);

			String s2 = end.replaceAll("\\,", "");
			Date date2 = sdf.parse(s2);
			SimpleDateFormat df2 = new SimpleDateFormat("HH",
					Locale.CHINESE);
			java.sql.Date eDate = new java.sql.Date(date2.getTime());
			endDate = df2.format(eDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		int time1 = Integer.parseInt(strDate);
		int time2 = Integer.parseInt(endDate);
		if(time1<12 && time2<12){
			APPM+="上午";
		}else if(time1>12 && time2>12){
			APPM+="下午";
		}else{
			APPM+="全天";
		}

		return APPM;
	}

	public long sysTime() {
		@SuppressWarnings("unused")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		String time = simpleDateFormat.format(new Date());

        try {
            Date cudate = simpleDateFormat.parse(time);
            return cudate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
	}

	public long sysTime_() {
		@SuppressWarnings("unused")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String time = simpleDateFormat.format(new Date());

		try {
			Date cudate = simpleDateFormat.parse(time);
			return cudate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	public String sysTimeStr(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		return simpleDateFormat.format(curDate);
	}
	
	public long getTime(String time){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date format = simpleDateFormat.parse(time);
			return format.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long getTime_(String time){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date format = simpleDateFormat.parse(time);
			return format.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String date4Str2(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss",
				Locale.ENGLISH);
		// February 2 2015 11:39:02
		String strDate = new String();
		try {
			String s1 = s.replaceAll("\\,", "");
			Date date = sdf.parse(s1);

			SimpleDateFormat df = new SimpleDateFormat("dd-MM", Locale.CHINESE);
			java.sql.Date sDate = new java.sql.Date(date.getTime());
			strDate = df.format(sDate);
			// System.out.println("strDate: " + strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}

	public String getSysTime(Date date2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		return format.format(date2);
	}

	public int compareTime(String input_time){
		long systime = sysTime_();
		long currentTime = getTime_(input_time);

		if(systime>currentTime){//小于系统时间
			return 1;
		}else if(systime<currentTime){//大于系统时间
			return 2;
		}else{
			return 0;
		}
	}

	public int getCourseDay(String input_time) {
		long systime = sysTime_();
		long currentTime = getTime_(input_time);

		long d = (systime-currentTime) / (1000 * 60 * 60 * 24);

		return (int) d;
	}

	public String date4AMPMStr1(int leavetime) {
		String str="";
		switch (leavetime){
			case 1:
				str = "上午";
				break;
			case 2:
				str = "下午";
				break;
			case 4:
				str = "全天";
				break;
		}

		return str;
	}

	public int[] getsysTimeArr() {
		int [] time = new int[3];
		Calendar c = Calendar.getInstance();
		time[0] = c.get(Calendar.YEAR);
		time[1] = c.get(Calendar.MONTH) + 1;
		time[2] = c.get(Calendar.DAY_OF_MONTH);
		return time;
	}
}
