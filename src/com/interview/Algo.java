package com.test;

import java.util.Scanner;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Algo {

	public static void main(String[] args) {
		System.out.println(mathFunction(1, 2, 3));
		System.out.println(mathFunction(2, 2, 4));
		System.out.println(mathFunction(3, -3, -9));
		System.out.println(mathFunction(1, 2, -1));
		System.out.println(mathFunction(3, 3, 1));
		System.out.println(mathFunction(7, 1, 11));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input 3 values with a space in between them ex: 1 2 3");
		System.out.println("Type quit to exit the application.");
		while(true) {
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("quit")) {
				sc.close();
				break;
			}
			
			if(input.contains(" ")) {
				String[] partitionedFormat = input.split(" ");
				if(partitionedFormat.length != 3) {
					System.err.println("Wrong Format: Please input 3 values with a space in "
							+ "between them ex: 1 2 3");
					continue;
				}

				int a = Integer.parseInt(partitionedFormat[0]);
				int b = Integer.parseInt(partitionedFormat[1]);
				int answer = Integer.parseInt(partitionedFormat[2]);
				
				System.out.println("Possible Arithmetic Operations: " + mathFunction(a, b, answer));
			}

		}
	}
	
	/**
	 * Junit test function
	 */
	@Test
	public void testMathFunction() {
		
		Assertions.assertEquals("+", mathFunction(1,2,3));
		Assertions.assertEquals("+*", mathFunction(2, 2, 4));
		Assertions.assertEquals("*", mathFunction(3, -3, -9));
		Assertions.assertEquals("-", mathFunction(1, 2, -1));
		Assertions.assertEquals("/", mathFunction(3, 3, 1));
		Assertions.assertEquals("None", mathFunction(7, 1, 11));
	}

	/**
	 * Determines which arithmetic operation can be used to determine the answer to two values
	 * @param a value one
	 * @param b value two
	 * @param answer the answer between the two values
	 * @return response
	 */
	public static String mathFunction(int a, int b, int answer) {
		String response = "";
		if(a + b == answer) {
			response += "+";
		}
		if(a * b == answer) {
			response += "*";
		}
		if(a / b == answer) {
			response += "/";
		}
		if(a - b == answer) {
			response += "-";
		}
		//If the string is equal we can safely say no operations equal to the answer with the two values
		if(response == "") {
			response += "None";
		}
		return response;
	}
}
