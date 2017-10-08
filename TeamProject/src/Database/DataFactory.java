package Database;

import java.util.Calendar;
import java.util.Comparator;
import java.util.PriorityQueue;
import Constants.Constants;

public class DataFactory {

	DataPriority comparator;
	PriorityQueue<Data> priorityQueue;
	
	public class DataPriority implements Comparator<Object> {

		@Override
		public int compare(Object data1, Object data2) {
			
			Data dataA = (Data)data1;
			Data dataB = (Data)data2;
			
			return Integer.compare(dataA.getScore(), dataB.getScore());
		}
		
	}
	
	public DataFactory() {
		//initialize priority queue 
		priorityQueue = new PriorityQueue(20, comparator);
	}
	
	public void AddToPriorityQueue(Data data) {
		//to calculate
		data.DoCalculate();
		//add data to priority queue
		priorityQueue.add(data);
	}
	
}
