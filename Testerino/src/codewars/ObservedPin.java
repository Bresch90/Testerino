package codewars;

import java.util.*;
import java.util.stream.Collectors;


public class ObservedPin {

	public static void main(String[] args) {
		ArrayList<String> expectation1 = new ArrayList<>(Arrays.asList("5", "7", "8", "9", "0"));
		ArrayList<String> expectation2 = new ArrayList<>(
				Arrays.asList("11", "21", "41", "12", "22", "42", "14", "24", "44"));
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<String> data = new ArrayList<>(Arrays.asList("8", "0", "5"));
		
		
		System.out.println(getPINs("8"));
		System.out.println(expectation1.toString() + " :is answer");
		System.out.println(getPINs("11"));
		expectation2.sort( (s1, s2) -> s1.compareTo(s2));
		System.out.println(expectation2.toString() + " :is answer");
		
		
	}
	
	
	
	
	
	
	public static List<String> getPINs(String observed) {
		HashMap<String, String> nrCloseBy = new HashMap<>(Map.of("1", "124", "2", "1235", "3", "236", "4", "1457", "5",
				"24568", "6", "3569", "7", "478", "8", "57890", "9", "689", "0", "80"));
		List<String> results = new ArrayList<>();
		List<List<String>> numbers = new ArrayList<>(); 
		Arrays.asList(observed.split("")).forEach(c -> numbers.add(Arrays.asList(nrCloseBy.get(String.valueOf(c)).split(""))));
		generatePermutations(numbers, results, 0, "");
		return results;
	} 
	
	private static void generatePermutations(List<List<String>> lists,List<String> results, int depth, String current) {
		//basecase
		if (lists.size() == depth) {
			results.add(current);
			return;
		}
		
		//recursion
		for (int i = 0 ; i < lists.get(depth).size() ; i++) {
			generatePermutations(lists, results, depth + 1, current + lists.get(depth).get(i));
		}
	}
	//just testing some comment git
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void generatePermutationsExample(List<List<?>> lists, List result, int depth, String current) {
		if (depth == lists.size()) {
			result.add(current);
			return;
		}
		
		for (int i = 0; i < lists.get(depth).size(); i++) {
			generatePermutationsExample(lists, result, depth + 1, current + lists.get(depth).get(i));
		}
	}
}
