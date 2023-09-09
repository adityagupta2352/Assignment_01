package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTwo {

	public static void main(String[] args) throws IOException {

		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();
		
		String targetGender = "";
		int targetAge = 0;
		String targetCity = "Indore";
		List<Student> filteredStudents2 = findStudentByCity(studentList , addressList , targetCity , targetGender , targetAge);
		
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
	
	private static List<Student> findStudentByCity(List<Student> studentList,
			List<Address> addressList, String targetCity, String targetGender, int targetAge) {
		
        List<Integer> findStudentIdByCity = addressList.stream().filter(ad -> ad.getCity().equals(targetCity)).map(st -> st.getStudentId()).collect(Collectors.toList());
		
		List<Student> findStudentInfo = studentList.stream().filter(st -> findStudentIdByCity.contains(st.getId())).collect(Collectors.toList());
		
		return findStudentInfo;
		
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
