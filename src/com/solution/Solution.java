package com.solution;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws IOException {

		// ** Eleven **
		
		// ** First **
		List<Student> studentList = Main.readStudentDataFromCSV();
		int startPage = 1 , pageSize = 9;
		List<Student> filteredStudentList = readFemaleStudentByPage(studentList , startPage , pageSize);
		// filteredStudentList.forEach(st -> System.out.println("Id " + st.getId() + " Name  " + st.getName()));
		
		// ** Second **
		startPage = 1 ; int endPage = 8;
		List<Student> filteredStudentList2 = readFemaleStudentOrderByName(studentList , startPage , endPage);
	    // filteredStudentList2.forEach(st -> System.out.println("Id " + st.getId() + " Name  " + st.getName()));
		
		// ** Third + Fourth **
		startPage = 1 ; endPage = 8;
		List<Student> filteredStudentList3 = readFemaleStudentOrderByMarks(studentList , startPage , endPage);
	    filteredStudentList2.forEach(st -> System.out.println("Id " + st.getId() + " Name  " + st.getName() + " Marks " + st.getMarks()));
	}
	
	private static List<Student> readFemaleStudentOrderByMarks(List<Student> studentList, int startPage, int pageSize) {
		
		List<Student> filteredStudentList = studentList.stream()
			    .filter(st -> "F".equals(st.getGender()))
			    .skip((startPage - 1) * pageSize)
			    .limit(pageSize)
			    .sorted(Comparator.comparingInt(Student::getMarks))
			    .collect(Collectors.toList());
		
		return filteredStudentList;
	}

	private static List<Student> readFemaleStudentOrderByName(List<Student> studentList, int startPage, int pageSize) {
		
		List<Student> filteredStudentList = studentList.stream()
			    .filter(st -> "F".equals(st.getGender())).skip((startPage - 1) * pageSize).limit(pageSize).sorted(Comparator.comparing(Student::getName))
			    .collect(Collectors.toList());
		
		return filteredStudentList;
	}

	private static List<Student> readFemaleStudentByPage(List<Student> studentList, int startPage, int pageSize) {
		
		List<Student> filteredStudentList = studentList.stream()
			    .filter(st -> "F".equals(st.getGender()))
			    .skip((startPage - 1) * pageSize)
			    .limit(pageSize)
			    .collect(Collectors.toList());
		
		return filteredStudentList;
	}
	
	
}


