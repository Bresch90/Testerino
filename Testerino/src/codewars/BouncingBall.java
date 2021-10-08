package codewars;

public class BouncingBall {

	public BouncingBall() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		double h = 30.0;
		double bounce = 0.66;
		double window = 1.5;
		int timesBounced = 1;
		if (h > window && window > 0 && 0 < bounce && bounce < 1) {
			while (h > window) {
				h *= bounce;
				timesBounced += 2;
			}
			timesBounced -= 2;
		}else {
			timesBounced =-1;
		}
		
		
		
		System.out.println(timesBounced);
	    System.out.println("15 :is answer");
	    System.out.println();
	}
	public static int getBounces(double h, double bounce, double window) {
		if (h < window || window < 0 || 0 > bounce || bounce > 1) return -1;
		int timesBounced = 1;
		while(h > window) {h *= bounce; timesBounced += 2;}
		return timesBounced-2;
	}

}
