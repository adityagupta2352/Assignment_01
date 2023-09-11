package com.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionSeven {

	public static void main(String[] args) throws IOException {

		SolutionSeven.readStudentDataFromCSV();
		SolutionSeven.readAddressDataFromCSV();
		SolutionSeven.readClassDataFromCSV();
	}

	static void readStudentDataFromCSV() {

		String fileName = "src//StudentData.csv"; // Replace with your CSV file path

		try {
			List<Student> studentList = Files.lines(Paths.get(fileName)).skip(1) // Skip the header line
					.map(line -> {
						String[] data = line.split(","); // Split by coma
						int id = Integer.parseInt(data[0]);
						String name = data[1];
						int classId = Integer.parseInt(data[2]);
						int marks = Integer.parseInt(data[3]);
						String gender = data[4];
						int age = Integer.parseInt(data[5]);
						return new Student(id, name, classId, marks, gender, age);
					}).collect(Collectors.toList());

			for (Student student : studentList) {
				System.out.print("ID :- " + student.getId());
				System.out.print(" Name :- " + student.getName());
				System.out.print(" Class Id :- " + student.getClassId());
				System.out.print(" Marks :- " + student.getMarks());
				System.out.print(" Gender :- " + student.getGender());
				System.out.print(" Age :- " + student.getAge());
				System.out.println();
			}

			// Now you have a List<Student> containing the data from the CSV
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readAddressDataFromCSV() throws IOException {

		String fileName = "src\\AddressData.csv";

		try {
			List<Address> addressList = Files.lines(Paths.get(fileName)).skip(1) // Skip the header line
					.map(line -> {
						String[] row = line.split(",");
						int id = Integer.parseInt(row[0]);
						int pinCode = Integer.parseInt(row[1]);
						String city = row[2];
						int studentId = Integer.parseInt(row[3]);
						return new Address(id, pinCode, city, studentId);
					}).collect(Collectors.toList());

			for (Address address : addressList) {
				System.out.print("ID :- " + address.getId());
				System.out.print(" Pincode :- " + address.getPinCode());
				System.out.print(" City :- " + address.getCity());
				System.out.print(" StudentId :- " + address.getStudentId());
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void readClassDataFromCSV() throws IOException {

		String fileName = "src\\ClassData.csv";

		try {
			List<Class> classList = Files.lines(Paths.get(fileName)).skip(1) // Skip the header line
					.map(line -> {
						String[] row = line.split(",");
						int id = Integer.parseInt(row[0]);
						String name = row[1];
						return new Class(id, name);
					}).collect(Collectors.toList());

			for (Class cls : classList) {
				System.out.print(" Id :- " + cls.getId());
				System.out.print(" Name :- " + cls.getName());
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
