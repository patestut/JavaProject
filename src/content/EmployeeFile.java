/**
 * Stuti Patel
 * 991663001
 * Treesa Saju
 * 991670853
 * Final Project
 * 11th April 2023
 */
package content;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFile {

    private static final String FILENAME = "Employee.dat";

    public static LinkedList<Employee> readEmployees() {
        LinkedList<Employee> employees = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                int id = Integer.parseInt(employeeData[0]);
                String name = employeeData[1];
                String city = employeeData[2];
                String position = employeeData[3];
                Employee employee = new Employee(id, name, city, position);
                employees.add(employee);
            }
            System.out.println("Employees data has been read from " + FILENAME);
        } catch (IOException e) {
            System.err.println("Error reading employees data from file: " + e.getMessage());
        }
        return employees;
    }

    public static void writeEmployees(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Employee employee : employees) {
                writer.write(employee.getID() + "," + employee.getName() + "," + employee.getCity() + "," + employee.getPosition());
                writer.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
}
