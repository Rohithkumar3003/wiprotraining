package com.wiprostring;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String:");
		String s=sc.next();
		String rev="";
		for (int i=s.length()-1;i>=0;i--) {
			rev=rev+s.charAt(i);
		}
		if (s.equals(rev)) {
			System.out.println(s+" is a palindrome");
		}
		else {
			System.out.println(s+" is not a palindrome");
		}
		

	}

}
