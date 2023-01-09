// 이보경(2015682)
// 2023-01-04
// lab9-1: CalcFrame.java

package lab9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcFrame extends JFrame {
	int a = 0;
	int b = 0;
	JTextField num1;
	JLabel mul;
	JTextField num2;
	JButton equal;
	JTextField result;

	public CalcFrame() {
		setTitle("계산기");
		setSize(700, 100);
		setLayout(new FlowLayout());

		num1 = new JTextField(10);
		mul = new JLabel("X");
		num2 = new JTextField(10);
		equal = new JButton("=");
		result = new JTextField(10);

		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(num1.getText());
				b = Integer.parseInt(num2.getText());
				result.setText(Integer.toString(a * b));
			}
		});

		add(num1);
		add(mul);
		add(num2);
		add(equal);
		add(result);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CalcFrame();
	}
}
