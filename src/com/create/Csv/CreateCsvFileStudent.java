package com.create.Csv;

import java.io.FileWriter;

public class CreateCsvFileStudent {

	public static void main(String[] args) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Id").append(",").append("Name").append(",").append("Class_id").
		append(",").append("Marks").append(",").append("Gender").append(",").append("Age").append("\n");
 
		stringBuilder.append("1").append(",").append("Stud1").append(",").append("1").
		append(",").append("88").append(",").append("F").append(",").append("10").append("\n");
 		
		stringBuilder.append("2").append(",").append("Stud2").append(",").append("1").
		append(",").append("70").append(",").append("F").append(",").append("11").append("\n");
 	
		stringBuilder.append("3").append(",").append("Stud3").append(",").append("2").
		append(",").append("88").append(",").append("M").append(",").append("22").append("\n");
 
		stringBuilder.append("4").append(",").append("Stud4").append(",").append("2").
		append(",").append("55").append(",").append("M").append(",").append("33").append("\n");
 
		stringBuilder.append("5").append(",").append("Stud5").append(",").append("1").
		append(",").append("30").append(",").append("F").append(",").append("44").append("\n");
 
		stringBuilder.append("6").append(",").append("Stud6").append(",").append("3").
		append(",").append("30").append(",").append("F").append(",").append("33").append("\n");
 
		stringBuilder.append("7").append(",").append("Stud7").append(",").append("3").
		append(",").append("10").append(",").append("F").append(",").append("22").append("\n");
 
		stringBuilder.append("8").append(",").append("Stud8").append(",").append("3").
		append(",").append("0").append(",").append("M").append(",").append("11").append("\n");
        
		try(FileWriter writer = new FileWriter("E:\\temp\\studentData.csv")){
			
			writer.write(stringBuilder.toString());
			System.out.println("csv file created2...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
