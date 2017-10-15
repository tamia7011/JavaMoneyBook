package Moneybook.content;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Constants.Constants;
import Database.AccountDAO;
import Database.Account;
import Database.MonthAccount;
import Moneybook.calendar.CalendarManager;

public class DataEntry extends JFrame {

	private static final long serialVersionUID = 1L; // i dont know what it is .....
	private static DataEntry thisFrame;
	private JTextField typeField;
	private JTextField nameField;
	private JTextField priceField; 
	JPanel contentPane;
	Account moneyData = new Account();
	AccountDAO accountDAO;

	private JComboBox comboList;

	static String[] petStrings = { Constants.expenseType.Fixed.toString(), Constants.expenseType.Flexible.toString(),
			Constants.expenseType.Waste.toString(), Constants.expenseType.Default.toString() };

	public static DataEntry getInstance() {
		if (thisFrame == null) {
			thisFrame = new DataEntry();
			return thisFrame;
		}
		return thisFrame;
	}

	private DataEntry() {
		init();
	}

	public void init() {
		setBounds(100, 100, 450, 450);
		JPanel panel = new JPanel();
		JPanel contentPane = panel;
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("insert information");
		lblNewLabel.setBounds(147, 15, 145, 21);
		panel.add(lblNewLabel);

	    comboList = new JComboBox(petStrings);
		comboList.setBounds(182, 75, 182, 27);
		comboList.setSelectedIndex(0);
		panel.add(comboList);

		nameField = new JTextField();
		nameField.setBounds(182, 134, 182, 27);
		panel.add(nameField);
		nameField.setColumns(10);

		priceField = new JTextField();
		priceField.setBounds(182, 192, 182, 27);
		panel.add(priceField);
		priceField.setColumns(10);

		JLabel nameLabel = new JLabel("type");
		nameLabel.setBounds(107, 78, 43, 21);
		panel.add(nameLabel);

		JLabel priceLabel = new JLabel("name");
		priceLabel.setBounds(100, 137, 50, 21);
		panel.add(priceLabel);

		JLabel typeLabel = new JLabel("price");
		typeLabel.setBounds(107, 195, 50, 21);
		panel.add(typeLabel);

		JButton insertBtn = new JButton("insert data");
		insertBtn.setBounds(147, 260, 125, 29);
		panel.add(insertBtn);

		insertBtn.addActionListener(new InsertListener());

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

	private class InsertListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			accountDAO = Database.AccountDAO.getInstance();

			String name = nameField.getText();
			int price = Integer.parseInt(priceField.getText());
			String type = comboList.getSelectedItem().toString();

			moneyData.setName(name);
			moneyData.setPrice(price);
			moneyData.setType(type);
			moneyData.setDate(CalendarManager.getDate());

			accountDAO.Insert(moneyData); 
			ContentsPanel.getInstance().showTable();
			thisFrame.setVisible(false);
		}
	}

}
