package Database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import Constants.Constants;
import Moneybook.MainFrame;

public class DataManager {

	static DataManager dataManager;
	DataPriority comparator;
	PriorityQueue<MoneyData> priorityQueue;
	DataAccessObject dac;
	int score;

	public static DataManager getInstance() {
		if(dataManager == null) {
			dataManager = new DataManager();
			return dataManager;
		}
		return dataManager;
	}
	
	private DataManager() {
		init();
	}
	
	private void init() {
		comparator = new DataPriority();
		priorityQueue = new PriorityQueue<MoneyData>();
		score = 0;
	}
	
	
	// calculating scores
	public int getScore(MoneyData data) {
		int priceScore = data.price / 1000;
		int typeScore;
		
		if (data.type.equals("fixed")){
			typeScore = 1000;
		}
		else if (data.type.equals("Flexible")) {
			typeScore = 700;
		}
		else {
			typeScore = 0;
		}		
		score = typeScore + priceScore;
		return score; 
	}
	
	
	public class DataPriority implements Comparator<Object> {

		@Override
		public int compare(Object data1, Object data2) {
			
			MoneyData dataA = (MoneyData)data1;
			MoneyData dataB = (MoneyData)data2;
			
			return Integer.compare(getScore(dataA), getScore(dataB));
		}
		
	}
	
	
	public void AddToPriorityQueue(ArrayList<MoneyData> arraylist) {
		//add data to priority queue
		Iterator it = arraylist.iterator();
		while (it.hasNext()){
			priorityQueue.add((MoneyData) it.next());
		}
	}
	
}
