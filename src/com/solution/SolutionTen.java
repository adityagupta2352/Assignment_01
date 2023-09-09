package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTen {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();
        
		deleteByIdInStudentAndAddressAndClass(classList , studentList , addressList);
	}

	private static void deleteByIdInStudentAndAddressAndClass(List<Class> classList, List<Student> studentList,
			List<Address> addressList) {
		
		List<Integer> listOfClassIdInStudent = studentList.stream().map(st -> st.getClassId()).collect(Collectors.toList());
		
		List<Class> classData = classList.stream().filter(cls -> listOfClassIdInStudent.contains(cls.getId())).collect(Collectors.toList());
		
		classList.retainAll(classData);
		
		classList.forEach(cls -> System.out.println("Id : " + cls.getId() + " Name : " + cls.getName()));	
	}
}
