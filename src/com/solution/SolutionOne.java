package com.solution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionOne 
{
			public static void main(String args[]) throws IOException
			{
				List<Student> studentList = Main.readStudentDataFromCSV();
				List<Address> addressList = Main.readAddressDataFromCSV();
				
				// ** First ** 
				int targetPinCode = 482002;
				String targetGender = "";
				int targetAge = 0;
				
				List<Student> filteredStudents = findStudentsByPinCode(studentList , addressList , targetPinCode , targetGender , targetAge);
			
				filteredStudents.forEach(student -> System.out.println("Id:" + student.getId() + ", Name : " + student.getName()));
				
				/*
				for(Student student : filteredStudents)
				{
					System.out.println("Id : " + student.getId());
					System.out.println("Name : " + student.getName());
				}*/
				
			}
			
			private static List<Student> findStudentsByPinCode(List<Student> studentList,
					
					List<Address> addressList, int targetPinCode, String targetGender, int targetAge) {
				
				    // ** One Way ** 
				    List<Integer> findStudentIdByPin = addressList.stream().filter(ad -> ad.getPinCode() == targetPinCode).map(ad -> ad.getStudentId()).collect(Collectors.toList());
					
					List<Student> findStudentInfo = studentList.stream()
							.filter(st -> findStudentIdByPin.contains(st.getId())).collect(Collectors.toList());
				    
				    return findStudentInfo;
				    
				    // ** SECOND WAY **
				    /*
					List<Student> filteredStudents = studentList.stream()
			                .filter(student -> hasMatchingPinCode(student.getId(), addressList, targetPinCode))
			                .collect(Collectors.toList());
					
					return filteredStudents;
					*/

                    /*
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
					}*/
				}
				
			    /*
				private static boolean hasMatchingPinCode(int studentId, List<Address> addressList, int targetPinCode) {
					return addressList.stream()
			                .anyMatch(address -> address.getStudentId() == studentId && address.getPinCode() == targetPinCode);
				}
				*/


}
