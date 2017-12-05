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
	private Account selectedData;
	private ArrayList<Account> DataList;// Money Data List
	private ArrayList<Account> futureList;// Future Data List
	DataPriority comparator;
	PriorityQueue<Account> priorityQueue; // Priority Queue List
	AccountDAO dac;
	int score;
	private AccountDAO accountDAO;

	public static AccountManager getInstance() {
		if (dataManager == null) {
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
		accountDAO = AccountDAO.getInstance();
		DataList = new ArrayList<Account>();
		futureList = new ArrayList<Account>();
		score = 0;
	}

	public ArrayList<Account> getDataList() {
		DataList = new ArrayList<Account>();
		DataList = accountDAO.selectAll();
		return DataList;
	}

	public void setFutureData(Date date) {
		futureList = new ArrayList<Account>();
		ArrayList<Account> list = getDataList();
		for (Account data : list) {
			if (data.getDate().after(date)) {
				futureList.add(data);
			}
		}
		for (Account data : futureList) {
			System.out.println(data.getDate());
		}
	}

	public PriorityQueue<Account> getFuturePriorityQueue(Date date) {
		setFutureData(date);
		SetPriorityQueue(futureList);
		return priorityQueue;
	}

	// calculating scores
	public int getScore(Account data) {
		int priceScore = data.getPrice();
		int typeScore = 0;

		String type = data.getType();

		if (type == Constants.expenseType.Fixed.toString()) {
			typeScore = 1000;
		} else if (type == Constants.expenseType.Flexible.toString()) {
			typeScore = 700;
		} else if (type == Constants.expenseType.Waste.toString()) {
			typeScore = 0;
		}
		score = priceScore + typeScore;
		return score;
	}

	public class DataPriority implements Comparator<Object> {

		@Override
		public int compare(Object data1, Object data2) {

			Account dataA = (Account) data1;
			Account dataB = (Account) data2;
			if (getScore(dataA) < getScore(dataB))
				return 1;
			else if (getScore(dataA) > getScore(dataB))
				return -1;
			else
				return 0;
		}

	}

	public void SetPriorityQueue(ArrayList<Account> arraylist) {

		priorityQueue.clear();
		Iterator<Account> it = arraylist.iterator();
		while (it.hasNext()) {
			priorityQueue.add((Account) it.next());
		}
	}

	public ArrayList<Account> PollPriorityQueue(int num, Date date) {

		priorityQueue = getFuturePriorityQueue(date);
		ArrayList<Account> temp = new ArrayList<Account>();
		for (int i = 0; i < num; i++) {
			temp.add(priorityQueue.poll());
		}
		return temp;
	}

	public PriorityQueue<Account> get() {
		return priorityQueue;
	}
}
