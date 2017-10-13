package Moneybook.content;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Database.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DataEntry extends JFrame{

	private static final long serialVersionUID = 1L; //i dont know what it is .....
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JPanel contentPane;
	MoneyData moneyData;
	DataAccessObject dataAccessObject;
	
	public DataEntry() {
		setBounds(100, 100, 450, 450);
		JPanel panel = new JPanel();
		JPanel contentPane = panel;
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC815\uBCF4\uC785\uB825");
		lblNewLabel.setBounds(185, 15, 78, 21);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(212, 72, 156, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 134, 156, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(212, 192, 156, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(102, 75, 78, 21);
		panel.add(nameLabel);
		
		JLabel priceLabel = new JLabel("\uAC00\uACA9");
		priceLabel.setBounds(102, 137, 78, 21);
		panel.add(priceLabel);
		
		JLabel typeLabel = new JLabel("\uC18C\uBE44\uC720\uD615");
		typeLabel.setBounds(88, 195, 78, 21);
		panel.add(typeLabel);
		
		JButton btnNewButton = new JButton("\uC785\uB825");
		btnNewButton.setBounds(158, 256, 125, 29);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				moneyData = new MoneyData();
				try {
					dataAccessObject.Init();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
				moneyData.name = nameLabel.getText();
				moneyData.price = Integer.parseInt(priceLabel.getText());
				moneyData.type = typeLabel.getText();
				try {
					dataAccessObject.Insert("expenses", moneyData);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}


}
