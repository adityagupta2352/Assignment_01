package com.create.Csv;

import java.io.FileWriter;

public class CreateCsvFileAddress {

	public static void main(String[] args) {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("Id").append(",").append("Pin_code").append(",").append("City").append(",")
				.append("Student_id").append("\n");

		stringBuilder.append("1").append(",").append("452002").append(",").append("Indore").append(",").append("1")
				.append(",").append("\n");

		stringBuilder.append("2").append(",").append("422002").append(",").append("Delhi").append(",").append("1")
				.append(",").append("\n");

		stringBuilder.append("3").append(",").append("442002").append(",").append("Indore").append(",").append("2")
				.append(",").append("\n");

		stringBuilder.append("4").append(",").append("462002").append(",").append("Delhi").append(",").append("3")
				.append(",").append("\n");

		stringBuilder.append("5").append(",").append("472002").append(",").append("Indore").append(",").append("4")
				.append(",").append("\n");

		stringBuilder.append("6").append(",").append("452002").append(",").append("Indore").append(",").append("5")
				.append(",").append("\n");

		stringBuilder.append("7").append(",").append("452002").append(",").append("Delhi").append(",").append("5")
				.append(",").append("\n");

		stringBuilder.append("8").append(",").append("482002").append(",").append("Mumbai").append(",").append("6")
				.append(",").append("\n");

		stringBuilder.append("9").append(",").append("482002").append(",").append("Bhopal").append(",").append("7")
				.append(",").append("\n");

		stringBuilder.append("10").append(",").append("482002").append(",").append("Indore").append(",").append("8")
				.append(",").append("\n");

		try (FileWriter writer = new FileWriter("E:\\temp\\AddressData.csv")) {

			writer.write(stringBuilder.toString());
			System.out.println("csv file created3...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
