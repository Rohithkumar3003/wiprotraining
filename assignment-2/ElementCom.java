package com.wiprostring;

import java.util.Scanner;


public class ElementCom {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the size of the arrays: ");
	        int size = scanner.nextInt();
	        int[] array1 = new int[size];
	        int[] array2 = new int[size];
	        System.out.println("Enter elements of the first array:");
	        for (int i = 0; i < size; i++) {
	            array1[i] = scanner.nextInt();
	        }
	        System.out.println("Enter elements of the second array:");
	        for (int i = 0; i < size; i++) {
	            array2[i] = scanner.nextInt();
	        }

	        System.out.println("Comparison of elements:");
	        for (int i = 0; i < size; i++) {
	            System.out.print("Element " + (i + 1) + ": ");
	            String result = (array1[i] == array2[i]) ? "Equal" 
	                          : (array1[i] > array2[i]) ? "Greater" 
	                          : "Lesser";
	            System.out.println(result);
	        }
	    }
	
}
