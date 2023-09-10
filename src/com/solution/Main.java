package com.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static List<Address> readAddressDataFromCSV() throws IOException {

		String file = "src\\AddressData.csv";
		BufferedReader reader = null;
		String line = "";
		boolean isHeaderLine = true;
		List<Address> addressList = new ArrayList<Address>();

		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {

				if (isHeaderLine) {
					isHeaderLine = false;
					continue;
				}

				String[] row = line.split(",");

				int id = Integer.parseInt(row[0]);
				int pinCode = Integer.parseInt(row[1]);
				String city = row[2];
				int studentId = Integer.parseInt(row[3]);

				// address.add(new Address(id , pinCode , city , studentId));
				Address address = new Address(id, pinCode, city, studentId);
				addressList.add(address);
			}

			/*
			 * for(Address address : addressList) { System.out.print("ID :- " +
			 * address.getId()); System.out.print(" Pincode :- " + address.getPinCode());
			 * System.out.print(" City :- " + address.getCity());
			 * System.out.print(" StudentId :- " + address.getStudentId());
			 * System.out.println(); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}

		return addressList;
	}

	static List<Student> readStudentDataFromCSV() throws IOException {

		String file = "src\\StudentData.csv";
		BufferedReader reader = null;
		String line = "";
		boolean isHeaderLine = true;
		List<Student> studentList = new ArrayList<Student>();

		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {

				if (isHeaderLine) {
					isHeaderLine = false;
					continue;
				}

				String[] row = line.split(",");

				int id = Integer.parseInt(row[0]);
				String name = row[1];
				int classId = Integer.parseInt(row[2]);
				int marks = Integer.parseInt(row[3]);
				String gender = row[4];
				int age = Integer.parseInt(row[5]);

				Student student = new Student(id, name, classId, marks, gender, age);
				studentList.add(student);
			}

			/*
			 * for(Student student : studentList) { System.out.print("ID :- " +
			 * student.getId()); System.out.print(" Name :- " + student.getName());
			 * System.out.print(" Class Id :- " + student.getClassId());
			 * System.out.print(" Marks :- " + student.getMarks());
			 * System.out.print(" Gender :- " + student.getGender());
			 * System.out.print(" Age :- " + student.getAge()); System.out.println(); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}

		return studentList;

	}

	static List<Class> readClassDataFromCSV() throws IOException {

		String file = "src\\ClassData.csv";
		BufferedReader reader = null;
		String line = "";
		boolean isHeaderLine = true;
		List<Class> classList = new ArrayList<Class>();

		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {

				if (isHeaderLine) {
					isHeaderLine = false;
					continue;
				}

				String[] row = line.split(",");

				int id = Integer.parseInt(row[0]);
				String name = row[1];

				Class student = new Class(id, name);
				classList.add(student);
			}

			/*
			 * for(Class cls : classList) { System.out.print(" Id :- " + cls.getId());
			 * System.out.print(" Name :- " + cls.getName()); System.out.println(); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return classList;
	}

}
