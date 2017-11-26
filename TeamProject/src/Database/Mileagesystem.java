package Database;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Moneybook.MainFrame;

public class Mileagesystem {
	private static double setfixedExpense;
	private static double setflexibleExpense;
	private static double setdiscretionaryExpense;
	private int mileage;
	private int Fixedmileage;
	private int Flexiblemileage;
	private int Discretionarymileage;
	static Mileagesystem instance;
	MonthAccount monthaccount;
	
	public static Mileagesystem getInstance() {
		if(instance == null) {
			instance = new Mileagesystem();
			return instance;
		}
		return instance;
	}
	
	private Mileagesystem()  {
		init(); 
	}

	public void init() {
		mileage = 2000;
		Fixedmileage = 0;
		Flexiblemileage = 0;
		Discretionarymileage = 0;
		setfixedExpense = monthaccount.getSalary()*0.5;
		setflexibleExpense = monthaccount.getSalary()*0.3;
		setdiscretionaryExpense = monthaccount.getSalary()*0.2;
	}
	
	public void calculating() {
		Fixedmileage += (setfixedExpense - monthaccount.getFixedExpenses()) / 10000;
		Flexiblemileage += (setflexibleExpense - monthaccount.getFlexibleExpenses()) / 10000;
		Discretionarymileage += (setdiscretionaryExpense - monthaccount.getDiscretionaryExpenses()) / 10000;
		mileage += (Fixedmileage + Flexiblemileage + Discretionarymileage);
	}
	
	public void rating() {
		calculating();
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