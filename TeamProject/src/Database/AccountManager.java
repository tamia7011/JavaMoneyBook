package Database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.Arrays;

import Constants.Constants;
import Moneybook.MainFrame;
import Moneybook.calendar.CalendarManager;

public class AccountManager {

	
	private static AccountManager dataManager;
	Date Today;
	private Account selectedData;
	private ArrayList<Account> DataList;//Money Data List
	DataPriority comparator;
	PriorityQueue<Account> priorityQueue; //Priority Queue List
	AccountDAO dac;
	int score;
	private AccountDAO accountDAO;

	public static AccountManager getInstance() {
		if(dataManager == null) {
			dataManager = new AccountManager();
			return dataManager;
		}
		return dataManager;
	}
	
	private AccountManager() {
		init();
	}
	
	private void init() {
		comparator = new DataPriority();
		priorityQueue = new PriorityQueue<Account>(20, comparator);
		score = 0;
		DataList = accountDAO.selectAll();
	}
	
	public void setCurrentData(Date date) {
		for(Account data : DataList) {
			if(data.getDate().equals(date)) {
				selectedData = data;
				return;
			}
		}
		selectedData = null;
	}
	
	public void setFutureData(Date date) {
		for(Account data : DataList) {
			if(data.getDate().after(date)) {
				priorityQueue.add(data);
			}
		}
	}
	
	// calculating scores
	public int getScore(Account data) {
		int priceScore = data.getPrice() / 1000;
		int typeScore;

		String type= data.getType(); 
		
		if (type == Constants.expenseType.Fixed.toString()){
			typeScore = 1000;
		}
		else if (type ==  Constants.expenseType.Flexible.toString()) {
			typeScore = 700;
		}
		else if (type == Constants.expenseType.Waste.toString()){
			typeScore = 0;
		}		
		return score; 
	}
	
	
	public class DataPriority implements Comparator<Object> {

		@Override
		public int compare(Object data1, Object data2) {
			
			Account dataA = (Account)data1;
			Account dataB = (Account)data2;
			
			return Integer.compare(getScore(dataA), getScore(dataB));
		}
		
	}
	
	
	public void SetPriorityQueue(ArrayList<Account> arraylist) {
		//add data to priority queue
		Iterator<Account> it = arraylist.iterator();
		while (it.hasNext()){
			priorityQueue.add((Account) it.next());
		}
	}
	
	public void AddToPriorityQueue(Account account) {
		//add data to priority queue
		priorityQueue.add(account);
	}
	
	public ArrayList<Account> poll(int num){
		ArrayList<Account> temp = new ArrayList<Account>();
		for (int i = 0; i < num; i++) {
			temp.add(priorityQueue.poll());
		}
		return temp;
	}
}
