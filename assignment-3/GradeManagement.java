package com.oop;

import java.util.*;

class Student {
    private int id;
    private String name;
    private Map<Course, Grade> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Course, Grade> getGrades() {
        return grades;
    }

    public void addGrade(Course course, Grade grade) {
        grades.put(course, grade);
    }

    public double calculateGPA() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Map.Entry<Course, Grade> entry : grades.entrySet()) {
            Course course = entry.getKey();
            Grade grade = entry.getValue();
            totalPoints += grade.getGradePoint() * course.getCredits();
            totalCredits += course.getCredits();
        }

        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", GPA: " + String.format("%.2f", calculateGPA());
    }
}

class Course {
    private int id;
    private String name;
    private int credits;

    public Course(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course ID: " + id + ", Name: " + name + ", Credits: " + credits;
    }
}

class Grade {
    private char letterGrade;
    private double gradePoint;

    public Grade(char letterGrade, double gradePoint) {
        this.letterGrade = letterGrade;
        this.gradePoint = gradePoint;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    @Override
    public String toString() {
        return "Grade: " + letterGrade + " (" + gradePoint + ")";
    }
}

public class GradeManagement {
    private List<Student> students;
    private List<Course> courses;

    public GradeManagement() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(int id, String name) {
        students.add(new Student(id, name));
    }

    public void addCourse(int id, String name, int credits) {
        courses.add(new Course(id, name, credits));
    }

    public void assignGrade(int studentId, int courseId, char letterGrade, double gradePoint) {
        Student student = students.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
        Course course = courses.stream().filter(c -> c.getId() == courseId).findFirst().orElse(null);

        if (student != null && course != null) {
            student.addGrade(course, new Grade(letterGrade, gradePoint));
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    public void displayStudents() {
        students.forEach(System.out::println);
    }

    public void displayCourses() {
        courses.forEach(System.out::println);
    }

    public static void main(String[] args) {
        GradeManagement system = new GradeManagement();

        system.addStudent(1, "Charan");
        system.addStudent(2, "Sai");

        system.addCourse(1, "Mathematics", 3);
        system.addCourse(2, "Physics", 4);

        system.assignGrade(1, 1, 'A', 4.0);
        system.assignGrade(1, 2, 'B', 3.0);
        system.assignGrade(2, 1, 'A', 4.0);

        System.out.println("Students:");
        system.displayStudents();

        System.out.println("Courses:");
        system.displayCourses();
    }
}

