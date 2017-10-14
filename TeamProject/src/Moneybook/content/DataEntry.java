package Moneybook.content;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.DataAccessObject;
import Database.MoneyData;

public class DataEntry extends JFrame{

	private static final long serialVersionUID = 1L; //i dont know what it is .....
	private static DataEntry thisFrame;
	private JTextField typeField;
	private JTextField nameField;
	private JTextField priceField; 
	JPanel contentPane;
	MoneyData moneyData = new MoneyData();
	DataAccessObject dataAccessObject;
	private String[] petStrings = { "Fixed", "Flexible", "Discretionary"};
	
	public static DataEntry getInstance() {
		if(thisFrame == null) {
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
		panel.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("insert information");
		lblNewLabel.setBounds(147, 15, 145, 21);
		panel.add(lblNewLabel);
		 
		JComboBox petList = new JComboBox(petStrings);
		petList.setBounds(182, 75, 182, 27);
		petList.setSelectedIndex(0); 
		panel.add(petList);
		
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
		
		JButton btnNewButton = new JButton("insert data");
		btnNewButton.setBounds(147, 260, 125, 29);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					dataAccessObject = Database.DataAccessObject.getInstance();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
				moneyData.name = nameField.getText();
				//System.out.println(Integer.parseInt(priceLabel.getText()));
				moneyData.price = Integer.parseInt(priceField.getText());
				moneyData.type = petList.getSelectedItem().toString();
				try {
					dataAccessObject.Insert("expenses", moneyData);
					ContentsPanel panel = ContentsPanel.getInstance();
					Object[] row = {moneyData.type, moneyData.name, moneyData.price};
				    DefaultTableModel model = (DefaultTableModel) panel.table.getModel();
				    model.addRow(row);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				thisFrame.setVisible(false);
			}
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 
		
	}
 
}
