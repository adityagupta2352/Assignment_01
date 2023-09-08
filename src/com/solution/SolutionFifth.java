package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionFifth {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();


		// ** Fifth **
		int targetPinCode = 482002;
		String targetGender = "";
		int targetAge = 0;
		String targetCity = "Indore";
	
		List<Student> filteredStudent5 = findFailedStudent(classList , studentList , addressList , targetGender , targetAge , targetCity , targetPinCode);
				
		System.out.println("Names of all fail students  :- ");
		for(Student student : filteredStudent5)
		{
			System.out.println("Id " + student.getId());
			System.out.println("Name " + student.getName());
			System.out.println("Gender " + student.getGender());
			System.out.println("Age " + student.getAge());
			System.out.println("Marks " + student.getMarks());
		}
	}
	
	private static List<Student> findFailedStudent(List<Class> classList, List<Student> studentList,
			List<Address> addressList, String targetGender, int targetAge, String targetCity, int targetPinCode) {
		
        List<Student> filteredStudent5 = studentList.stream().filter(st -> st.getMarks() < 50).collect(Collectors.toList());
        
        return filteredStudent5;
		
        /*
		for(Student student : studentList)
		{
			if(student.getMarks() < 50)
			{
				int studentId = student.getId();
				
				Student studentNew = studentList.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
				
				Address addressNew = addressList.stream().filter(a -> a.getStudentId() == studentId).findFirst().orElse(null);
				
				if(studentNew != null && (targetGender.isEmpty() 
						|| studentNew.getGender().equals(targetGender)) && (targetAge <= 0 || studentNew.getAge() == targetAge) && targetCity.isEmpty() || addressNew.getCity().equals(targetGender) && targetPinCode <= 0 || addressNew.getPinCode() == targetPinCode);
				{
					filteredStudent5.add(studentNew);
				}
			}
		}
		*/
	}

}
