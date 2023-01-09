// 이보경(2015682)
// 2023-01-05
// lab10-2: RadioButtonDemo.java

package lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {
	JRadioButton rbBird, rbCat, rbDog, rbRabbit, rbPig;
	JButton button;
	JPanel pnAni, pnImg;
	ButtonGroup bgAni;
	ImageIcon imgBird, imgCat, imgDog, imgRabbit, imgPig;

	public void actionPerformed(ActionEvent e) {
		if (rbBird.isSelected())
			button.setIcon(imgBird);
		if (rbCat.isSelected())
			button.setIcon(imgCat);
		if (rbDog.isSelected())
			button.setIcon(imgDog);
		if (rbRabbit.isSelected())
			button.setIcon(imgRabbit);
		if (rbPig.isSelected())
			button.setIcon(imgPig);
	}

	public RadioButtonDemo() {
		setTitle("RadioButtonDemo");
		setLayout(new FlowLayout());

		button = new JButton("");
		button.setPreferredSize(new Dimension(300, 200));

		rbBird = new JRadioButton("bird");
		rbCat = new JRadioButton("cat");
		rbDog = new JRadioButton("dog");
		rbRabbit = new JRadioButton("rabbit");
		rbPig = new JRadioButton("pig");

		bgAni = new ButtonGroup();
		bgAni.add(rbBird);
		bgAni.add(rbCat);
		bgAni.add(rbDog);
		bgAni.add(rbRabbit);
		bgAni.add(rbPig);

		rbBird.addActionListener(this);
		rbCat.addActionListener(this);
		rbDog.addActionListener(this);
		rbRabbit.addActionListener(this);
		rbPig.addActionListener(this);

		imgBird = new ImageIcon("bird.png");
		imgCat = new ImageIcon("cat.png");
		imgDog = new ImageIcon("dog.png");
		imgRabbit = new ImageIcon("rabbit.png");
		imgPig = new ImageIcon("pig.png");

		pnAni = new JPanel();
		pnImg = new JPanel();

		pnAni.setLayout(new GridLayout(0, 1));
		pnAni.add(rbBird);
		pnAni.add(rbCat);
		pnAni.add(rbDog);
		pnAni.add(rbRabbit);
		pnAni.add(rbPig);
		add(pnAni);
		add(button);

		setFocusable(true);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new RadioButtonDemo();
	}

}
