package Moneybook.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Constants.Constants;

public class CalendarManager {
    private static CalendarManager instance;
    
	//Calendar Data.
	private static Calendar calendarData = Calendar.getInstance();

	public static String getDate() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date time = calendarData.getTime();
		String date = format.format(time);   
		return date;
	}
	
	public Calendar getCalendarData() {
		return calendarData;
	}
	
	public static CalendarManager getInstance(){
	    if(instance == null){
	        instance = new CalendarManager();
	        return instance;
        }
        return instance;
    }
 
	public void makeCalendarFormatData(int[][] calDates){
        int calYear = calendarData.get(Calendar.YEAR);
        int calMonth = calendarData.get(Calendar.MONTH);
        int calLastDate;

		int calStartingPos = (calendarData.get(Calendar.DAY_OF_WEEK)+7-(calendarData.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1){
		    calLastDate = Constants.calLastDateOfMonth[calMonth] + leapCheck(calYear);
        } else{
		    calLastDate = Constants.calLastDateOfMonth[calMonth];
        }
		for(int i = 0 ; i<Constants.CAL_HEIGHT ; i++){
			for(int j = 0 ; j<Constants.CAL_WIDTH ; j++){
				calDates[i][j] = 0;
			}
		}
		for(int i = 0, num = 1, k = 0 ; i<Constants.CAL_HEIGHT ; i++){
			if(i == 0) k = calStartingPos;
			else k = 0;
			for(int j = k ; j<Constants.CAL_WIDTH ; j++){
				if(num <= calLastDate) calDates[i][j]=num++;
			}
		}
	}
	
	private int leapCheck(int year){
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) return 1;
		else return 0;
	}


	
}
