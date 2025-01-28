package com.collections;
class Book<T>{
	private T value;
	public Book(T value) {
		this.value=value;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
}

public class Generics {

	public static void main(String[] args) {
		printNumber(15);
		printNumber(110.74);
		
		Book<Integer> b1=new Book<>(10);
		System.out.println(b1.getValue());
		Book<String> b2=new Book<>("Rohith");
		System.out.println(b2.getValue());

	}

	private static<T extends Number> void printNumber(T Number) {
		// TODO Auto-generated method stub
		System.out.println("The number is: "+Number);
		
	}

}
