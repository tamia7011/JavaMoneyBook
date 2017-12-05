package Moneybook.content;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Database.MonthAccount;
import Database.tempRepository;

public class State extends JFrame {
	MonthAccount monthAccount = MonthAccount.getInstance();

	public State() {
		setBounds(100, 100, 900, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("±¼¸²", Font.PLAIN, 26));
		lblState.setBounds(389, 31, 76, 80);
		contentPane.add(lblState);

		JLabel lblMyBudget = new JLabel("My budget");
		lblMyBudget.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblMyBudget.setBounds(293, 137, 115, 21);
		contentPane.add(lblMyBudget);

		JLabel lblTotexp = new JLabel("Total expenses");
		lblTotexp.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblTotexp.setBounds(253, 186, 145, 21);
		contentPane.add(lblTotexp);

		JLabel lblFixedexp = new JLabel("Fixed expenses");
		lblFixedexp.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblFixedexp.setBounds(253, 237, 155, 21);
		contentPane.add(lblFixedexp);

		JLabel lblFlexexp = new JLabel("Flexible expenses");
		lblFlexexp.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblFlexexp.setBounds(243, 289, 155, 21);
		contentPane.add(lblFlexexp);

		JLabel lblWasexp = new JLabel("Waste expenses");
		lblWasexp.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblWasexp.setBounds(249, 336, 159, 21);
		contentPane.add(lblWasexp);

		JLabel lblBudget = new JLabel(String.valueOf(monthAccount.getBudget()));
		lblBudget.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblBudget.setBounds(460, 137, 223, 21);
		contentPane.add(lblBudget);

		JLabel lblTotal = new JLabel(String.valueOf(monthAccount.getTotalExpenses()));
		lblTotal.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblTotal.setBounds(458, 186, 225, 21);
		contentPane.add(lblTotal);

		JLabel lblFixed = new JLabel(String.valueOf(monthAccount.getFixedExpenses()));
		lblFixed.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblFixed.setBounds(458, 237, 225, 21);
		contentPane.add(lblFixed);

		JLabel lblFlexible = new JLabel(String.valueOf(monthAccount.getFlexibleExpenses()));
		lblFlexible.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblFlexible.setBounds(458, 289, 225, 21);
		contentPane.add(lblFlexible);

		JLabel lblWaste = new JLabel(String.valueOf(monthAccount.getDiscretionaryExpenses()));
		lblWaste.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblWaste.setBounds(458, 336, 225, 21);
		contentPane.add(lblWaste);
	}
}
