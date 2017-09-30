package Moneybook.calender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;

import Moneybook.content.ContentsPanel;

public class CalenderButtonListener implements ActionListener{
 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CalenderPanel calenderPanel = CalenderPanel.getInstance();
		ContentsPanel contentsPanel = ContentsPanel.getInstance();
		
		JButton[][] dateButs = calenderPanel.getDateButs();
		// TODO Auto-generated method stub
		int k=0,l=0;
		for(int i=0 ; i<CalenderPanel.CAL_HEIGHT ; i++){
			for(int j=0 ; j<CalenderPanel.CAL_WIDTH ; j++){
				if(e.getSource() == dateButs[i][j]){ 
					k=i;
					l=j;
				}
			}
		}
		
		CalenderManager calenderManager = calenderPanel.calenderManager;
		Calendar today = calenderManager.getCurrentCal();
		int calYear = calenderManager.getCalYear();
		int calMonth = calenderManager.getCalMonth();
		int calDayOfMon = calenderManager.getCalDayOfMon();
		int[][] calDates = calenderPanel.getCalDates();
		
		if(!(k ==0 && l == 0)) calDayOfMon = calDates[k][l]; //today버튼을 눌렀을때도 이 actionPerformed함수가 실행되기 때문에 넣은 부분

		Calendar cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
		
		String dDayString = new String();
		int dDay=((int)((cal.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24));
		if(dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR)) 
				&& (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH))) dDayString = "Today"; 
		else if(dDay >=0) dDayString = "D-"+(dDay+1);
		else if(dDay < 0) dDayString = "D+"+(dDay)*(-1);
		
		//selectedDate.setText("<Html><font size=3>"+(calMonth+1)+"/"+calDayOfMon+"/"+calYear+"&nbsp;("+dDayString+")</html>");
		
		contentsPanel.show(cal);
		
	}

}
