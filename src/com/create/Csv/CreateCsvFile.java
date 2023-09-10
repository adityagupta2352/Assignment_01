package com.create.Csv;

import java.io.FileWriter;

public class CreateCsvFile {

	public static void main(String[] args) {

		StringBuilder stringbuilder = new StringBuilder();

		stringbuilder.append("Id").append(",").append("Name").append(",").append("Pin_code").append(",").append("City")
				.append(",").append("Student_Id").append("\n");

		stringbuilder.append("1").append(",").append("Aditya").append(",").append("451551").append(",")
				.append("Barwani").append(",").append("1").append("\n");

		stringbuilder.append("2").append(",").append("Anuj").append(",").append("451551").append(",").append("Barwani")
				.append(",").append("2").append("\n");

		try (FileWriter write = new FileWriter("E:\\temp\\student.csv")) {

			write.write(stringbuilder.toString());
			System.out.println("Csv file created...");

		} catch (Exception e) {

		}

	}

}
