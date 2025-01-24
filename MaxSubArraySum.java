package com.wiprostring;
import java.util.Scanner;


public class MaxSubArraySum {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the number of elements in the array: ");
	        int n = sc.nextInt();

	        int[] array = new int[n];
	        System.out.println("Enter the elements of the array:");
	        for (int i = 0; i < n; i++) {
	            array[i] = sc.nextInt();
	        }

	        int maxSum = array[0];
	        int currentSum = array[0];

	        for (int i = 1; i < n; i++) {
	            currentSum = (currentSum + array[i] > array[i]) ? (currentSum + array[i]) : array[i];
	            maxSum = (currentSum > maxSum) ? currentSum : maxSum;
	        }
	        System.out.println("Maximum sum of a contiguous subarray: " + maxSum);

	    }
	

}
