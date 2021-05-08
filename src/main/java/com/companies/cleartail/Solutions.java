package com.companies.cleartail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solutions {

	public static void main(String[] args) {

		List<String> strList = Arrays.asList("test1", "test2", "test3", "test4", "test5");

		List<String> remainingList = removeGivenValue(strList, "test1");

		// System.out.println("list without test1::::" + remainingList);

		List<Integer> nums = Arrays.asList(2, 4, 6, 9, 3, 5);

		int maxValueFromArray = maxValueFromArray(nums);
		// System.out.println(maxValueFromArray);

		List<Student> citiList = Arrays.asList(new Student("student1", "Bangloru"), new Student("student2", "Noida"),
				new Student("student3", "Delhi"), new Student("student4", "Mumbai"), new Student("student5", "Mumbai"));
		int updateCitiStdCount = updatedCityOfStudentObject(citiList);
		// System.out.println(updateCitiStdCount);

		List<String> duplicateValuesList = Arrays.asList("test1", "test2", "test1", "test2", "test5");
		List<String> valuesList = removeDuplicateFromList(duplicateValuesList);
		// System.out.println(valuesList);

		List<Integer> numbers = Arrays.asList(2, 4, 6, 9, 7, 3, 5);
		int secondLargestElement = secondLargestElement(numbers);
		System.out.println(secondLargestElement);
	}

	private static int secondLargestElement(List<Integer> numbers) {
		return numbers.stream().sorted().collect(Collectors.toList()).get(numbers.size() - 2);
	}

	private static List<String> removeDuplicateFromList(List<String> duplicateValuesList) {
		return duplicateValuesList.stream().distinct().collect(Collectors.toList());
	}

	private static int updatedCityOfStudentObject(List<Student> citiList) {
		List<Student> mumbaiStudents = citiList.stream().filter(s -> s.getCiti().equals("Mumbai"))
				.collect(Collectors.toList());
		List<Student> updatedList = new ArrayList<>();
		for (Student student : mumbaiStudents) {
			if (student.getCiti().equals("Mumbai")) {
				student.setCiti("Delhi");
			}
			updatedList.add(student);
		}
		return updatedList.size();
	}

	private static int maxValueFromArray(List<Integer> nums) {
		return nums.stream().reduce(0, (a, b) -> (a > b) ? a : b).intValue();

	}

	private static List<String> removeGivenValue(List<String> strList, String value) {
		List<String> list = strList.stream().filter(s -> !s.equals(value)).collect(Collectors.toList());
		return list;
	}

}

class Student {
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
