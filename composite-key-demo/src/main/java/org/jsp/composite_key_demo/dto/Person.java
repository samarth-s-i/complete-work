package org.jsp.composite_key_demo.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person {
	@EmbeddedId
	private PersonId id;

	public PersonId getId() {
		return id;
	}

	public void setId(PersonId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String name;
	private int age;
}
