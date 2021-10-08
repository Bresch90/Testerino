package codewars;

import java.util.Arrays;

public class NbMonths {

	public NbMonths() {
	}

	public static void main(String[] args) {	
		System.out.println(Arrays.toString(buyTheCar(2000, 8000, 1000, 1.5)));
		System.out.println("[6, 766] :is answer");
		System.out.println(Arrays.toString(buyTheCar(12000, 8000, 1000, 1.5)));
		System.out.println("[0, 4000] :is answer");
		System.out.println(Arrays.toString(buyTheCar(8000,12000,500,1.0)));
		System.out.println("[8, 597] :is answer");
		System.out.println(Arrays.toString(buyTheCar(12311,22311,1000,1.5)));
		System.out.println("[9, 1121] :is answer");
		
	}
	
	
	public static int[] buyTheCar(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
		int savings = 0, months = 0;
		double oldCarValue = startPriceOld, newCarValue = startPriceNew, percentLossFactor = 1-(percentLossByMonth/100);
		if (oldCarValue - newCarValue >= 0) return new int[] {0, startPriceOld - startPriceNew};
		do {
			savings += savingperMonth;
			oldCarValue *= percentLossFactor;
			newCarValue *= percentLossFactor;
			percentLossFactor -= (months % 2 == 0 ? 0.005 : 0);
			months++;
		} while (oldCarValue + savings - newCarValue <= 0);
		return new int[] {months, (int) Math.round(oldCarValue + savings - newCarValue)};
	}
	
}
