package Moneybook.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Database.*;

public class DeleteData extends JFrame{
	private JTextField DeletedNameField;
	public DeleteData() {
		setBounds(100, 100, 450, 350);
		setTitle("Delete Data");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insert data name for delete");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblNewLabel.setBounds(69, 57, 291, 51);
		getContentPane().add(lblNewLabel);
		
		DeletedNameField = new JTextField();
		DeletedNameField.setBounds(58, 123, 180, 27);
		getContentPane().add(DeletedNameField);
		DeletedNameField.setColumns(10);
		
		JButton DeleteBtn = new JButton("Delete");
		DeleteBtn.setBounds(255, 123, 91, 29);
		getContentPane().add(DeleteBtn);
		DeleteBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = DeletedNameField.getText();
				AccountDAO DAO = AccountDAO.getInstance();
				DAO.Delete(name);
				setVisible(false);
				ContentsPanel.getInstance().showTable();
				JOptionPane.showMessageDialog(null, "Successfully deleted your data!!", "show information", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}

}
