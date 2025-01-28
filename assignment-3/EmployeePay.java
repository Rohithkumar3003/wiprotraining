package com.oop;

import java.util.*;

abstract class Employee {
    private int id;
    private String name;
    private double baseSalary;

    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: " + String.format("%.2f", calculateSalary());
    }
}

class PermanentEmployee extends Employee {
    private double bonus;

    public PermanentEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class ContractualEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public ContractualEmployee(int id, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(id, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}

class Department {
    private int id;
    private String name;
    private List<Employee> employees;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void generateReport() {
        System.out.println("Department: " + name);
        employees.forEach(System.out::println);
    }
}

public class EmployeePay {
    private List<Department> departments;

    public EmployeePay() {
        departments = new ArrayList<>();
    }

    public void addDepartment(int id, String name) {
        departments.add(new Department(id, name));
    }

    public void addEmployeeToDepartment(int departmentId, Employee employee) {
        Department department = departments.stream().filter(d -> d.getId() == departmentId).findFirst().orElse(null);
        if (department != null) {
            department.addEmployee(employee);
        } else {
            System.out.println("Department not found.");
        }
    }

    public void generateReports() {
        departments.forEach(Department::generateReport);
    }

    public static void main(String[] args) {
        EmployeePay system = new EmployeePay();

        system.addDepartment(1, "Engineering");
        system.addDepartment(2, "HR");

        Employee emp1 = new PermanentEmployee(1, "Venky", 50000, 10000);
        Employee emp2 = new ContractualEmployee(2, "Pawan", 20000, 100, 50);
        Employee emp3 = new PermanentEmployee(3, "Guru", 60000, 15000);

        system.addEmployeeToDepartment(1, emp1);
        system.addEmployeeToDepartment(1, emp2);
        system.addEmployeeToDepartment(2, emp3);

        system.generateReports();
    }
}
