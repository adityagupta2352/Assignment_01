package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTwo {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();
		
		// ** Second **
		int targetPinCode = 482002;
		String targetGender = "";
		int targetAge = 0;
		String targetCity = "Indore";
		List<Student> filteredStudents2 = findStudentByCity(classList , studentList , addressList , targetCity , targetGender , targetAge);
		
		filteredStudents2.forEach(student -> System.out.println("Id:" + student.getId() + ", Name : " + student.getName()));
		
		
		/*
		for(Student student : filteredStudents2)
		{
			System.out.println("Id : " + student.getId());
			System.out.println("Name : " + student.getName());
			System.out.println("Gender : " + student.getGender());
		}
		*/

	}
	
	private static List<Student> findStudentByCity(List<Class> classList, List<Student> studentList,
			List<Address> addressList, String targetCity, String targetGender, int targetAge) {
		
		
		List<Student> filteredStudents = studentList.stream()
                .filter(student -> addressList.stream()
                        .anyMatch(address -> address.getStudentId() == student.getId() && address.getCity().equals(targetCity)))
                .collect(Collectors.toList());

		
		return filteredStudents;
		
		/*
		for(Address address : addressList)
		{
			if(address.getCity().equals(targetCity))
			{
				int StudentId = address.getStudentId();
				
				Stream<Student> stream = studentList.stream();
				
				Student student = stream.filter(s -> s.getId() == StudentId).findFirst().orElse(null);
				
				if(student != null && (targetGender.isEmpty()) || student.getGender().equals(targetGender) && (targetAge <= 0 || student.getAge() <= targetAge))
				{
					filteredStudents2.add(student);
				}
			}
		}
		*/
	}
}
