package Moneybook.calender;

import java.util.Calendar;

public class CalenderManager {

	final int CAL_WIDTH = 7;
	final int CAL_HEIGHT = 6;
	Calendar currentCal;
	int calYear;
	int calMonth;
	int calDayOfMon;
	int calLastDate;
	
	public int getCalDayOfMon() {
		return calDayOfMon;
	} 
	public int getCalLastDate() {
		return calLastDate;
	} 
	public Calendar getCurrentCal() {
		return currentCal;
	}
	public int getCalYear() {
		return calYear;
	}
	public int getCalMonth() {
		return calMonth;
	}

	final int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	
	public CalenderManager() {
		currentCal = Calendar.getInstance(); 
		
	}
	
	public void makeCalData(int[][] calDates){
		// 1일의 위치와 마지막 날짜를 구함 
		int calStartingPos = (currentCal.get(Calendar.DAY_OF_WEEK)+7-(currentCal.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1) calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);
		else calLastDate = calLastDateOfMonth[calMonth];
		// 달력 배열 초기화
		for(int i = 0 ; i<CAL_HEIGHT ; i++){
			for(int j = 0 ; j<CAL_WIDTH ; j++){
				calDates[i][j] = 0;
			}
		}
		// 달력 배열에 값 채워넣기
		for(int i = 0, num = 1, k = 0 ; i<CAL_HEIGHT ; i++){
			if(i == 0) k = calStartingPos;
			else k = 0;
			for(int j = k ; j<CAL_WIDTH ; j++){
				if(num <= calLastDate) calDates[i][j]=num++;
			}
		}
	}
	
	private int leapCheck(int year){ // 윤년인지 확인하는 함수
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) return 1;
		else return 0;
	}
	
	
}
