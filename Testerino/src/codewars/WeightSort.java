package codewars;
import java.util.*;
import java.util.stream.*;






public class WeightSort {

	public WeightSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String strng = "2000 10003 1234000 44444444 9999 11 11 22 123";
		
		
		System.out.println(firstSort(strng));
		System.out.println("11 11 2000 10003 22 123 1234000 44444444 9999 :is answer");
		System.out.println(sorting(strng));
		System.out.println("11 11 2000 10003 22 123 1234000 44444444 9999 :is answer");
		System.out.println(mySorting(strng));
		System.out.println(newSorting(strng));
		System.out.println("11 11 2000 10003 22 123 1234000 44444444 9999 :is answer");
		System.out.println(Stream.of(strng.trim().split(" "))
				.sorted()
				.sorted(Comparator.comparingInt(o -> o.chars().map(Character::getNumericValue).sum()))
				.collect(Collectors.joining(" ")));
	}
	
	public static String mySorting(String strng) {
		String result = "";
		
		System.out.println(Arrays.stream(strng.split(" "))
				.map(c -> String.valueOf(Integer.valueOf(c+1)))
				.collect(Collectors.joining(" ")));
		
		String[] strings = strng.split(" ");
		System.out.println(Stream.of(strings).sorted().collect(Collectors.joining(" ")));
		System.out.println(Stream.of(strings).sorted()
				.sorted(Comparator.comparingInt(Integer::valueOf))
				.collect(Collectors.joining(" ")));
		
		
		
		
		
		
		return result;
	}
	
	
	public static String sorting(String strng) {
		//return Arrays.stream(strng.split(" ")).sorted()
		return Arrays.stream(strng.split(" ")).sorted(Comparator
		                .comparing(WeightSort::sumDigits)
		                .thenComparing(String::compareTo))
		              .collect(Collectors.joining(" "));
	}
	private static Integer sumDigits(String s) {
	    return s.chars().map(c -> c - 48).sum();
	  }
	
	
	
	
	public static String firstSort(String strng) {
		String result = "";
		String[] stringArray = strng.split(" ");
		ArrayList<Integer> scoreArray = new ArrayList<>();
		Arrays.sort(stringArray);
		for (int i = 0, value = 0; i < stringArray.length ; i++) {
			value = 0;
			for (int v : stringArray[i].toCharArray()) {
				value += v - '0';
			}
			scoreArray.add(value);
		}
		while (Collections.min(scoreArray) != 2147483647) {
			result += stringArray[scoreArray.indexOf(Collections.min(scoreArray))]+" ";
			scoreArray.set(scoreArray.indexOf(Collections.min(scoreArray)), 2147483647);
		}	
		return result.strip();
	}
	
	static String newSorting(String strng) {
		return Stream.of(strng.split(" ")).sorted()
				.sorted(Comparator.comparingInt(c-> c.chars().map(Character::getNumericValue).sum()))
				.collect(Collectors.joining(" "));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
