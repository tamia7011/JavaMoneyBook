package Moneybook.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalenderPanel extends JPanel {

	final String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	private static CalenderPanel instance;
	
	
	private CalendarManager calendarManager;
	
	public static final int CAL_WIDTH = 7;
	public static final int CAL_HEIGHT = 6;

	private int dateForm[][] = new int[CAL_HEIGHT][CAL_WIDTH];
	private JButton buttonForm[][] = new JButton[CAL_HEIGHT][CAL_WIDTH];
	
	
	public static CalenderPanel getInstance() {
		if( instance == null) {
			instance = new CalenderPanel();
			return instance;
		}
		return instance;
	}
	private CalenderPanel() { 
		calendarManager = CalendarManager.getInstance();
		init();
	}

	private void init() { 
		CalendarButtonListener calendarButtonlistener = new CalendarButtonListener();
		
		JPanel calPanel=new JPanel();
		calPanel.setPreferredSize(new Dimension(700,500));
		JButton[] weekDaysName = new JButton[7];
		for(int i=0 ; i<CAL_WIDTH ; i++){
			weekDaysName[i]=new JButton(WEEK_DAY_NAME[i]);
			weekDaysName[i].setBorderPainted(false);
			weekDaysName[i].setContentAreaFilled(false);
			weekDaysName[i].setForeground(Color.WHITE);
			if(i == 0) weekDaysName[i].setBackground(new Color(200, 50, 50));
			else if (i == 6) weekDaysName[i].setBackground(new Color(50, 100, 200));
			else weekDaysName[i].setBackground(new Color(150, 150, 150));
			weekDaysName[i].setOpaque(true);
			weekDaysName[i].setFocusPainted(false);
			calPanel.add(weekDaysName[i]);
		}
		for(int i=0 ; i<CAL_HEIGHT ; i++){
			for(int j=0 ; j<CAL_WIDTH ; j++){
				buttonForm[i][j]=new JButton();
				buttonForm[i][j].setBorderPainted(false);
				buttonForm[i][j].setContentAreaFilled(false);
				buttonForm[i][j].setBackground(Color.WHITE);
				buttonForm[i][j].setOpaque(true);
				buttonForm[i][j].addActionListener(calendarButtonlistener);
				calPanel.add(buttonForm[i][j]);
			}
		}
		calPanel.setLayout(new GridLayout(0,7,2,2));
		calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
 
		add(calPanel);
		//repaint calendar with calendarData.
		validateCalendar();
	}
	
	public void validateCalendar() {
		calendarManager.makeCalendarFormatData(dateForm);
		showCalendar();
	}
	
	private void showCalendar(){
        Calendar today = Calendar.getInstance();
        int calYear = calendarManager.getCalendarData().get(Calendar.YEAR);
        int calMonth =  calendarManager.getCalendarData().get(Calendar.MONTH);
		
		for(int i=0;i<CAL_HEIGHT;i++){
			for(int j=0;j<CAL_WIDTH;j++){
				String fontColor="black";
				if(j==0) fontColor="red";
				else if(j==6) fontColor="blue";
				
				File f =new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(dateForm[i][j]<10?"0":"")+ dateForm[i][j]+".txt");
				if(f.exists()){
					buttonForm[i][j].setText("<html><b><font color="+fontColor+">"+ dateForm[i][j]+"</font></b></html>");
				}
				else buttonForm[i][j].setText("<html><font color="+fontColor+">"+ dateForm[i][j]+"</font></html>");

				JLabel todayMark = new JLabel("<html><font color=green>*</html>");
				
				buttonForm[i][j].removeAll();
				if(calMonth == today.get(Calendar.MONTH) &&
						calYear == today.get(Calendar.YEAR) &&
						dateForm[i][j] == today.get(Calendar.DAY_OF_MONTH)){
					buttonForm[i][j].add(todayMark);
					buttonForm[i][j].setToolTipText("Today");
				}
				
				if(dateForm[i][j] == 0) buttonForm[i][j].setVisible(false);
				else buttonForm[i][j].setVisible(true);
			}
		}
	}
	

	public JButton[][] getButtonForm() {
		return buttonForm;
	}
	public int[][] getDateForm(){
		return dateForm;
	}
	
	 

}
