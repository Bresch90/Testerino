package codewars;

import java.util.Arrays;

public class CreatePhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
		System.out.println("(123) 456-7890 :is answer");
	}
	
	public static String createPhoneNumber(int[] numbers) {
		String result = Arrays.toString(numbers).replaceAll("[, \\[\\]]", "");		
		return "("+result.substring(0, 3)+") "+result.substring(3, 6)+"-"+result.substring(6);
	}
}
