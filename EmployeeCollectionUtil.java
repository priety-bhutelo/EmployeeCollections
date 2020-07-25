package com.montran.util;

import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Book;
import com.montran.pojo.Employee;

public class EmployeeCollectionUtil {
	private List<Employee> employeeList = new ArrayList<Employee>();
	private Employee employees[];
	private int nextIndex = 0;
	private int maxIndex;

	public EmployeeCollectionUtil(int maxlength) {
		// TODO Auto-generated constructor stub
		employees = new Employee[maxlength];
		maxIndex = maxlength;
	}
	public int getNextIndex() {
		return nextIndex;
	}
	public int getMaxIndex() {
		return maxIndex;
	}


	public boolean addNewEmployee(Employee employee) {
		if (nextIndex >= 0 && nextIndex < maxIndex) {
			employeeList.add(employee);
			nextIndex++;
			return true;
		}
		return false;
	}

	public boolean addAllEmployees(Employee[] employees) {
		for (Employee employee : employees) {
			addNewEmployee(employee);
              
		}
		return true;
	}

	public boolean updateEmployeeSalary(int employeeId, double newSalary) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				employee.setEmployeeId(employeeId);
				employee.setSalary(newSalary);
				return true;

			}

		}
		return false;
	}

	public boolean deleteEmployee(int employeeId) {

		for (Employee employee : employeeList) {
			System.out.println(employee.getEmployeeId());
			if (employee.getEmployeeId() == employeeId) {
				//System.out.println(employee.getEmployeeId());
				employeeList.remove(employee);
				return true;

			}

		}
		return false;

	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee != null) {
				if (employee.getEmployeeId() == employeeId)
					return employee;
			}

		}
		return null;
	}

	public List<Employee> getAllEmployees() {
		return employeeList;
	}

}
