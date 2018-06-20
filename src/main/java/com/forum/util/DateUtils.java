package com.forum.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils {
	// һ��ĺ����� 60*60*1000*24
	public final static long DAY_MILLIS = 86400000;

	// һСʱ�ĺ����� 60*60*1000
	private final static long HOUR_MILLIS = 3600000;

	// һ���ӵĺ����� 60*1000
	private final static long MINUTE_MILLIS = 60000;
	
	/**Ĭ��ʱ������**/
	private final static String DEFAULT_TIME_ZONE = "Asia/Shanghai";
	
	/**
	 * �������ʽ��ǰ����
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrentDate(String format) {
		return formatDate(Calendar.getInstance().getTime(), format);
	}
	
	/**
	 * ��ʽ������
	 * 
	 * @param format ����Ϊyyyy-MM-dd��yyyy-MM-dd HH:mm:ss��
	 * @return
	 */
	public static String formatDate(Date date, String format){		
		if(date == null) return "";
		return DateFormatUtils.format(date, format, TimeZone.getTimeZone(DEFAULT_TIME_ZONE), Locale.getDefault(Locale.Category.FORMAT));
	}
	
	/**
	 * ����ת��
	 * 
	 * @param format ����Ϊyyyy-MM-dd��yyyy-MM-dd HH:mm:ss��
	 * @return
	 */
	public static Date parseDate(String dateStr, String format) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
		java.text.ParsePosition pos = new java.text.ParsePosition(0);
		return formatter.parse(dateStr, pos);
	}
	
	/**
	 * ���ں�ʱ���ȡ������ 
	 * ��dt:yyyy-MM-dd HH:mm:ss ����yyyy-MM-dd
	 *
	 * @param dt
	 * @return
	 */
	public static Date truncateDate(Date dt) {
		return org.apache.commons.lang3.time.DateUtils.truncate(dt, Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * ����N��������
	 * 
	 * @param date
	 * @param par
	 * @return
	 */
	public static Date getAfterDay(Date date, int par) {
		return org.apache.commons.lang3.time.DateUtils.truncate(org.apache.commons.lang3.time.DateUtils.addDays(date, par), Calendar.DAY_OF_MONTH);
	}

	/**
	 * ����N���º������
	 * 
	 * @param date
	 * @param par
	 * @return
	 */
	public static Date getAfterMonth(Date date, int par) {
		return org.apache.commons.lang3.time.DateUtils.truncate(org.apache.commons.lang3.time.DateUtils.addMonths(date, par), Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * ����N���º�����ڣ���˳�ӣ�����1��31�ż�1����Ϊ2��28�ţ���˳��һ���Ϊ3��1��
	 *
	 * @param date
	 * @param par
	 * @return
	 */
	public static Date getAfterMonthNext(Date date, int par) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		int oldDate = c.get(Calendar.DAY_OF_MONTH);
		c.add(Calendar.MONTH, par);
		int newDate = c.get(Calendar.DAY_OF_MONTH);
		// �ж����������Ƿ�С�ھ�����������С�������������28 < 30, 30 < 31֮��ģ���˳��
		if(newDate < oldDate) {
			c.add(Calendar.DATE, 1); // ��1��
		}		
		return org.apache.commons.lang3.time.DateUtils.truncate(c.getTime(), Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * ��ȡָ������ ָ�����Ӻ������
	 * 
	 * @param monthNum
	 * @return
	 */
	public static Date getDateAfterByMinute(Date date, Integer minute) {		
		return org.apache.commons.lang3.time.DateUtils.addMinutes(date, minute);
	}
	
	/**
	 * ��ȡĳ���µĵ�һ��
	 * @param dt
	 * @param formatStr
	 * @return
	 */
	public static String getFirstDay(Date dt,String formatStr) {	
		return formatDate(org.apache.commons.lang3.time.DateUtils.truncate(dt, Calendar.MONTH), formatStr);
	}
   
	/**
	 * ��ȡĳ���µ����һ��
	 * �㷨���£�1)ȡ���µ�һ�� 2)���¼�1 3)���ڼ�һ
	 * @param dt
	 * @param formatStr
	 * @return
	 */
	public static String getLastDay(Date dt,String formatStr) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(dt);
		ca.set(Calendar.DAY_OF_MONTH, 1); 
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DATE, -1);
		return formatDate(ca.getTime(), formatStr);
	}
	
	/**
 	 * 
 	 * ������������֮������
 	 * 
 	 * @param beginDate
 	 *            ��ʼ���� 
 	 * @param endDate
 	 *            ��ֹ���� 
 	 * @return �������
 	 * @author zhoudl
 	 */
	public static int datePhaseDiffer(Date beginDate, Date endDate) {
 		try {
 			return (int) ((endDate.getTime() - beginDate.getTime()) / DAY_MILLIS);
 		} catch (Exception e) {
 			throw new RuntimeException(e);
 		}
 	}
 	
 	/**
 	 * ������������֮����Сʱ
 	 *
 	 * @author  wangjf
 	 * @date    2015��7��2�� ����3:37:23
 	 * @param beginDate
 	 * @param endDate
 	 * @return
 	 */
 	public static int hourPhaseDiffer(Date beginDate, Date endDate) {
 		try {
 			return (int) ((endDate.getTime() - beginDate.getTime()) / HOUR_MILLIS);
 		} catch (Exception e) {
 			throw new RuntimeException(e);
 		}
 	}
 	
 	/**
 	 * ������������֮��������
 	 *
 	 * @author  wangjf
 	 * @date    2015��7��2�� ����3:37:26
 	 * @param beginDate
 	 * @param endDate
 	 * @return
 	 */
 	public static int minutePhaseDiffer(Date beginDate, Date endDate) {
 		try {
 			return (int) ((endDate.getTime() - beginDate.getTime()) / MINUTE_MILLIS);
 		} catch (Exception e) {
 			throw new RuntimeException(e);
 		}
 	}
 	
 	/**
 	 * ������������֮������
 	 *
 	 * @author  wangjf
 	 * @date    2015��7��2�� ����3:37:53
 	 * @param beginDate
 	 * @param endDate
 	 * @return
 	 */
 	public static int secondPhaseDiffer(Date beginDate, Date endDate) {
 		try {
 			return (int) ((endDate.getTime() - beginDate.getTime()) / 1000);
 		} catch (Exception e) {
 			throw new RuntimeException(e);
 		}
 	}
		
	/**
	 * �ж���������֮����������
	 * 
	 * @param begindate
	 * @param enddate
	 * @return
	 * @author HuangXiaodong 2014-10-08, 20:28:47
	 * @modified
	 */
	public static int monthPhaseDiffer(Date begindate, Date enddate) {
		try {
			int year1 = getYear(begindate);
			int month1 = getMonth(begindate);
			int day1 = getDay(begindate);
			int year2 = getYear(enddate);
			int month2 = getMonth(enddate);
			int day2 = getDay(enddate);
			int month = (year2 - year1) * 12 + month2 - month1;
			if (day2 - day1 > 0)
				return month + 1;
			else
				return month;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * �����������������졢Сʱ������
	 * 
	 * @param start
	 * @param end
	 */
	public static String show(Date start, Date end) {
		long temp = end.getTime() - start.getTime();
		String leavingTime = temp / DAY_MILLIS + "��" + (temp % DAY_MILLIS) / HOUR_MILLIS + "Сʱ" + ((temp % DAY_MILLIS) % HOUR_MILLIS) / MINUTE_MILLIS + "��";
		return leavingTime;
	}

	/**
	 * 
	 * ��ȡ�����е����
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date dt) {	
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * ��ȡ�����е��·�
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static int getMonth(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.MONTH);
	}
	
	/**
	 * ��ȡ�����е���
	 *
	 * @param dt
	 * @return
	 */
	public static int getDay(Date dt)  {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.DATE);
	}

	/**
	 * �Ƚ���������
	 * date1 >= date2 ����true�����򷵻�false
	 * @param date1
	 * @param date2
	 * @param day
	 * @return
	 */
	public static boolean compare_date(Date date1, Date date2) {
		boolean flag = false;
		if (date1.getTime() >= date2.getTime()) {
			return true;
		}
		return flag;
	}

	/**
	 * ȡ�¸���������
	 * ��  date:2015-11-16 day:10 �򷵻�2015-12-10
	 *   date:2015-12-01 day:10 �򷵻�2016-01-10
	 * @param date
	 * @param day
	 * @return
	 */
	static public Date nextPayDate(Date date, String day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int dateDD = cal.get(Calendar.DAY_OF_MONTH);
		int dd = Integer.parseInt(day);
		cal.set(Calendar.DAY_OF_MONTH, dd);
		if (dateDD >= dd) {
			cal.add(Calendar.MONTH, 1);
		}
		return cal.getTime();
	}

	/**
	 * ��һ�����հ��������յ���
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	static public Date nextPayDateIncludeToday(Calendar date, String day) {
		Objects.requireNonNull(date);
		int dateDD = date.get(Calendar.DAY_OF_MONTH);
		int dd = Integer.parseInt(day);
		date.set(Calendar.DAY_OF_MONTH, dd);
		if (dateDD > dd) {
			date.add(Calendar.MONTH, 1);
		}
		return date.getTime();
	}
	
	/**
	 * ��ȡ��һ��������
	 * 
	 * @param day
	 * @return
	 */
	public static Calendar lastPayDateWithPattern(Date date, String day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dd = Integer.parseInt(day);
		int date_dd = cal.get(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, dd);
		if (date_dd < dd) {
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		}
		return cal;
	}
	
	 /**
 	 * ҳ����ʾ�������� ��ʾ����ʽ��yyyyMMdd
 	 * @param date
 	 * @return 
 	 * @author zhoudl
 	 */
 	public static String showDateString(Date date){
 		if (null == date ){
 			throw new RuntimeException("���ڲ���Ϊ��");
 		}
 		return formatDate(date, "yyyyMMdd");
 	}

	/**
	 * ��ȡĳ����ʼʱ��
	 *
	 * @author  wangjf
	 * @date    2015��4��30�� ����2:26:36
	 * @param date
	 * @return
	 */
	public static Date getStartDate(Date date){
		return truncateDate(date);
	}
	
	/**
	 * ��ȡĳ�����ʱ��
	 *
	 * @author  wangjf
	 * @date    2015��4��30�� ����2:26:48
	 * @param date
	 * @return
	 */
	public static Date getEndDate(Date date){
		return parseDate(DateUtils.formatDate(date, "yyyy-MM-dd") + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * ��ȡ�ڶ�������
	 *
	 * @author  wangjf
	 * @date    2015��11��19�� ����8:29:37
	 * @param date
	 * @return
	 */
	public static Date getNextDate(Date date) {
		return getAfterDay(getStartDate(date), 1);
	}
	
	/**
	 * ��ȡ���µ�һ����ʼʱ��
	 *
	 * @author  wangjf
	 * @date    2015��4��30�� ����3:45:24
	 * @param date
	 * @return
	 */
	public static Date getMonthStartDate(Date date){	
		return org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.MONTH);
	}
	
	/**
	 * ��yyyy-MM-dd��ʽ���ַ���תΪ���ڸ�ʽ
	 *
	 * @author  wangjf
	 * @date    2015��5��1�� ����3:40:42
	 * @param dateStr
	 * @return
	 */
	public static Date parseStandardDate(String dateStr){
		return DateUtils.parseDate(dateStr, "yyyy-MM-dd");
	}
		
	/**
	 * ����Dateת��ΪTimestamp
	 * **/
	public static Timestamp getDateToTimeStamp(Date paramDate){	
		if(paramDate==null){
			return null;
		}
		return new Timestamp(paramDate.getTime());
	}
		
	/**
	 * ָ������֮ǰ��ĳ���̶�ʱ��
	 * **/
	public static Timestamp getTimeStamp(Date currDate,int num){
		if(currDate==null){
			throw new RuntimeException("���ڶ�����Ϊ��");
		}		
		return new Timestamp(getAfterMonth(currDate, -num).getTime());
	}
	
	public static Date getLastEndOfMonth(Date dt) {
		Date firstDay = org.apache.commons.lang3.time.DateUtils.truncate(dt, Calendar.MONTH);
		return getAfterDay(firstDay, -1);
	}
	

}
