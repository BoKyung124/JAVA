// 이보경(2015682)
// 2023-01-03
// lab8-2: 회원 정보 등록 화면 (MemberTest.java)

package lab8;

import javax.swing.*;
import java.awt.*;

public class MemberTest extends JFrame {
	public MemberTest() {
		setTitle("회원 정보 등록 화면");
		setSize(500, 400);

		JLabel lblTitle = new JLabel("회원 등록");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));

		JPanel panelTitle = new JPanel();
		JPanel panelLabel = new JPanel();
		JPanel panelText = new JPanel();
		JPanel panelBtn = new JPanel();

		panelLabel.setLayout(new GridLayout(4, 1));
		panelText.setLayout(new GridLayout(4, 1));

		JLabel lblName = new JLabel("이름    ");
		JLabel lblPass = new JLabel("패스워드    ");
		JLabel lblEmail = new JLabel("이메일 주소    ");
		JLabel lblTel = new JLabel("전화번호    ");

		JTextField textName = new JTextField(10);
		JPasswordField textPass = new JPasswordField(20);
		JTextField textEmail = new JTextField(30);
		JTextField textTel = new JTextField(14);

		JButton btnResister = new JButton("등록하기");
		JButton btnCancel = new JButton("취소");

		panelTitle.add(lblTitle);

		panelLabel.add(lblName);
		panelLabel.add(lblPass);
		panelLabel.add(lblEmail);
		panelLabel.add(lblTel);

		panelText.add(textName);
		panelText.add(textPass);
		panelText.add(textEmail);
		panelText.add(textTel);

		panelBtn.add(btnResister);
		panelBtn.add(btnCancel);

		add(lblTitle, "North");
		add(panelLabel, "West");
		add(panelText, "East");
		add(panelBtn, "South");

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MemberTest();
	}

}
