package DynamicProgramming;

public class MinimumCoinsSum {

	public static void main(String[] args){
		int coins[] = new int[]{1,3,5};
		int sum = 1;

		// Initialize starting state
		int minCoinsTable[] = new int[sum+1];
		int sumPath[] = new int[sum+1];

		minCoinsTable[0] = 0;
		for(int i=1; i<= sum;i++){
			minCoinsTable[i] = Integer.MAX_VALUE;
		}

		for (int i=1; i<= sum; i++) {
			for (int j=0; j< coins.length; j++){
				if(coins[j] <= i && (minCoinsTable[i - coins[j]] +1 < minCoinsTable[i] )){
					minCoinsTable[i] = minCoinsTable[i - coins[j]] +1;
					sumPath[i] = i - coins[j]; 
				}
			}
		}

		System.out.println("Min coins = " + minCoinsTable[sum]);
		
		System.out.println("Coins  used =");
		
		int i = sum;
		while(i !=0) {
			System.out.print(i - sumPath[i]  +",");
			i = sumPath[i];
		}

	}
}
