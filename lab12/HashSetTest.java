// 이보경(2015682)
// 2023-01-09
// lab12-2 : HashSet 활용 예제 (HashSetTest.java)

package lab12;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HashSetTest extends JFrame {
	private JButton btn;
	private JTextArea ta;
	int num;

	public HashSetTest() {
		HashSet<Integer> set = new HashSet<Integer>();
		Random rn = new Random();
		setLayout(new GridLayout(0, 1));

		btn = new JButton("로또 번호 생성");
		ta = new JTextArea("Lotto[" + set + "]");
		ta.setEditable(false);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (set.size() <= 6) {
					num = rn.nextInt(44) + 1;
					set.add(num);
				}
				ta.setText("Lotto[" + set + "]");
				set.clear();
			}
		});

		add(btn);
		add(ta);
		setSize(500, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new HashSetTest();
	}
}
