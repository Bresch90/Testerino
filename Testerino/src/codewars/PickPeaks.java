package codewars;

import java.util.*;

public class PickPeaks {
	public PickPeaks() {
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 4, 3, 2, 3, 6, 4, 1, 2, 3, 3, 4, 5, 3, 2, 1, 2, 3, 5, 5, 4, 3 };
		Map<String, List<Integer>> result = new HashMap<String, List<Integer>>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
				put("pos",   new ArrayList<Integer>() );
				put("peaks", new ArrayList<Integer>() );
		}};

		boolean match = false;
		for (int i = 1, posMax = 0; i < arr.length - 1; i++) {
			if (arr[i - 1] < arr[i]) {
				posMax = i;
				match = true;
			}
			if (arr[i - 1] > arr[i] && match) {
				match = false;
				result.get("pos").add(posMax);
				result.get("peaks").add(arr[posMax]);
			}
		}

		System.out.println(result);
		System.out.println("{pos=[2, 7, 14, 20], peaks=[5, 6, 5, 5]} :is answer");
	}

}
