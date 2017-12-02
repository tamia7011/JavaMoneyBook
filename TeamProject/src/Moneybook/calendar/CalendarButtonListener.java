package Moneybook.calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;

import Moneybook.content.ContentsPanel;

public class CalendarButtonListener implements ActionListener{
 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CalenderPanel calenderPanel = CalenderPanel.getInstance();
		ContentsPanel contentsPanel = ContentsPanel.getInstance();
		
		JButton[][] dateButs = calenderPanel.getButtonForm();
		int k=0,l=0;
		for(int i=0 ; i<CalenderPanel.CAL_HEIGHT ; i++){
			for(int j=0 ; j<CalenderPanel.CAL_WIDTH ; j++){
				if(e.getSource() == dateButs[i][j]){ 
					k=i;
					l=j;
				}
			}
		}
		

		Calendar today = Calendar.getInstance();
        Calendar calendarData = CalendarManager.getCalendarData();
        int calYear = calendarData.get(Calendar.YEAR);
        int calMonth = calendarData.get(Calendar.MONTH);
		int calDayOfMon = calendarData.get(Calendar.DAY_OF_MONTH);

		int[][] dateForm = calenderPanel.getDateForm();
		
		if(!(k ==0 && l == 0)) calDayOfMon = dateForm[k][l];
		
		//DDAY
		Calendar cal = new GregorianCalendar(calYear,calMonth,calDayOfMon); 
		String dDayString = new String();
		int dDay=((int)((cal.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24));
		if(dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR))
				&& (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH))) dDayString = "Today";
		else if(dDay >=0) dDayString = "D-"+(dDay+1);
		else if(dDay < 0) dDayString = "D+"+(dDay)*(-1);
		
		//selectedDate.setText("<Html><font size=3>"+(calMonth+1)+"/"+calDayOfMon+"/"+calYear+"&nbsp;("+dDayString+")</html>");
		
		
		
		CalendarManager.setCalendarDay(dateForm[k][l]);
		System.out.println(CalendarManager.getDate());
		contentsPanel.show(cal);
		
	}

}
