package academy.javapro;

import java.util.*;
import java.util.stream.*;

class Student{
    private String name;
    private double gpa;
    private String year;

    public Student(String name, double gpa, String year) {
        this.name = name;
        this.gpa = gpa;
        this.year = year;
    }
    public String getName() {return name; }
    public double getGpa() {return gpa; }
    public String getYear(){return year; }

    public String toString() {
        return name + "("+year+") -gpa: "+gpa;
    }
}
public class StudentStreamLab {
     public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // TODO - Filtering: Students with GPA > 3.0
        List<Student> highGpaStudents = students.stream()
            .filter(s -> s.getGpa() > 3.0)
            .collect(Collectors.toList());

        System.out.println("Students with GPA> 3.0: ");
        highGpaStudents.forEach(System.out::println);
        
        // TODO - Mapping: Extract names of students with GPA > 3.0
        List<String>highGpaNames = highGpaStudents.stream()
            .map(Student::getName)
            .collect(Collectors.toList());

        System.out.println("\nHigh GPA student names: ");
        highGpaNames.forEach(System.out::println);

        // TODO - Reducing: Calculate the average GPA of all students
        double averageGpa = students.stream()
            .mapToDouble(Student::getGpa)
            .average()
            .orElse(0.0);

        System.out.printf("\nAverage gpa: %.2f\n", averageGpa);

        // TODO - Collecting: Collect all "Junior" students into a list
        List<Student> juniorStudents = students.stream()
            .filter(s -> s.getYear().equals("Junior"))
            .collect(Collectors.toList());
        System.out.println("\nJuniors: ");
        juniorStudents.forEach(System.out::println);

    }
}