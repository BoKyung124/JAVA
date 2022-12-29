// 이보경(2015682)
// 2022-12-27
// lab4-1: BankAccount 클래스 작성 (BankAccountTest.java)

package lab4;

import java.util.Scanner;

class BankAccount {
	private int balance = 0;
	
	public BankAccount(int b) {
		balance = b;
	}
	
	public void deposit(int a) {
		if (a <= 0)
			return;
		balance += a;
	}
	
	public void withdraw(int b) {
		if (balance < b)
			return;
		balance -= b;
	}
	
	public void transfer(int amount, BankAccount otherAccount) {
		if (balance < amount)
			System.out.println("잔액이 부족합니다.");
		balance -= amount;
		otherAccount.balance += amount;
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}
	
}

public class BankAccountTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌 1 잔액 입력: ");
		int a1 = scan.nextInt();
		BankAccount myAccount1 = new BankAccount(a1);
		System.out.print("계좌 2 잔액 입력: ");
		int a2 = scan.nextInt();
		BankAccount myAccount2 = new BankAccount(a2);
		
		System.out.println("myAccount1: " + myAccount1);
		System.out.println("myAccount2: " + myAccount2 + "\n");
		System.out.print("계좌 1 --> 계좌 2 이체 금액 입력: ");
		int t = scan.nextInt();
		myAccount1.transfer(t, myAccount2);
		System.out.println("transfer 호출 후");
		System.out.println("myAccount1: " + myAccount1);
		System.out.println("myAccount2: " + myAccount2);
	}

}
