package com.streamapi;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class StreamAPI {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "HR", 6000),
            new Employee(2, "Bob", "IT", 8000),
            new Employee(3, "Charlie", "Finance", 7000),
            new Employee(4, "David", "IT", 5500),
            new Employee(5, "Eve", "HR", 4000),
            new Employee(6, "Frank", "Finance", 3000),
            new Employee(7, "Grace", "IT", 9000)
        );

        // Find Employee with Highest Salary
        employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary))
            .ifPresent(emp -> System.out.println("Highest Salary: " + emp));

        // Filter Employees with Salary Greater Than 5000
        List<Employee> highEarners = employees.stream()
            .filter(emp -> emp.getSalary() > 5000)
            .collect(Collectors.toList());
        System.out.println("Employees with Salary > 5000: " + highEarners);

        // Get Employee Names and Salaries
        Map<String, Double> nameAndSalary = employees.stream()
            .collect(toMap(Employee::getName, Employee::getSalary));
        System.out.println("Employee Names and Salaries: " + nameAndSalary);

        // Count Employees
        long count = employees.stream().count();
        System.out.println("Total Employees: " + count);

        // Group Employees by Department
        Map<String, List<Employee>> employeesByDept = employees.stream()
            .collect(groupingBy(Employee::getDepartment));
        System.out.println("Employees by Department: " + employeesByDept);

        // Calculate Average Salary
        double averageSalary = employees.stream()
            .collect(averagingDouble(Employee::getSalary));
        System.out.println("Average Salary: " + averageSalary);

        // Sort Employees by Salary
        List<Employee> sortedBySalary = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary))
            .collect(Collectors.toList());
        System.out.println("Employees Sorted by Salary: " + sortedBySalary);

        // Find Employee with Second Highest Salary
        employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .skip(1)
            .findFirst()
            .ifPresent(emp -> System.out.println("Second Highest Salary: " + emp));

        // Partition Employees by Salary Threshold
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
            .collect(partitioningBy(emp -> emp.getSalary() > 5000));
        System.out.println("Partitioned by Salary > 5000: " + partitionedBySalary);

        // Find Employee with Longest Name
        employees.stream()
            .max(Comparator.comparingInt(emp -> emp.getName().length()))
            .ifPresent(emp -> System.out.println("Longest Name: " + emp));

        // Group Employees by Department and Calculate Average Salary
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));
        System.out.println("Average Salary by Department: " + avgSalaryByDept);

        // Find Top 3 Highest Paid Employees
        List<Employee> top3Earners = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Top 3 Highest Paid Employees: " + top3Earners);

        // Calculate Total Salary of All Employees Using Reduce
        double totalSalary = employees.stream()
            .map(Employee::getSalary)
            .reduce(0.0, Double::sum);
        System.out.println("Total Salary of All Employees: " + totalSalary);
    }
}