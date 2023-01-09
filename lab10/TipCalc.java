// 이보경(2015682)
// 2023-01-05
// lab10-3: Tip 계산기 (TipCalc.java)

package lab10;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class TipCalc extends JFrame implements ChangeListener {
	JLabel lblTitle, lblPrice, lblTip, lblTotal;
	JPanel pnLeft, pnRight;
	JTextField tfPrice;
	JTextArea taTotal;
	JSlider slider;
	int price, total;
	double tip;

	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		price = Integer.parseInt(tfPrice.getText());
		total = price;
		if (!source.getValueIsAdjusting()) {
			int value = (int) source.getValue();
			tip = price * value * 0.01;
			taTotal.setText(Integer.toString(price + (int) tip));
		}
	}

	public TipCalc() {
		lblTitle = new JLabel("TIP 계산기");
		lblTitle.setFont(new Font("Alias", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);

		pnLeft = new JPanel();
		pnLeft.setLayout(new GridLayout(0, 1));
		pnRight = new JPanel();
		pnRight.setLayout(new GridLayout(0, 1));

		lblPrice = new JLabel("금액");
		lblTip = new JLabel("팁");
		lblTotal = new JLabel("총액");
		pnLeft.add(lblPrice);
		pnLeft.add(lblTip);
		pnLeft.add(lblTotal);

		tfPrice = new JTextField(20);
		pnRight.add(tfPrice);

		slider = new JSlider(0, 30, 10);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(this);
		pnRight.add(slider);

		taTotal = new JTextArea(5, 15);
		taTotal.setLineWrap(true);
		pnRight.add(taTotal);

		add(lblTitle, "North");
		add(pnLeft, "West");
		add(pnRight, "Center");

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TipCalc();
	}

}
