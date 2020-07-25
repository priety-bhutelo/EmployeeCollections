package com.montran.main;

import java.util.List;
import java.util.Scanner;
import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeCollectionMain {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		EmployeeCollectionUtil employeeCollectionUtil=new EmployeeCollectionUtil(100);
	  
		List<Employee> employeeList;
		Employee employee;
		Employee employees[];
		
		int employeeId;
		String name;
		double salary;
		int employeeChoice;
		boolean result;
		int numberOfEmployees;
		String continueChoice;
		
		

		do {
			employeeList = employeeCollectionUtil.getAllEmployees();
			for (Employee employeeTemp : employeeList) {
				if (employeeTemp != null) {
					System.out.println(employeeTemp.getEmployeeId() + "\t" + employeeTemp.getName() + "\t" + employeeTemp.getSalary());
				}
			}
			System.out.println("Menu");
			System.out.println("1. Add Single Employee	");
			System.out.println("2. Add Multiple Employees");
			System.out.println("3. Update Existing Employee Salary");
			System.out.println("4. Delete Existing Employee");
			System.out.println("5. Print Single Employee Details");
			System.out.println("6. Exit");

			System.out.println("Enter your choice");
			employeeChoice = scanner.nextInt();
			switch (employeeChoice) {
			case 1:
				System.out.println("Enter EmployeeId");
				employeeId=scanner.nextInt();
				
				scanner.nextLine();
				System.out.println("Enter Name");
				name=scanner.nextLine();
				
				System.out.println("Enter Salary");
				salary=scanner.nextDouble();
				
				employee = new Employee(employeeId, name, salary);
				result = employeeCollectionUtil.addNewEmployee(employee);
				if (result)
					System.out.println("Employee is added successfully !!");
				else
					System.out.println("Failed to add Employee");
				break;
			case 2:
				System.out.println("How many Employees do you want to add ?");
				numberOfEmployees = scanner.nextInt();
				if (numberOfEmployees < (employeeCollectionUtil.getMaxIndex() - employeeCollectionUtil.getNextIndex())) {
					employees = new Employee[numberOfEmployees];
					for (int i = 0; i < numberOfEmployees; i++) {
						System.out.println("Enter EmployeeId");
						employeeId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Employee Name");
						name = scanner.nextLine();
						System.out.println("Enter salary");
						salary = scanner.nextDouble();

						employee= new Employee(employeeId, name, salary);
						employees[i]=employee;
					}
					employeeCollectionUtil.addAllEmployees(employees);
					System.out.println("Employees are added !!");
				} 
				break;
			case 3:
				System.out.println("Enter EmployeeId");
				employeeId = scanner.nextInt();
				employee = employeeCollectionUtil.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
					
					System.out.println("Employee New salary");
					salary = scanner.nextDouble();

					result = employeeCollectionUtil.updateEmployeeSalary(employeeId, salary);
					if (result)
						System.out.println("Employee details are updated successfully !!");
					else
						System.out.println("Failed to update Employee details");
				} else
					System.out.println("No Employee Found !!");
				break;

			case 4:
				System.out.println("Enter EmployeeId");
				employeeId = scanner.nextInt();
				employee = employeeCollectionUtil.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					result = employeeCollectionUtil.deleteEmployee(employeeId);
					if (result)
						System.out.println("Employee deleted successfully ");
					else
						System.out.println("Failed to delete Employee");
				} else
					System.out.println("No Employee Found !!");
				break;
			case 5:
				System.out.println("Enter EmployeeId");
				employeeId = scanner.nextInt();
				employee = employeeCollectionUtil.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
				} else
					System.out.println("No Employee Found !!");
				break;
			case 6:
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue yes- no ??");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));
		System.out.println("Thank you");
	}


	}


