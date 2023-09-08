package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionNine {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();
        int deleteId = 2;
		
		deleteStudentAndAddress(studentList , addressList , deleteId);
		
	}

	private static void deleteStudentAndAddress(List<Student> studentList, List<Address> addressList, int deleteId) {
		
		List<Student> filteredStudent9 = studentList.stream().filter(st -> st.getId() != deleteId).collect(Collectors.toList());
		List<Address> filteredAddress9 = addressList.stream().filter(ad -> ad.getStudentId() != deleteId).collect(Collectors.toList());
		
		System.out.println("After deleting student and address data :- ");
		
		filteredStudent9.forEach(st -> System.out.println("Id :- " + st.getId() + " , Name :- " + st.getName() + " ,Age ;- " + st.getAge()));
		
		filteredAddress9.forEach(st -> System.out.println("Id :- " + st.getId() + " , Student ID :- " + st.getStudentId() + " ,Pincode ;- " + st.getPinCode()));
		
	}

}
