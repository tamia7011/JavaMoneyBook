package Database;

import java.sql.SQLException;

import Constants.Constants;
import Moneybook.MainFrame;
import Database.AccountDAO;

public class MonthAccount {
   private static MonthAccount instance;
   
   private static String DEFAULT_MONTH = "0000-00";
   public String month = DEFAULT_MONTH;//YYYY-MM
   private int salary;
   private String name = "jihoson94@gmail.com";
   private int totalExpense;
   private int fixedExpense;
   private int flexibleExpense;
   private int discretionaryExpense;
   private AccountDAO DAO;
   
   public static MonthAccount getInstance() {
      if(instance == null) {
         instance = new MonthAccount();
         return instance;
      }
      return instance;
   }
   

   private void init() {
      DAO = AccountDAO.getInstance();
      totalExpense = DAO.setBudget().getTotalExpenses();
      fixedExpense = DAO.setBudget().getFixedExpenses();
      flexibleExpense = DAO.setBudget().getFlexibleExpenses();
      discretionaryExpense = DAO.setBudget().getDiscretionaryExpenses();
      salary = DAO.setBudget().getSalary();
      System.out.println(DAO.setBudget().getSalary());
      name = "user";
   }
   
   private MonthAccount() {
      init();
   }
   
   public void calculateDataset(Account moneydata) {
      String type = moneydata.getType();
      int price = moneydata.getPrice();
      if (type.equals(Constants.expenseType.Fixed.toString())) {
         fixedExpense += moneydata.getPrice();
      }
      
      else if (type.equals(Constants.expenseType.Flexible.toString())) {
         flexibleExpense += moneydata.getPrice();
      }
      
      else {
         discretionaryExpense += moneydata.getPrice();
      }
      
      totalExpense += price;
      salary -= price;
   }
   
   public void calculateDeleteSet(Account moneydata) {
      String type = moneydata.getType();
      System.out.println(type);
      int price = moneydata.getPrice();
      if (type.equals(Constants.expenseType.Fixed.toString())) {
         fixedExpense -= moneydata.getPrice();
      }
      
      else if (type.equals(Constants.expenseType.Flexible.toString())) {
         flexibleExpense -= moneydata.getPrice();
      }
      
      else {
         discretionaryExpense -= moneydata.getPrice();
      }
      
      totalExpense -= price;
      salary += price;
   }
   
   public int getFixedExpenses() {
      return fixedExpense;
   }
   
   public void setFixedExpenses(int in_fixedExpense) {
      fixedExpense = in_fixedExpense;
      DAO.updateTotalBudget(this);
   }
   
   public int getFlexibleExpenses() {
      return flexibleExpense;
   }
   
   public void setFlexibleExpenses(int in_flexibleExpense) {
      flexibleExpense = in_flexibleExpense;
      DAO.updateTotalBudget(this);
   }
   
   public int getDiscretionaryExpenses() {
      return discretionaryExpense;
   }
   
   public void setDiscretionaryExpenses(int in_discretionaryExpense) {
      discretionaryExpense = in_discretionaryExpense;
      DAO.updateTotalBudget(this);
   }

   public int getTotalExpenses() {
      return totalExpense;
   }

   public void setTotalExpenses(int in_totalExpense) {
      totalExpense = in_totalExpense;
      DAO.updateTotalBudget(this);
   }
   public int getSalary() {
      return salary;
   }
   
   public void setSalary(int in_salaryExpense) {
      salary = in_salaryExpense;
      DAO.updateTotalBudget(this);
   }
   
   public String getName() {   
      return name;
   }
   
   public void setName(String Name) {   
      name = Name;
   }
   
   public void plusSalary(int budget) {
      salary += budget;
   }
   
}