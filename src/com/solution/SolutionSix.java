package com.solution;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

public class SolutionSix {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();

		String x = "A";
		List<Student> filteredStudent6 = findAllStudent(classList , studentList , addressList , x);
		
		filteredStudent6.forEach(st -> System.out.println("Id " + st.getId() + " Name " + st.getName() + " Gender " + st.getGender()
		+ " Age " + st.getAge() + " Marks " + st.getMarks()));
		
		/*
		for(Student student : filteredStudent6)
		{
			System.out.println("Id " + student.getId());
			System.out.println("Name " + student.getName());
			System.out.println("Gender " + student.getGender());
			System.out.println("Age " + student.getAge());
			System.out.println("Marks " + student.getMarks());
		}
		*/
		
	}
	
	private static List<Student> findAllStudent(List<Class> classList, List<Student> studentList, List<Address> addressList, String x) {
		
		List<Integer> classId = classList.stream().filter(cls -> cls.getName().equals(x)).map(cls -> cls.getId()).collect(Collectors.toList());
		
		return studentList.stream().filter(s -> classId.contains(s.getClassId())).collect(Collectors.toList());
		
		
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
