package com.wiprobasic2;

public class DefaultValues {

    // Instance variables (non-static)
    int instanceInt;
    double instanceDouble;
    boolean instanceBoolean;
    String instanceString;

    // Static variables
    static int staticInt;
    static double staticDouble;
    static boolean staticBoolean;
    static String staticString;

    public static void main(String[] args) {
        // Create an instance of the class to display instance variable values
        DefaultValues obj = new DefaultValues();

        // Display default values of instance variables
        System.out.println("Instance Variables:");
        System.out.println("instanceInt: " + obj.instanceInt); // Default value 0
        System.out.println("instanceDouble: " + obj.instanceDouble); // Default value 0.0
        System.out.println("instanceBoolean: " + obj.instanceBoolean); // Default value false
        System.out.println("instanceString: " + obj.instanceString); // Default value null

        // Display default values of static variables
        System.out.println("\nStatic Variables:");
        System.out.println("staticInt: " + staticInt); // Default value 0
        System.out.println("staticDouble: " + staticDouble); // Default value 0.0
        System.out.println("staticBoolean: " + staticBoolean); // Default value false
        System.out.println("staticString: " + staticString); // Default value null
    }
}
