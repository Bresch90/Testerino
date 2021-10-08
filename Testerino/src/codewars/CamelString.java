package codewars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CamelString {

	public CamelString() {
	}

	public static void main(String[] args) {
		String s = new String("The_Stealth-Warrior");
		
		System.out.println(toCamelFirst(s));
		System.out.println("theStealthWarrior :Is answer");
		System.out.println(toCamel(s));
	}
	
	public static String toCamelFirst(String s) {
		StringBuilder result = new StringBuilder();
		char lastChar = 'a';
		for (char c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				if (Character.isUpperCase(c)) {
					result.append(Character.toLowerCase(c));
				} else {
					result.append(c);
				}
			}
			if (Character.isAlphabetic(lastChar) != true) {
				result.setCharAt(result.length() - 1, Character.toUpperCase(result.charAt(result.length() - 1)));
			}
			lastChar = c;
		}
		Character.toLowerCase(result.charAt(0));
		return result.toString();
	}
	
	public static String toCamel(String s) {
		String result = Stream.of(s.split("_|-"))
				.map(c -> Character.toUpperCase(c.charAt(0)) + c.substring(1))
				.collect(Collectors.joining());
		
		return Character.toLowerCase(result.charAt(0))+result.substring(1);
	}

}
