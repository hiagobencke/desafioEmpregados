package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private int payDay;
    private Address address;
    private List<Employee> employees;

    public Department(String name, int payDay, Address address) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPayDay() {
        return payDay;
    }

    public Address getAddress() {
        return address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public double payroll() {
        double totalSalary = 0.0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }
}
