package com.solution;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Third {

	public static void main(String[] args) throws IOException {

		List<Class> classList = Main.readClassDataFromCSV();
		List<Student> studentList = Main.readStudentDataFromCSV();
		List<Address> addressList = Main.readAddressDataFromCSV();

		List<Student> filteredStudent3 = findFirstThird(classList, studentList, addressList);

		int highestMarks = filteredStudent3.get(0).getMarks();
		int thirdHigh = filteredStudent3.get(2).getMarks();

		studentList.forEach((student) -> {
			String rank = "Rest";
			String passStatus = student.getMarks() >= 50 ? "Passed" : "Failed";

			if (student.getMarks() == highestMarks) {
				rank = "First";
			} else if (student.getMarks() == thirdHigh) {
				rank = "Third";
			}

			System.out.println("Student Id : " + student.getId() + ", Name : " + student.getName() + ", Rank : " + rank
					+ ", Marks : " + student.getMarks() + ", Pass/Fail : " + passStatus);
		});

	}

	private static List<Student> findFirstThird(List<Class> classList, List<Student> studentList,
			List<Address> addressList) {

		List<Student> sortedStudents = studentList.stream()
				.sorted((s1, s2) -> -Integer.compare(s1.getMarks(), s2.getMarks())).collect(Collectors.toList());

		return sortedStudents;

		// List<Student> sortedStudents =
		// studentList.stream().sorted(Comparator.comparingInt(Student::getMarks).reversed()).collect(Collectors.toList());
	}

}
