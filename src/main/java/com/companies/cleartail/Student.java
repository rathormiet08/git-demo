package com.companies.cleartail;

public class Student {
	private String name;
	private String citi;

	public Student() {
	}

	public Student(String name, String citi) {
		super();
		this.name = name;
		this.citi = citi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCiti() {
		return citi;
	}

	public void setCiti(String citi) {
		this.citi = citi;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", citi=" + citi + "]";
	}

}
