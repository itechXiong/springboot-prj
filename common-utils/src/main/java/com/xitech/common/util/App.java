package com.xitech.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
	        Date curDate = new Date();
	        String testDateStr = "2019-06-11";
	        String testDateStrs = "2019-06-14 15:00:01 129";
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
	        Date testDate = null;
			testDate = format.parse(testDateStr);
			testDate = format.parse(testDateStr);
			
			System.out.println(DateUtil.isDateInRange(curDate, testDate, 2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
