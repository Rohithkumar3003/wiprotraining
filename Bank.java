package com.wiprobasic2;

public class Bank {
	String accHName;
	double accNum;
	double bal;
	public Bank(String accHName,double accNumber,double bal) {
		this.accHName=accHName;
		this.accNum=accNumber;
		this.bal=bal;
		System.out.println("accHName is:"+accHName);
		System.out.println("accNumber is:"+accNumber);
		System.out.println("balance is:"+bal);
	}
	public void deposit(double amt) {
		bal=bal+amt;
		System.out.println(bal);
	}
	public void withdraw(double amt) {
		bal=bal-amt;
		System.out.println(bal);
	}
	public void balance() {
		System.out.println(bal);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Bank b1=new Bank("Rohith",234248264,10000);
b1.deposit(5000);
b1.withdraw(5000);
b1.balance();

	}

}
