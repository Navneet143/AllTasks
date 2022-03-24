package Yaml;

import java.util.List;

public class Employee {

    public Employee(String name, int wage, String position, List<Employee> colleagues) {
        this.name = name;
        this.wage = wage;
        this.position = position;
        this.colleagues = colleagues;
    }

    // Without a default constructor, Jackson will throw an exception
    public Employee() {}

    private String name;
    private int wage;
    private String position;
    private List<Employee> colleagues;

    // Getters and setters
    
    @Override
    public String toString() {
        return "\nName: " + name + "\nWage: " + wage + "\nPosition: " + position + "\nColleagues: " + colleagues + "\n";
    }
}