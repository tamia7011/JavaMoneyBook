package Database;

public class Mileagesystem {
	private static double setfixedExpense;
	private static double setflexibleExpense;
	private static double setdiscretionaryExpense;
	private int mileage;
	MonthAccount monthaccount;
	public int mileage() {
		mileage = 2000;
		setfixedExpense = monthaccount.salary*0.5;
		setflexibleExpense = monthaccount.salary*0.3;
		setdiscretionaryExpense = monthaccount.salary*0.2;
		
		if (monthaccount.getFixedExpenses() >= setfixedExpense) {
			mileage += (setfixedExpense - monthaccount.getFixedExpenses()) / 10000;
		} else {
			mileage += (setfixedExpense - monthaccount.getFixedExpenses()) / 10000;
		}
		
		if (monthaccount.getFlexibleExpenses() >= setflexibleExpense) {
			mileage += (setflexibleExpense - monthaccount.getFlexibleExpenses()) / 10000;
		} else {
			mileage += (setflexibleExpense - monthaccount.getFlexibleExpenses()) / 10000;
		}
		
		if (monthaccount.getDiscretionaryExpenses() >= setdiscretionaryExpense) {
			mileage += (setdiscretionaryExpense - monthaccount.getDiscretionaryExpenses()) / 10000;
		} else {
			mileage += (setdiscretionaryExpense - monthaccount.getDiscretionaryExpenses()) / 10000;
		}
		
		return mileage;
	}
	public void rating() {
		int grade = mileage/500;
		switch(grade){
	      case 10 : System.out.println("S");
	      break;
	      case 9 : System.out.println("A");
	      break;
	      case 8 : System.out.println("B");
	      break;
	      case 7 : System.out.println("C");
	      break;
	      case 6 : System.out.println("D");
	      break;
	      default : System.out.println("F");
	      break;
	    }
	}
}