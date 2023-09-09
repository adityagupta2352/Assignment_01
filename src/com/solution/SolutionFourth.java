package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionFourth {

	public static void main(String[] args) throws IOException {

		// ** Fourth ** 
		
		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();
		
		int targetPinCode = 482002;
		String targetGender = "";
		int targetAge = 0;
		String targetCity = "Indore";
		
		List<Student> filteredStudent4 = findPassedStudent(classList , studentList , addressList , targetGender , targetAge , targetCity , targetPinCode);
				
		System.out.println("Names of all pass students  :- ");
		
		filteredStudent4.forEach(st -> System.out.println("Id " + st.getId() + " Name " + st.getName() + " Gender " + st.getGender()
		+ " Age " + st.getAge() + " Marks " + st.getMarks()));
		
		/*
		for(Student student : filteredStudent4)
		{
			System.out.println("Id " + student.getId());
			System.out.println("Name " + student.getName());
			System.out.println("Gender " + student.getGender());
			System.out.println("Age " + student.getAge());
			System.out.println("Marks " + student.getMarks());
		}
		*/
		
		
	}
	
	private static List<Student> findPassedStudent(List<Class> classList, List<Student> studentList,
			List<Address> addressList, String targetGender, int targetAge, String targetCity, int targetPinCode) {
		
		List<Student> filteredStudent4 = studentList.stream().filter(st -> st.getMarks() > 50).collect(Collectors.toList());

		return filteredStudent4;
		
		/* for(Student student : studentList)
		{
			if(student.getMarks() >= 50)
			{
				int studentId = student.getId();
				
				Student studentNew = studentList.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
				
				Address addressNew = addressList.stream().filter(a -> a.getStudentId() == studentId).findFirst().orElse(null);
				
				
				if(studentNew != null && (targetGender.isEmpty() 
						|| studentNew.getGender().equals(targetGender)) && (targetAge <= 0 || studentNew.getAge() == targetAge) && targetCity.isEmpty() || addressNew.getCity().equals(targetGender) && targetPinCode <= 0 || addressNew.getPinCode() == targetPinCode);
				{
					filteredStudent4.add(studentNew);
				}
			}
		} */
	}

}
