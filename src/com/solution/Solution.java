package com.solution;

import java.io.IOException;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();

	}
}
