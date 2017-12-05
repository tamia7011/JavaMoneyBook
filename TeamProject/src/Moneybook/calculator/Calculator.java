package Moneybook.calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Moneybook.content.DataEntry;

public class Calculator {
	private JFrame frame;
	private ActionListener btnClickListener;

	private BigDecimal resultValue;

	private BigDecimal memoryValue;

	private Boolean isNewValue;

	private JButton selectedOperBtn;

	private static final String divideErrorText = "0으로 나눌 수 없습니다.";

	private Font buttonFont;
	private Container container;
	public static JTextField txt;
	private JLabel mLabel;
	private JButton plusBtn;
	private JButton minusBtn;
	private JButton multBtn;
	private JButton divBtn;
	private JButton enterBtn;
	DataEntry dataEntry;

	public void create() {
		this.init();
		this.createUI();
		this.setEventListener();
	}

	private void init() {
		this.buttonFont = new Font("Arial", 0, 16);

		this.resultValue = new BigDecimal(0);
		this.memoryValue = new BigDecimal(0);
		this.selectedOperBtn = null;
		this.isNewValue = true;

		this.btnClickListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtValue = txt.getText();

				JButton b = (JButton) e.getSource();
				String _name = b.getText();
				switch (_name) {
				case "M+":
					if (txtValue.equals(divideErrorText))
						return;

					mLabel.setVisible(true);
					memoryValue = memoryValue.add(new BigDecimal(Float.valueOf(txtValue)));
					isNewValue = true;
					break;

				case "M-":
					if (txtValue.equals(divideErrorText))
						return;

					mLabel.setVisible(true);
					memoryValue = memoryValue.subtract(new BigDecimal(Float.valueOf(txtValue)));
					isNewValue = true;
					break;

				case "MR":
					Float f = memoryValue.floatValue();
					Integer i = memoryValue.intValue();
					if (f.equals(Float.valueOf(i)))
						txt.setText(String.valueOf(i));
					else
						txt.setText(String.valueOf(f));
					isNewValue = true;
					break;

				case "MC":
					mLabel.setVisible(false);
					memoryValue = new BigDecimal(0);
					isNewValue = true;
					break;

				case "/":
				case "*":
				case "+":
				case "-":
					inputOperate(b);
					break;

				case "←":
					inputBackspace();
					break;

				case "√":
					calculateSquareRoot();
					break;

				case "=":
					inputEnter();
					break;

				case "C":
					inputEscape();
					break;

				case "input":
					inputValue();
					break;

				default:
					pressNumberPad(_name);
					break;
				}
			}
		};
	}

	private void createUI() {
		frame = new JFrame("Calculator");

		container = new Container();
		frame.getContentPane().add(container);

		this.mLabel = new JLabel();
		this.mLabel.setText("M");
		this.mLabel.setBounds(5, 12, 20, 20);
		this.mLabel.setVisible(false);
		container.add(this.mLabel);

		// result text field
		txt = new JTextField();
		txt.setBorder(null);
		txt.setText("0");
		txt.setHorizontalAlignment(JTextField.RIGHT);
		txt.setBounds(25, 0, 215, 40);
		txt.setFocusable(false);
		txt.setEditable(false);
		container.add(txt);

		// functions for memory
		int _scaleNum = 60;

		createButton("MC", 0, 40, _scaleNum, 40);
		createButton("MR", _scaleNum + 6, 40, _scaleNum, 40);
		createButton("M+", _scaleNum * 2 + 12, 40, _scaleNum, 40);
		createButton("M-", _scaleNum * 3 + 18, 40, _scaleNum, 40);

		// number
		ArrayList<Character> types = new ArrayList<Character>();
		types.add('7');
		types.add('8');
		types.add('9');
		types.add('4');
		types.add('5');
		types.add('6');
		types.add('1');
		types.add('2');
		types.add('3');
		types.add('0');
		types.add('.');
		types.add('C');

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				String _name = String.valueOf(types.remove(0));

				createButton(_name, 9 + j * _scaleNum, 130 + (i * _scaleNum), _scaleNum, _scaleNum);
			}
		}

		// operator
		divBtn = createButton("/", 0, 80, _scaleNum, 43);
		multBtn = createButton("*", _scaleNum + 6, 80, _scaleNum, 43);
		minusBtn = createButton("-", _scaleNum * 2 + 12, 80, _scaleNum, 43);
		plusBtn = createButton("+", _scaleNum * 3 + 18, 80, _scaleNum, 43);
		enterBtn = createButton("=", _scaleNum * 3 + 18, 246, _scaleNum, 124);
		createButton("←", _scaleNum * 3 + 18, 123 + 6, _scaleNum, 55);
		createButton("√", _scaleNum * 3 + 18, 178 + 10, _scaleNum, 55);
		createButton("input", 0, 380, _scaleNum * 3, 55);
		frame.pack();
		frame.setSize(280, 480);
		frame.setVisible(true);
	}

	private JButton createButton(String name, int x, int y, int width, int height) {
		JButton btn = new JButton(name);
		btn.setName(name);
		btn.setBounds(x, y, width, height);
		btn.setFocusable(false);
		btn.setFont(this.buttonFont);
		btn.addActionListener(this.btnClickListener);
		this.container.add(btn);

		return btn;
	}

	private void setEventListener() {
		this.frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				Integer code = Integer.valueOf(e.getKeyChar());

				if (code >= 48 && code <= 57)
					pressNumberPad(String.valueOf(e.getKeyChar()));
				else if (code == 43)
					inputOperate(plusBtn);
				else if (code == 45)
					inputOperate(minusBtn);
				else if (code == 42)
					inputOperate(multBtn);
				else if (code == 47)
					inputOperate(divBtn);
				else if (code == 10)
					inputEnter();// Enter(=Return)
				else if (code == 27)
					inputEscape();// Esc
				else if (code == 8)
					inputBackspace();// Backspace
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}

	private void pressNumberPad(String numStr) {
		String txtValue = txt.getText();

		if (isNewValue == true) {
			if (selectedOperBtn != null)
				selectedOperBtn.setForeground(Color.red);
			txt.setText("");
			isNewValue = false;
		}

		txtValue = txt.getText();
		if (txtValue.equals("0")) {
			txt.setText("");
			txtValue = "";
		}
		txt.setText(txtValue + numStr);

		// 적용 후 새로운 value
		if (txt.getText().equals("."))
			txt.setText("0.");
	}

	private void inputOperate(JButton b) {
		String txtValue = txt.getText();

		if (txtValue.equals(divideErrorText))
			return;

		if (isNewValue == false)
			calculate();

		if (selectedOperBtn != null)
			selectedOperBtn.setForeground(Color.black);
		b.setForeground(Color.red);
		selectedOperBtn = b;
	}

	private void calculateSquareRoot() {
		Float fValue = Float.valueOf(txt.getText());

		BigDecimal tmp = new BigDecimal(Math.sqrt(fValue));

		Float f = tmp.floatValue();
		Integer i = tmp.intValue();
		if (f.equals(Float.valueOf(i)))
			txt.setText(String.valueOf(i));
		else
			txt.setText(String.valueOf(f));

		this.isNewValue = true;
	}

	private void inputEnter() {
		String txtValue = txt.getText();

		if (txtValue.equals(divideErrorText))
			return;

		calculate();
		if (selectedOperBtn != null)
			selectedOperBtn.setForeground(Color.black);
	}

	private void inputEscape() {
		txt.setText("0");
		resultValue = new BigDecimal(0);

		if (selectedOperBtn != null)
			selectedOperBtn.setForeground(Color.black);
		selectedOperBtn = null;
	}

	private void inputBackspace() {
		String txtValue = txt.getText();
		txt.setText(txtValue.substring(0, txtValue.length() - 1));
		if (txt.getText().equals(""))
			txt.setText("0");
	}

	public void inputValue() {
		dataEntry = DataEntry.thisFrame;
		String txtValue = txt.getText();
		dataEntry.priceField.setText(txtValue);
		frame.setVisible(false);
	}

	private void calculate() {
		Float fValue = Float.valueOf(txt.getText());

		if (selectedOperBtn == null) {
			resultValue = new BigDecimal(fValue);
			isNewValue = true;
			return;
		}

		switch (selectedOperBtn.getName()) {
		case "/":
			if (txt.getText().equals("0") || txt.getText().equals("0.")) {
				this.txt.setText(this.divideErrorText);
				if (this.selectedOperBtn != null)
					this.selectedOperBtn.setForeground(Color.black);
				this.selectedOperBtn = null;
				this.isNewValue = true;
				this.resultValue = new BigDecimal(0);
				return;
			}
			resultValue = resultValue.divide(new BigDecimal(fValue));
			break;

		case "*":
			resultValue = resultValue.multiply(new BigDecimal(fValue));
			break;

		case "+":
			resultValue = resultValue.add(new BigDecimal(fValue));
			break;

		case "-":
			resultValue = resultValue.subtract(new BigDecimal(fValue));
			break;
		}

		Float f = resultValue.floatValue();
		Integer i = resultValue.intValue();
		if (f.equals(Float.valueOf(i)))
			txt.setText(String.valueOf(i));
		else
			txt.setText(String.valueOf(f));

		isNewValue = true;
	}
}