package codewars;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Equation {

	public static void main(String[] args) {

//		System.out.println(differentiate("", 3));
//		System.out.println("12 :is answer");
		System.out.println(differentiate2("x^2-x", 3));
		System.out.println("5 :is answer");
		System.out.println(differentiate2("-5x^2+10x+4", 3));
		System.out.println("-20 :is answer");
		System.out.println(differentiate("7x^6+51x^5+78x^4+78x^3-26x^2", 6457));
		System.out.println("471858159102499195367 :is answer");
		System.out.println(differentiate2("7x^6+51x^5+78x^4+78x^3-26x^2", 6457));
	}
	
	public static BigInteger differentiate(String equation, long x) {
		BigInteger result = new BigInteger("0");
		Matcher matcher = Pattern.compile("([-+]?(?:\\d*x|\\d+)(?:\\^\\d+)?)").matcher(equation);
		String[] parts = new String[10];
		
		for (int i = 0; matcher.find(); i++) {
			parts[i] = matcher.group(0);
		}
		
		if (parts[0] == null) return result;
		
		for (String part : parts)  {
			if (part != null) {
				matcher = Pattern.compile("(?<sign>[-+]?)(?:(?<times1>\\d*)(?<x>x)|(?<times2>\\d+))(?:(?<power>\\^)(?<exponent>\\d))?").matcher(part);
				matcher.find();
				
				BigInteger partFactorFromExponent = new BigInteger((matcher.group("power") == null ? "1" : matcher.group("exponent")));
				BigInteger partFactorFrontOfX = new BigInteger((matcher.group("times1") == null || matcher.group("times1").equals("")  ? 
							(matcher.group("times2") == null || matcher.group("times2").equals("") ? "1" : (matcher.group("x") == null ? 
								"0" : matcher.group("times2"))) : matcher.group("times1")));
				BigInteger partFactorX = new BigInteger((matcher.group("x") == null ? "1" : (matcher.group("power") == null ? "1" : String.valueOf(x))));
				int partExponent = matcher.group("power") == null ? 1 : Integer.valueOf(matcher.group("exponent"))-1;
				
				BigInteger partValue = partFactorFromExponent.multiply(
							partFactorFrontOfX.multiply(partFactorX.pow(partExponent)));
				
				if (matcher.group("sign").equals("") || matcher.group("sign").equals("+")) {
					result = result.add(partValue);
				} else if (matcher.group("sign").equals("-")) {
					result = result.subtract(partValue);
				}
			}
		}
        return result;
    }
	
	
	public static BigInteger differentiate2(String equation, long x) {
		BigInteger sum = BigInteger.ZERO;
		int indexOfX, indexOfPow;
		for (String part : equation.replaceAll("-", "+-").split("\\+")) {
			if ((indexOfX = part.indexOf('x')) == -1) continue;
			
			BigInteger x1 = BigInteger.ONE;
			BigInteger cofficient = new BigInteger((part.startsWith("-") && indexOfX == 1 ? "-1" : (indexOfX == 0 ? "1" : part.substring(0, indexOfX))));
			
			if ((indexOfPow = part.indexOf('^')) != -1) {
				cofficient = cofficient.multiply(new BigInteger(part.substring(indexOfPow + 1, part.length())));
				x1 = BigInteger.valueOf(x).pow(Integer.parseInt(part.substring(indexOfPow + 1, part.length()))-1);
			}
			
			sum = sum.add(cofficient.multiply(x1));
		}
		return sum;
	}
}
