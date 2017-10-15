package Constants;

public class Constants {
	
	public static final int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	public static final int CAL_WIDTH = 7;
	public static final int CAL_HEIGHT = 6;
	// Fixed = expenses you can't control,  Flexible = necessary for day-to-living but you can control the amount, 
	// Discretionary = not essential for day-to-living and you can control the amount
	public static enum expenseType {Fixed, Flexible, Waste, Default};
	
}
