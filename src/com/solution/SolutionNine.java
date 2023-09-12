package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionNine {

	public static void main(String[] args) throws IOException {

		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();
		int deleteId = 8;

		String studentFilePath = "src//StudentData.csv";
		String addressFilePath = "src//AddressData.csv";

		deleteStudentAndAddress(studentList, addressList, deleteId, studentFilePath, addressFilePath);

	}

	private static void deleteStudentAndAddress(List<Student> studentList, List<Address> addressList, int deleteId,
			String studentFilePath, String addressFilePath) {

		List<Student> filteredStudent9 = studentList.stream().filter(st -> st.getId() != deleteId)
				.collect(Collectors.toList());
		List<Address> filteredAddress9 = addressList.stream().filter(ad -> ad.getStudentId() != deleteId)
				.collect(Collectors.toList());

		// ** TO DELETE FROM CSV
		writeToCsv.writeStudentsToCSV(filteredStudent9, studentFilePath);
		writeToCsv.writeAddressesToCSV(filteredAddress9, addressFilePath);

		/*
		 * It will delete from the student list not from the CSV filea
		 * studentList.removeAll(filteredStudent9);
		 * addressList.removeAll(filteredAddress9);
		 */

		System.out.println("After deleting student data :- ");

		filteredStudent9.forEach(st -> System.out
				.println("Id :- " + st.getId() + " , Name :- " + st.getName() + " ,Age ;- " + st.getAge()));

		System.out.println("After deleting address data :- ");

		filteredAddress9.forEach(st -> System.out.println(
				"Id :- " + st.getId() + " , Student ID :- " + st.getStudentId() + " ,Pincode ;- " + st.getPinCode()));

	}

}
