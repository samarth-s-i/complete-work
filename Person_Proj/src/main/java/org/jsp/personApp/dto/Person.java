package org.jsp.personApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@NamedQueries(value = { @NamedQuery(name = "findByAge", query = "select p from Person p where p.age=?1"),
		@NamedQuery(name = "findByPhone", query = "select p from Person p where p.phone=?1"),
		@NamedQuery(name = "findByEmail", query = "select p from Person p where p.email=?1"),
		@NamedQuery(name = "findByName", query = "select p from Person p where p.name=?1"),
		@NamedQuery(name = "findByAllNames", query = "select p.name from Person p"),
		@NamedQuery(name = "findAll", query = "select p from Person p"),
		@NamedQuery(name = "fetchIdByName", query = "select p.id from Person p where p.name=?1"),
		@NamedQuery(name = "fetchPhoneByName", query = "select p.phone from Person p where p.name=?1") })
public class Person {
	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int age;
	private String name;
	private long phone;
	private String email;
	private String password;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
