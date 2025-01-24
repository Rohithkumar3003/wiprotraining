package com.wiprostring;

import java.util.Scanner;

public class ArrayRotate {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the size of the array: ");
	        int size = scanner.nextInt();

	        int[] array = new int[size];

	        System.out.println("Enter elements of the array:");
	        for (int i = 0; i < size; i++) {
	            array[i] = scanner.nextInt();
	        }
	        System.out.print("Enter the number of rotations: ");
	        int rotations = scanner.nextInt();
	        System.out.print("Enter the direction of rotation (left or right): ");
	        String direction = scanner.next().toLowerCase();

	        int[] rotatedArray = rotateArray(array, rotations, direction);
	        System.out.println("Rotated array:");
	        for (int num : rotatedArray) {
	            System.out.print(num + " ");
	        }

	    }

	    public static int[] rotateArray(int[] array, int rotations, String direction) {
	        int size = array.length;
	        rotations = rotations % size;
	        if (rotations == 0) {
	            return array;
	        }
	        if (direction.equals("right")) {
	            rotations = size - rotations;
	        } else if (!direction.equals("left")) {
	            System.out.println("Invalid direction! Defaulting to left rotation.");
	        }
	        int[] rotatedArray = new int[size];
	        System.arraycopy(array, rotations, rotatedArray, 0, size - rotations);
	        System.arraycopy(array, 0, rotatedArray, size - rotations, rotations);

	        return rotatedArray;
	    }
	

}
