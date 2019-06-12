package com.xitech.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 一天的毫秒数
	 */
	private static final long DAY_TIME = 1000*60*60*24;
	

	/**
	 * <p>描述：计算两个日期相差的天数，不区分日期先后，日期的时、分、秒、毫秒均不考虑
	 * @param firstDate
	 * @param secondDate
	 * @return 返回两个日期相差的天数、不区分两个日期的先后顺序，日期的时、分、秒、毫秒均不考虑
	 */
	public static int dateDiff(Date firstDate,Date secondDate) {
		
		return Math.abs(dateDiffInOrder(firstDate,secondDate));
	}
	
	/**
	 * <p>描述：计算specificDate 与 baseDate相差的天数，需要区分日期的前后顺序，但是日期的时、分、秒、毫秒均不考虑</p>
	 * @param baseDate
	 * @param specificDate
	 * @return 返回specificDate 与 baseDate相差的天数，若specificDate在baseDate之前，则返回正数，若在baseDate之后，则返回负数
	 */
	public static int dateDiffInOrder(Date baseDate,Date specificDate) {
		Calendar baseCalendar = formatDate(baseDate);
		Calendar specificCalendar = formatDate(specificDate);
		return dateTimeDiffInOrder(baseCalendar.getTime(),specificCalendar.getTime());
	}
	
	/**
	 * <p>描述：计算两个日期相差的天数，日期的时、分、秒、毫秒均考虑，但是不区分日期先后
	 * @param firstDate
	 * @param secondDate
	 * @return 返回两个日期相差的天数、不区分两个日期的先后顺序
	 */
	public static int dateTimeDiff(Date firstDate,Date secondDate) {
		return Math.abs(dateTimeDiffInOrder(firstDate,secondDate));
	}
	
	/**
	 * <p>描述： 计算specificDate 与  baseDate相差的天数，日期的时、分、秒、毫秒、日期的先后均考虑在内</p>
	 * <ul>例如 ：
	 * <li>1970-12-01 15:15:15 与 1970-12-02 15:15:14相差0天</li>
	 * <li>1970-12-01 15:15:15 与 1970-12-02 15:15:15相差-1天</li>
	 * <li>1970-12-01 15:15:15 与 1970-11-30 15:15:15相差-1天</li>
	 * </ul>
	 * @param baseDate : 作为计算基准的日期
	 * @param specificDate : 指定的日期
	 * @return 返回specificDate 与 baseDate相差的天数，若specificDate在baseDate之前，则返回正数，若在baseDate之后，则返回负数
	 */
	public static int dateTimeDiffInOrder(Date baseDate,Date specificDate) {
		
		int dateTimeDiff = (int)((baseDate.getTime() - specificDate.getTime())/DAY_TIME);
		
		return dateTimeDiff;
	}
	
	private static Calendar formatDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND,0);
		
		return calendar;
	}
}
