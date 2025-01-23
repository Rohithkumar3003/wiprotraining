package com.wiprobasic2;
class Vehicle{
	void breaks() {
		System.out.println("Breaks applied");
	}
}
class Car extends Vehicle{
	void start(){
		System.out.println("car is moving");
	}
}
public class InheritanceEx extends Car{
	
	void stop() {
		System.out.println("car stopped");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InheritanceEx e1 =new InheritanceEx();
		e1.stop();
		e1.start();
		e1.breaks();

	}

}
