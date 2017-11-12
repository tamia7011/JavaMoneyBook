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
		JButton SetBudgetBtn = new JButton("set budget");
		add(SetBudgetBtn);
		
		SetBudgetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame budgetPopup = new JFrame();
				int salary = Integer.parseInt(JOptionPane.showInputDialog(budgetPopup, "How much is your income?", null));
				MonthAccount budget = MonthAccount.getInstance();
				budget.salary = salary;
				budgetPopup.dispose();
				JOptionPane.showMessageDialog(null, "Successfully entered your budget!!", "show information", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}

	
}
