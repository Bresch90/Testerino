package codewars;

public class EncryptThis {

	public static void main(String[] args) {
		System.out.println(encryptThis("A wise old owl lived in an oak"));
		System.out.println("65 119esi 111dl 111lw 108dvei 105n 97n 111ka :is answer");

	}

	public static String encryptThis(String text) {
		if (text.isEmpty()) return text;
		String result = "";
		for (String word : text.split(" ")) {
			result += " " + (int)word.charAt(0);
			if (word.length() > 1) {
				char[] chars = word.substring(1).toCharArray();
				char temp = chars[0];
				chars[0] = chars[chars.length - 1];
				chars[chars.length - 1] = temp;
				result += String.valueOf(chars);
			}
		}
		return result.strip();
	}
}
