package com.lambda;

public class Book {
 private int id;
 private String name;
 private int page;
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
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public Book(int id, String name, int page) {
	super();
	this.id = id;
	this.name = name;
	this.page = page;
}
@Override
public String toString() {
	return "id=" + id + ", name=" + name + ", page=" + page + "\n";
}
 
 
}
