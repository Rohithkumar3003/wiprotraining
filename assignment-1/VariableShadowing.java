package com.wiprobasic2;

public class VariableShadowing {
	    int x = 10;
	    {
            int x = 30;
            System.out.println("Block-level x: " + x); // Prints 30
        }

	    public void demonstrateShadowing() {
	        int x = 20;

	        System.out.println("Method-level x: " + x); // Prints 20

	    }

	    public static void main(String[] args) {
	        VariableShadowing demo = new VariableShadowing();
	        demo.demonstrateShadowing();
	        System.out.println("class level variable x: "+demo.x);
	    }
	


}
