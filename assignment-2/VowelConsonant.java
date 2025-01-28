package com.wiprostring;

import java.util.Scanner;

public class VowelConsonant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		
		System.out.println("enter a string:");
		String str=scn.next();
		String s=str.toLowerCase();
		
		
		int vowel=0;
		int consonant=0;
		for(int i=0;i<=s.length()-1;i++) {
			char a=s.charAt(i);
			
			if(a>='a' && a<='z') {
				switch(a) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vowel++;
					break;
				default:
					consonant++;
				}
			}
			
		}
		System.out.println("No.of Vowels: "+vowel);
		System.out.println("No.of consonants: "+consonant);
		
		
		

	}

}
