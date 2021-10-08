package codewars;

public class PrimeDecomp {

	public PrimeDecomp() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		int n = 11580833;
		StringBuilder sb = new StringBuilder();
		for (int divider = 2 ; divider <= n ; divider++) {
			int count = 0;
			while (n % divider == 0) {
				n = Math.floorDiv(n, divider);
				count++;
			}
			
			if (count > 0) {
				sb.append("(" + divider + (count > 1 ? "**" + count : "") + ")");
			}
		}
		

		System.out.println(sb.toString());
		System.out.println("(11)(1052803)");
	}

}
