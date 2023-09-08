package com.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solution {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();
		
		// ** First ** 
		int targetPinCode = 0;
		String targetGender = "";
		int targetAge = 0;
		
		/*
		List<Student> filteredStudents = findStudentsByPinCode(classList , studentList , addressList , targetPinCode , targetGender , targetAge);
	
		for(Student student : filteredStudents)
		{
			System.out.println("Id : " + student.getId());
			System.out.println("Name : " + student.getName());
		}
        
		// ** Second **
		String targetCity = "";
		List<Student> filteredStudents2 = findStudentByCity(classList , studentList , addressList , targetCity , targetGender , targetAge);
	
		for(Student student : filteredStudents2)
		{
			System.out.println("Id : " + student.getId());
			System.out.println("Name : " + student.getName());
			System.out.println("Gender : " + student.getGender());
		}
		
		// ** Third **
		 List<Student> filteredStudent3 = findFirstThird(classList , studentList , addressList);
		
		int highestMarks = filteredStudent3.get(0).getMarks();
		int thirdHigh = filteredStudent3.get(2).getMarks();
		
		for(Student student : studentList)
		{
			String rank = "Rest";
			String passStatus = student.getMarks() >= 50 ? "Passed" : "Failed";
			
			if(student.getMarks() == highestMarks) {
				rank = "First";
			}
			else if(student.getMarks() == thirdHigh) {
				rank = "Third";
			}
			
			System.out.println("Student Id : " + student.getId() + 
					           ", Name : " + student.getName() +
					           ", Rank : " + rank +
					           ", Marks : " + student.getMarks() +
					           ", Pass/Fail : " + passStatus);
		}
		
		// ** Fourth ** 
		List<Student> filteredStudent4 = findPassedStudent(classList , studentList , addressList , targetGender , targetAge , targetCity , targetPinCode);
		
		System.out.println("Names of all pass students  :- ");
		for(Student student : filteredStudent4)
		{
			System.out.println("Id " + student.getId());
			System.out.println("Name " + student.getName());
			System.out.println("Gender " + student.getGender());
			System.out.println("Age " + student.getAge());
			System.out.println("Marks " + student.getMarks());
		}
		
		// ** Fifth **
		String targetCity = "";
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
		*/
		
		// ** Eight **
		List<Student> filteredStudent8 = findAbove20FailedStudent(studentList);
		
		for(Student student : filteredStudent8)
		{
			System.out.println("Id " + student.getId());
			System.out.println("Name " + student.getName());
			System.out.println("Gender " + student.getGender());
			System.out.println("Age " + student.getAge());
			System.out.println("Marks " + student.getMarks());
		}
		
		// ** Nine **
		int deleteId = 6;
		
		// deleteByIdInStudentAndAddress(classList , studentList , addressList , deleteId);
		// Main.readAddressDataFromCSV();
		// Main.readStudentDataFromCSV();
	}

	private static List<Student> findAbove20FailedStudent(List<Student> studentList) {
		
		List<Student> filteredStudent8 = new ArrayList<>();
		for(Student student : studentList)
		{
			if(student.getMarks() < 50 && student.getAge() > 20)
			{
			     filteredStudent8.add(student);	
			}
		}
		
		return filteredStudent8;
	}

	private static void deleteByIdInStudentAndAddress(List<Class> classList, List<Student> studentList,
			List<Address> addressList, int deleteId) {
		
		Student studentToDelete = null;
		
		Iterator<Student> studentIterator = studentList.iterator();
		
		while(studentIterator.hasNext()) {
			
			Student student = studentIterator.next();
			
			if(student.getId() == deleteId) {
				
				studentToDelete = student;
				studentIterator.remove();
			}
		}
		
		Iterator<Address> addressIterator = addressList.iterator();
		
		while(addressIterator.hasNext()) {
			Address address = addressIterator.next();
			
			if(address.getStudentId() == deleteId)
			{
				addressIterator.remove();
			}
		}
		
		if (studentToDelete != null) {
            System.out.println("Student with ID " + studentToDelete.getId() + " has been deleted.");
        } else {
            System.out.println("Student with ID " + deleteId + " not found.");
        }
			
	}

	private static List<Student> findFirstThird(List<Class> classList, List<Student> studentList,
			List<Address> addressList) {
		
		List<Student> sortedStudents = studentList.stream().sorted(Comparator.comparingInt(Student::getMarks).reversed()).collect(Collectors.toList());
		
		return sortedStudents;
	}

	private static List<Student> findAllStudent(List<Class> classList, List<Student> studentList,
			List<Address> addressList, String x) {
		
		List<Student> filteredStudent6 = new ArrayList<>();
		
		for(Class classT : classList)
		{
			if(classT.getName().equals(x))
			{
				int id = classT.getId();
				
				List<Student> studentNew  = studentList.stream().filter(s -> s.getClassId() == id).collect(Collectors.toList());
				
				filteredStudent6.addAll(studentNew);
			}
		}
		
		return filteredStudent6;
	}

	private static List<Student> findFailedStudent(List<Class> classList, List<Student> studentList,
			List<Address> addressList, String targetGender, int targetAge, String targetCity, int targetPinCode) {
		
        List<Student> filteredStudent5 = new ArrayList<>();
		
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
		
		return filteredStudent5;
		
	}

	private static List<Student> findPassedStudent(List<Class> classList, List<Student> studentList,
			List<Address> addressList, String targetGender, int targetAge, String targetCity, int targetPinCode) {
		
		List<Student> filteredStudent4 = new ArrayList<>();
		
		for(Student student : studentList)
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
		}
		
		return filteredStudent4;
	}

	private static List<Student> findStudentByCity(List<Class> classList, List<Student> studentList,
			List<Address> addressList, String targetCity, String targetGender, int targetAge) {
		
		
		List<Student> filteredStudents2 = new ArrayList<>();
		
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
		
		return filteredStudents2;
	}

	private static List<Student> findStudentsByPinCode(List<Class> classList, List<Student> studentList,
		
		List<Address> addressList, int targetPinCode, String targetGender, int targetAge) {
		
		List<Student> filteredStudents = new ArrayList<>();
		
		for(Address address : addressList)
		{
			if(address.getPinCode() == targetPinCode)
			{
				int studentId = address.getStudentId();
				
				Student student = studentList.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
				
				if (student != null && (targetGender.isEmpty() || student.getGender().equals(targetGender)) && 
                       (targetAge <= 0 || student.getAge() == targetAge)) {
                    filteredStudents.add(student);
                }
			}
		}
		
		return filteredStudents;
	}
}
