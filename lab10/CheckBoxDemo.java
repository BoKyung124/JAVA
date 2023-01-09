// 이보경(2015682)
// 2023-01-05
// lab10-1: CheckBoxDemo.java

package lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo extends JFrame implements ItemListener {
	JCheckBox cbEngine, cbAuto, cbFilter, cbTire;
	JLabel lblPrice;
	JPanel panelCb;
	int result = 0;
	int[] price = { 45000, 80000, 30000, 100000 };

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getItem() == cbEngine)
				result += price[0];
			else if (e.getItem() == cbAuto)
				result += price[1];
			else if (e.getItem() == cbFilter)
				result += price[2];
			else if (e.getItem() == cbTire)
				result += price[3];
		}

		else {
			if (e.getItem() == cbEngine)
				result -= price[0];
			else if (e.getItem() == cbAuto)
				result -= price[1];
			else if (e.getItem() == cbFilter)
				result -= price[2];
			else if (e.getItem() == cbTire)
				result -= price[3];
		}

		lblPrice.setText(("현재까지의 가격은" + result + "입니다."));
	}

	public CheckBoxDemo() {
		setTitle("CheckBoxDemo");
		panelCb = new JPanel();

		cbEngine = new JCheckBox("엔진오일 교환");
		cbAuto = new JCheckBox("자동변속기오일 교환");
		cbFilter = new JCheckBox("에어콘필터 교환");
		cbTire = new JCheckBox("타이어 교환");

		cbEngine.addItemListener(this);
		cbAuto.addItemListener(this);
		cbFilter.addItemListener(this);
		cbTire.addItemListener(this);

		lblPrice = new JLabel("현재까지의 가격은" + result + "입니다.");
		lblPrice.setHorizontalAlignment(JLabel.CENTER);
		lblPrice.setFont(new Font("Arial", Font.BOLD, 40));

		panelCb.setLayout(new GridLayout(1, 0));
		panelCb.add(cbEngine);
		panelCb.add(cbAuto);
		panelCb.add(cbFilter);
		panelCb.add(cbTire);

		add(panelCb, "North");
		add(lblPrice, "Center");

		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CheckBoxDemo();
	}

}
