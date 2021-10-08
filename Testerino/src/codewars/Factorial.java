package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println("120 :is answer");
		System.out.println(factorial(15));
		System.out.println("1307674368000 :is answer");
		System.out.println(factorial(25));
		System.out.println("15511210043330985984000000 :is answer");
	}
	
	public static String factorial(int n) {
		if (n < 0) return null;
		StringBuilder sb = new StringBuilder();
		// just approximating nrDigits to avoid having list of 10k
		int nrDigits = (int)(n*Math.log10(n)-0.434*n+Math.log10(2*Math.PI*n));
		int[] list = new int[nrDigits+5];
		list[0] = 1;
		for(int index = 1; index <= n; ++index ){
			for(int i = 0; i < list.length ; i++){
				list[i] = list[i]*index;
			}
			System.out.println(index +": " +Arrays.toString(list));
			for(int i = 0; i < nrDigits; i++){
				list[i+4] = list[i+4]+ list[i]/10000;
				list[i+3] = list[i+3]+ list[i]%10000/1000;
				list[i+2] = list[i+2]+ list[i]%1000/100;
				list[i+1] = list[i+1]+ list[i]%100/10;
				list[i+0] = list[i]%10;
			}
		}
		while(list[nrDigits] == 0) nrDigits--;
		for( ; nrDigits >= 0; nrDigits--){
			sb.append(list[nrDigits]);
		}
		return sb.toString();
	}
	
	static ArrayList<Integer> check(ArrayList<Integer> list){
		ArrayList<Integer> temp = new ArrayList<>();
		for (int y = list.size()-1, i = 0 ; y >= 0; y--, i++) {
			temp.add(i, list.get(y));
		}
		//inte färdig
		return list;
	}
	
	static long fact(long n) {
		if(n<=0) {
			return 1;
		}
		return Factorial.fact(n-1)*n;
	}

}
