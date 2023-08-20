package org.jsp.EmployeeApp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.EmployeeApp.dao.EmployeeDao;
import org.jsp.EmployeeApp.dto.Employee;

public class EmployeeController {
	static Scanner sc = new Scanner(System.in);
	static EmployeeDao ed = new EmployeeDao();
	static Employee e = new Employee();
	static String name, des, password;
	static long phone;
	static Double salary;

	public static Employee setData() {
		System.out.print("Name: ");
		name = sc.next();
		System.out.print("Phone : ");
		phone = sc.nextLong();
		System.out.print("Designation: ");
		des = sc.next();
		System.out.print("Salary: ");
		salary = sc.nextDouble();
		System.out.print("Passwod: ");
		password = sc.next();
		e.setName(name);
		e.setPhone(phone);
		e.setDes(des);
		e.setPassword(password);
		e.setSalary(salary);
		return e;
	}

	public static void saveEmp() {
		System.out.println("Enter the employee details-");
		ed.saveEmployee(setData());
	}

	public static void edit() {
		System.out.print("Enter the id to be updated: ");
		int id = sc.nextInt();
		e.setId(id);
		System.out.println("Enter the employee details to be updated for id " + id + " -");
		if (ed.foundOrnot(id)) {
			ed.updateEmployee(setData());
			System.out.println("\nEmployee details updated succesfully!\n\n");
		} else
			System.err.println("User not found");
	}

	public static void fetch() {
		System.out.println("Enter the following details to fetch the employee-");
		System.out.print("Enter the phone number: ");
		phone = sc.nextLong();
		System.out.print("Enter the password: ");
		password = sc.next();
		Employee e1 = ed.verifyEmployee(phone, password);
		if (e1 != null) {
			System.out.println("\nEmployee details-\n");
			System.out.println("ID: " + e1.getId());
			System.out.println("Name: " + e1.getName());
			System.out.println("Phone: " + e1.getPhone());
			System.out.println("Designation: " + e1.getDes());
			System.out.println("Salary: " + e1.getSalary());
		} else
			System.err.println("User not found");
	}

	public static void del() {
		System.out.println("Enter the following details to delete an employee-");
		System.out.print("Enter the phone number: ");
		phone = sc.nextLong();
		System.out.print("Enter the password: ");
		password = sc.next();
		Employee e1 = ed.verifyEmployee(phone, password);
		if (e1 != null) {
			name = e1.getName();
			ed.deleteEmployee(phone, password);
			System.out.println("User " + name + " deleted successfully!");
		} else
			System.err.println("Invalid phone number or password");
	}

	public static void view() {
		List<Employee> li = ed.viewEmployee();
		if (li.size() != 0) {
			System.out.println("\n\n------------Employee details----------\n");
			for (int i = 0; i < li.size(); i++) {
				System.out.println("\nEmployee " + (i + 1) + " :- \n");
				System.out.println("ID: " + li.get(0).getId());
				System.out.println("Name: " + li.get(0).getName());
				System.out.println("Phone: " + li.get(0).getPhone());
				System.out.println("Designation: " + li.get(0).getDes());
				System.out.println("Salary: " + li.get(0).getSalary());
			}
		} else
			System.err.println("No user found");
	}

	public static void main(String[] args) {
		boolean flag = true;
		do {
			System.out.println("\n\n---------------Employee Data--------------");
			System.out.println("1. Register\t\t\t2. Update\n3. Fetch\t\t\t4. Delete\n5. View\t\t\t\t6. Exit");
			System.out.print("\nEnter your choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				saveEmp();
				break;
			case 2:
				edit();
				break;
			case 3:
				fetch();
				break;
			case 4:
				del();
				break;
			case 5:
				view();
				break;
			case 6:
				System.out.println("Exiting......");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice!! Please make a right one!\n");
				break;
			}
		} while (flag);
	}
}