package com.solution;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

public class SolutionSix {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();

		// ** Six **
		String targetCity = "Indore";
		String x = "A";
		List<Student> filteredStudent6 = findAllStudent(classList , studentList , addressList , x);
		
		for(Student student : filteredStudent6)
		{
			System.out.println("Id " + student.getId());
			System.out.println("Name " + student.getName());
			System.out.println("Gender " + student.getGender());
			System.out.println("Age " + student.getAge());
			System.out.println("Marks " + student.getMarks());
		}
		
	}
	
	private static List<Student> findAllStudent(List<Class> classList, List<Student> studentList, List<Address> addressList, String x) {
		
		List<Class> className = classList.stream().filter(cls -> cls.getName().equals(x)).collect(Collectors.toList());
		
		List<Integer> id = className.stream().map(s -> s.getId()).collect(Collectors.toList());
		
		return studentList.stream().filter(s -> id.contains(s.getClassId())).collect(Collectors.toList());
		
		/*
		List<Student> filteredStudent6 = classList.stream()
			    .filter(classT -> classT.getName().equals(x))
			    .map(Class::getId)
			    .flatMap(classId -> studentList.stream().filter(student -> student.getClassId() == classId))
			    .collect(Collectors.toList());
		*/
		
		/*
		for(Class classT : classList)
		{
			if(classT.getName().equals(x))
			{
				int id = classT.getId();
				
				List<Student> studentNew  = studentList.stream().filter(s -> s.getClassId() == id).collect(Collectors.toList());
				
				filteredStudent6.addAll(studentNew);
			}
		}
		*/
		
//		return filteredStudent6;
	}

}
