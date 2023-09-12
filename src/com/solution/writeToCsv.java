package com.solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class writeToCsv {

	static void writeStudentsToCSV(List<Student> studentList, String studentFilePath) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentFilePath))) {
			// Write the header
			writer.write("Id,Name,Class_id,Marks,Gender,Age");
			writer.newLine();

			// Write each student record to the CSV file
			studentList.forEach(student -> {
				try {
					writer.write(String.format("%d,%s,%d,%d,%s,%d", student.getId(), student.getName(),
							student.getClassId(), student.getMarks(), student.getGender(), student.getAge()));
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			System.out.println("Student details have deleted from CSV.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void writeAddressesToCSV(List<Address> addressList, String addressFilePath) {

		try (BufferedWriter write = new BufferedWriter(new FileWriter(addressFilePath))) {

			write.write("Id,Pin_code,City,Student_id");
			write.newLine();

			addressList.forEach(address -> {
				try {
					write.write(String.format("%d,%d,%s,%d", address.getId(), address.getPinCode(), address.getCity(),
							address.getStudentId()));
					write.newLine();

				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			System.out.println("Student address details have deleted from CSV.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeClassToCsv(List<Class> classList , String classFilePath)
	{
		try (BufferedWriter write = new BufferedWriter(new FileWriter(classFilePath))) {

			write.write("Id,Name");
			write.newLine();

			classList.forEach(classData -> {
				try {
					write.write(String.format("%d,%s", classData.getId(), classData.getName()));
					write.newLine();

				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			System.out.println("Class details have deleted from CSV.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
