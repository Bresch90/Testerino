package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CeasarCipher {

	public static void main(String[] args) {
		String u = "I should have known that you would have a perfect answer for me!!!";
		List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv",
				" lvz wp!!!");		//  I should have known that
		String b = "Exult, O shores, and ring, O bells! But I, with mournful tread, Walk the deck my Captain lies, Fallen cold and dead.";

		System.out.println(movingShift(u, 1).toString());
		System.out.println(v.toString());
		System.out.println(demovingShift(v, 1));
		System.out.println(u);
		System.out.println(movingShift(b, 1).toString());
	}

	public static List<String> movingShift(String s, int shift) {
		ArrayList<String> results = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				int asciLimit = (Character.isLowerCase(c) ? 122 : 90);
				while (c + shift > asciLimit) {
					c -= 26;
				}
				c += shift;
			}
			sb.append((char)c);
			shift++;

		}
		
		int miniLength = (int) Math.ceil(sb.length() / 5.0);
		for (int i = 0, start = 0; i < 5; i++, start += miniLength) {
			if (start - 1 == sb.length()) {
				results.add("");
			} else {
				results.add(sb.substring(start, 
						(start + miniLength > sb.length() ? sb.length() : start + miniLength)));
			}
		}
		return results;
	}

	public static String demovingShift(List<String> s, int shift) {
		StringBuilder sb = new StringBuilder();
		for (char c :  String.join("", s).toCharArray()) {
			int asciLimit = (Character.isLowerCase(c) ? 97 : 65);
			
			if (Character.isAlphabetic(c)) {
				while (c - shift < asciLimit) c += 26;
				c -= shift;
			}
			sb.append(c);
			shift++;
		}
		return sb.toString();
	}
}
