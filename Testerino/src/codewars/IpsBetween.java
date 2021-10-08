package codewars;
import java.util.stream.Stream;


public class IpsBetween {

	public IpsBetween() {
	}

	public static void main(String[] args) {
		String start = "20.0.0.10";
		String end = "20.0.1.0";

		
		System.out.println(toLong(end)-toLong(start));
		System.out.println(convertToLong(end)-convertToLong(start));
	}
	
	public static long toLong(String ipString) {
		int[] i = {3};
		return Stream.of(ipString.split("\\.")).mapToLong(l -> Long.valueOf(l)*(long)Math.pow(256, i[0]--)).sum();
	}
	
	private static long convertToLong(String ip) {
	    long res = 0;
	    for (String s : ip.split("[.]") )
	      res = res * 256 + Long.parseLong(s);
	    return res;
	  }

}
