package Moneybook.calendar;

import java.util.Calendar;

public class CalendarManager {
    private static CalendarManager instance;

    final int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	final int CAL_WIDTH = 7;
	final int CAL_HEIGHT = 6;

	//Calendar Data.
	private Calendar calendarData;

	public static CalendarManager getInstance(){
	    if(instance == null){
	        instance = new CalendarManager();
	        return instance;
        }
        return instance;
    }

	public Calendar getCalendarData() {
		return calendarData;
	}

	
	private CalendarManager() {
	    //default calendar Data is current Time.
		calendarData = Calendar.getInstance();
	}

	public void makeCalendarFormatData(int[][] calDates){
        int calYear = calendarData.get(Calendar.YEAR);
        int calMonth = calendarData.get(Calendar.MONTH);
        int calLastDate;

		int calStartingPos = (calendarData.get(Calendar.DAY_OF_WEEK)+7-(calendarData.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1){
		    calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);
        } else{
		    calLastDate = calLastDateOfMonth[calMonth];
        }
		for(int i = 0 ; i<CAL_HEIGHT ; i++){
			for(int j = 0 ; j<CAL_WIDTH ; j++){
				calDates[i][j] = 0;
			}
		}
		for(int i = 0, num = 1, k = 0 ; i<CAL_HEIGHT ; i++){
			if(i == 0) k = calStartingPos;
			else k = 0;
			for(int j = k ; j<CAL_WIDTH ; j++){
				if(num <= calLastDate) calDates[i][j]=num++;
			}
		}
	}
	
	private int leapCheck(int year){
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) return 1;
		else return 0;
	}


	
}
