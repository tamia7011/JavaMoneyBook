package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalenderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CalenderPanel() {
		JPanel calendar = new JPanel(new BorderLayout());
        calendar.setLayout(new GridLayout(5,7));
        //Add headers
        String[] headers = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        for(int i = 0; i <7; i++){
            calendar.add(new JLabel("" + headers[i]));
        }
        //Add days to calendar
        for(int i = 1; i <31; i++){
            calendar.add(new JLabel("" + i));
        }

        JPanel monthHeader = new JPanel(new BorderLayout());
        monthHeader.add(new JTextField("\t\t\t04/2014"), BorderLayout.NORTH);

        monthHeader.add(calendar, BorderLayout.CENTER);

        add(monthHeader);
	}

}
