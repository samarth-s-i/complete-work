package org.jsp.user_product_app.controller;

import java.util.Scanner;

import org.jsp.user_product_app.dao.ProductDao;
import org.jsp.user_product_app.dao.UserDao;
import org.jsp.user_product_app.dto.User;

public class UserProductController {
	static Scanner s = new Scanner(System.in);
	static UserDao uDao = new UserDao();
	static ProductDao pDao = new ProductDao();

	public static void main(String[] args) {
		System.out.println("1. Register");
		System.out.println("2. Update");
		System.out.println("3. Verify by Phone");
		System.out.println("4. Verify by Email");
		System.out.println("5. Add Product");
		System.out.println("6. View Product by User id");
		System.out.println("7. View Product by Category");
		System.out.println("8. View Product by Brand");
		System.out.println("Enter the choice: ");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			reg();
			break;
		case 2:
			update();
			break;
		case 3:
			loginByPhone();
			break;
		}
	}

	private static void loginByPhone() {
		System.out.println("Enter the phone and password:");
		User u = new User();
		u.setPhone(s.nextLong());
		u.setPassword(s.next());
		uDao.loginPhone(u);
	}

	private static void reg() {
		User u = new User();
		System.out.println("Enter the Name, Phone, Email and Password");
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setPassword(s.next());
		System.out.println("User saved with id: " + uDao.register(u).getId());
	}

	private static void update() {
		System.out.println("Enter the Id:");
		if (uDao.update(s.nextInt()) != null)
			System.out.println("Updated succesfully");
	}
}
