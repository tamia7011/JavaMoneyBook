package Database;

public class tempRepository {
	
	public int salary;
	private int budget;
	private String name;
	private int totalExpense;
	private int fixedExpense;
	private int flexibleExpense;
	private int discretionaryExpense;
	private int mileage;
	
	public tempRepository() {
		salary = 0;
		budget = 0;
		name = "user";
		totalExpense = 0;
		fixedExpense = 0;
		flexibleExpense = 0;
		discretionaryExpense = 0;
		mileage = 0;
	}
	
	public int getFixedExpenses() {
		return fixedExpense;
	}
	
	public void setFixedExpenses(int in_fixedExpense) {
		fixedExpense = in_fixedExpense;
	}
	
	public int getFlexibleExpenses() {
		return flexibleExpense;
	}
	
	public void setFlexibleExpenses(int in_flexibleExpense) {
		flexibleExpense = in_flexibleExpense;
	}
	
	public int getDiscretionaryExpenses() {
		return discretionaryExpense;
	}
	
	public void setDiscretionaryExpenses(int in_discretionaryExpense) {
		discretionaryExpense = in_discretionaryExpense;
	}

	public int getTotalExpenses() {
		return totalExpense;
	}

	public void setTotalExpenses(int in_totalExpense) {
		totalExpense = in_totalExpense;
	}
	
	public int getBudget() {
		System.out.println(budget);
		return budget;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setBudget(int in_budget) {
		budget = in_budget;
	}
	
	public void setSalary(int in_salary) {
		salary = in_salary;
	}
	
	public String getName() {	
		return name;
	}
	
	public void setName(String Name) {	
		name = Name;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int in_mileage) {
		mileage = in_mileage;
	}
	
}
