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
	Data data;
	sql sql;
	
	public DataEntry() {
		setBounds(100, 100, 450, 450);
		JPanel panel = new JPanel();
		JPanel contentPane = panel;
		panel.setLayout(null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("insert information");
		lblNewLabel.setBounds(147, 15, 145, 21);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(182, 75, 182, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 134, 182, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(182, 192, 182, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel nameLabel = new JLabel("type");
		nameLabel.setBounds(107, 78, 43, 21);
		panel.add(nameLabel);
		
		JLabel priceLabel = new JLabel("name");
		priceLabel.setBounds(100, 137, 50, 21);
		panel.add(priceLabel);
		
		JLabel typeLabel = new JLabel("price");
		typeLabel.setBounds(107, 195, 50, 21);
		panel.add(typeLabel);
		
		JButton btnNewButton = new JButton("insert data");
		btnNewButton.setBounds(147, 260, 125, 29);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				data = new Data();
				try {
					sql.Init();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
				data.name = nameLabel.getText();
				data.price = Integer.parseInt(priceLabel.getText());
				data.type = typeLabel.getText();
				try {
					sql.Insert("expenses", data);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	}


}
