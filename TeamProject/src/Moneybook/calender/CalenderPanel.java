package Moneybook.calender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Moneybook.MainFrame;

public class CalenderPanel extends JPanel {

	final String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	private static CalenderPanel instance;
	
	
	public CalenderManager calenderManager; 
	
	public static final int CAL_WIDTH = 7;
	public static final int CAL_HEIGHT = 6;
	private int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH];
	
	private JButton dateButs[][] = new JButton[CAL_HEIGHT][CAL_WIDTH];
	
	
	public static CalenderPanel getInstance() {
		if( instance == null) {
			instance = new CalenderPanel();
			return instance;
		}
		return instance;
	}
	private CalenderPanel() { 
		calenderManager = new CalenderManager();
		init();
	}

	private void init() { 
		CalenderButtonListener buttonlistener = new CalenderButtonListener();
		
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
				dateButs[i][j]=new JButton();
				dateButs[i][j].setBorderPainted(false);
				dateButs[i][j].setContentAreaFilled(false);
				dateButs[i][j].setBackground(Color.WHITE);
				dateButs[i][j].setOpaque(true);
				dateButs[i][j].addActionListener(buttonlistener);
				calPanel.add(dateButs[i][j]);
			}
		}
		calPanel.setLayout(new GridLayout(0,7,2,2));
		calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
 
		add(calPanel);
		
		changeDateForm();
	}
	
	public void changeDateForm() {
		calenderManager.makeCalData(calDates);
		showCal();
	}
	
	private void showCal(){
		Calendar today = calenderManager.getCurrentCal();
		int calYear = calenderManager.getCalYear();
		int calMonth = calenderManager.getCalMonth();
		
		for(int i=0;i<CAL_HEIGHT;i++){
			for(int j=0;j<CAL_WIDTH;j++){
				String fontColor="black";
				if(j==0) fontColor="red";
				else if(j==6) fontColor="blue";
				
				File f =new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDates[i][j]<10?"0":"")+calDates[i][j]+".txt");
				if(f.exists()){
					dateButs[i][j].setText("<html><b><font color="+fontColor+">"+calDates[i][j]+"</font></b></html>");
				}
				else dateButs[i][j].setText("<html><font color="+fontColor+">"+calDates[i][j]+"</font></html>");

				JLabel todayMark = new JLabel("<html><font color=green>*</html>");
				
				dateButs[i][j].removeAll();
				if(calMonth == today.get(Calendar.MONTH) &&
						calYear == today.get(Calendar.YEAR) &&
						calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)){
					//dateButs[i][j].add(todayMark);
					dateButs[i][j].setToolTipText("Today");
				}
				
				if(calDates[i][j] == 0) dateButs[i][j].setVisible(false);
				else dateButs[i][j].setVisible(true);
			}
		}
	}
	

	public JButton[][] getDateButs() {
		return dateButs;
	}
	public int[][] getCalDates(){
		return calDates;
	}
	
	 

}
