package Moneybook.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import Database.MonthAccount;
import Moneybook.calculator.Calculator;

public class MenuBar extends JMenuBar {
	
	public MenuBar() {
		JButton SetIDBtn = new JButton("Set E-mail");
		add(SetIDBtn);
		
		JButton SetBudgetBtn = new JButton("Set budget");
		add(SetBudgetBtn);
		
		SetBudgetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame budgetPopup = new JFrame();
				try {
					int salary = Integer.parseInt(JOptionPane.showInputDialog(budgetPopup, "How much is your Budget?", null));
					MonthAccount budget = MonthAccount.getInstance();
					budget.setBudget(salary);
					budget.setSalary(salary);
					budgetPopup.dispose();
					JOptionPane.showMessageDialog(null, "Successfully entered your budget!!", "show information", JOptionPane.INFORMATION_MESSAGE);
				
				} catch(Exception e1) {
					
				}
			}
			
		});
		
		JButton AddBudgetBtn = new JButton("Add budget");
		add(AddBudgetBtn);
		AddBudgetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame DepositPopup = new JFrame();
				int deposit = Integer.parseInt(JOptionPane.showInputDialog(DepositPopup, "How much do you want to add?", null));
				MonthAccount budget = MonthAccount.getInstance();
				budget.plusSalary(deposit);
				budget.plusBudget(deposit);
				budget.setSalary(budget.getSalary());
				DepositPopup.dispose();
				JOptionPane.showMessageDialog(null, "Successfully added your budget!!", "show information", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}

	
}
