package com.wiprostring;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesisChecker {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a string containing only {}, [], and (): ");
	        String input = scanner.nextLine();

	        boolean isValid = isValidBracketSequence(input);
	        System.out.println("The string is " + (isValid ? "valid." : "invalid."));
	    }

	    public static boolean isValidBracketSequence(String str) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : str.toCharArray()) {
	            if (ch == '(' || ch == '{' || ch == '[') {
	                stack.push(ch);
	            } 
	            else if (ch == ')' || ch == '}' || ch == ']') {
	                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
	                    return false;
	                }
	            }
	        }

	        return stack.isEmpty();
	    }
	    public static boolean isMatchingPair(char open, char close) {
	        return (open == '(' && close == ')') ||
	               (open == '{' && close == '}') ||
	               (open == '[' && close == ']');
	    }


}
