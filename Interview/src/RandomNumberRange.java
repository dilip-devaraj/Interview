import java.util.Random;

public class RandomNumberRange {

	private static int getRandomHourBetweenRange(int minHour, int maxHour){
		return (int) (Math.random() * (maxHour - minHour +1) + minHour); 
	}

	public static void main(String[] args){
		long t0 = System.currentTimeMillis();
		Random r = new Random();
		for(int i=0; i<1000000; i++) {
			// System.out.println(getRandomHourBetweenRange(6,15));
//			getRandomHourBetweenRange(6,15);
			// String.valueOf(Math.random());
			StringBuilder sb = new StringBuilder();
			sb.append(r.nextInt());
			sb.toString();
			// System.out.println(sb.toString());
		}
		System.out.println(System.currentTimeMillis() -t0);
		

		
	}

}
