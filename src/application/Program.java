package application;

import entities.Employee;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i);

            System.out.print("Id: ");
            Integer id = sc.nextInt();

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        Integer employeeId = sc.nextInt();


        Employee result = employees.stream().filter(id -> Objects.equals(id.getId(), employeeId)).findFirst().orElse(null);
        if (result == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double employeePercentage = sc.nextDouble();
            result.increaseSalary(employeePercentage);
        }
        System.out.println();
        System.out.println("List of employees: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        sc.close();
    }
}
