package com.wiprostring;

import java.util.Scanner;

public class AnagramCheck {

	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the first string: ");
	        String str1 = scanner.nextLine();

	        System.out.print("Enter the second string: ");
	        String str2 = scanner.nextLine();

	        boolean isAnagram = areAnagrams(str1, str2);

	        System.out.println("The strings are " + (isAnagram ? "anagrams." : "not anagrams."));
	    }

	    public static boolean areAnagrams(String str1, String str2) {
	        str1 = str1.replaceAll("\\s+", "").toLowerCase();
	        str2 = str2.replaceAll("\\s+", "").toLowerCase();

	        if (str1.length() != str2.length()) {
	            return false;
	        }

	        int[] charCount = new int[26];
	        for (char ch : str1.toCharArray()) {
	            charCount[ch - 'a']++;
	        }
	        for (char ch : str2.toCharArray()) {
	            charCount[ch - 'a']--;
	        }

	        for (int count : charCount) {
	            if (count != 0) {
	                return false; 
	            }
	        }

	        return true;
	    }
	


}
