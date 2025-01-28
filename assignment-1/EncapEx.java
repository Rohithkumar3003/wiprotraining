package com.wiprobasic2;

public class EncapEx {
	private int age;
	public void setAge(int age) {
		this.age=age;
		if (age>=18) {
		
			System.out.println("Eligible to Vote");
		}
		else {
			System.out.println("Not Eligible to Vote");
		}
		
		
	}
	public int getAge() {
		return age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncapEx e1=new EncapEx();
		e1.setAge(17);
		

	}

}
