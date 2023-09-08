package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionEight {

	public static void main(String[] args) throws IOException {
     
		// ** Eight **
		
		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();

		List<Student> filteredStudent8 = findAbove20FailedStudent(studentList);
				
		for(Student student : filteredStudent8)
		{
			System.out.println("Id " + student.getId());
			System.out.println("Name " + student.getName());
			System.out.println("Gender " + student.getGender());
			System.out.println("Age " + student.getAge());
			System.out.println("Marks " + student.getMarks());
		}
		
	}
    
private static List<Student> findAbove20FailedStudent(List<Student> studentList) {
		
		/*
		List<Student> filteredStudent8 = new ArrayList<>();
		for(Student student : studentList)
		{
			if(student.getMarks() < 50 && student.getAge() > 20)
			{
			     filteredStudent8.add(student);	
			}
		}
		*/
		
		List<Student> filteredStudent8 = studentList.stream().filter(s -> s.getMarks() < 50).filter(s -> s.getAge() > 20).collect(Collectors.toList());
		
		return filteredStudent8;
	}
	
}
