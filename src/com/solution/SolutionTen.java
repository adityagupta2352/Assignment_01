package com.solution;

import java.io.IOException;
import java.util.List;

public class SolutionTen {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();

		int deleteId = 2;
		deleteByIdInAddressAndClassAndStudent(classList , studentList , addressList , deleteId);
		
	}

	private static void deleteByIdInAddressAndClassAndStudent(List<Class> classList, List<Student> studentList,
			List<Address> addressList, int deleteId) {
		
		
		
	}

}
