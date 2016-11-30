
public class LongestIncreasingSubsequence {

	public static int longestIncSubSeq(int[] numbers){

		int[] dp = new int[numbers.length];
		int[] parent = new int[numbers.length];

		// Each number starts with longest sub seq length corresponding to itself.
		for(int i=0; i< numbers.length; i++){
			dp[i] = 1;
			parent[i] = i;
		}

		for(int i=1; i< numbers.length; i++){
			for(int j=0; j<i; j++) {
				if(numbers[i] >= numbers[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
					parent[i] = j;
				}
			}
		}

		int i=numbers.length -1;
		do{
			System.out.print(numbers[i] + " ");
			i = parent[i];			
		}while (parent[i] != i);
		System.out.println(numbers[i]);
		
		return dp[numbers.length -1];
	}

	public static void main(String[] args){
		int[] numbers= {1,6,5,2,-3, -2, -1,3,4,5};
		// int[] numbers= {5,3,4,8,6,7};
		System.out.println(longestIncSubSeq(numbers));
	}
}
