package codewars;

public class Disemvowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(disemvowel("No offense but,\nYour writing is among the worst I've ever read"));
		System.out.println("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd: is answer");
	}
	
	public static String disemvowel(String str) {
		return str.replaceAll("[aeouiAEOUI]*", "");
	}
}
