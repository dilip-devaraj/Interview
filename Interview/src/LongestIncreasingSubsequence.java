
public class LongestIncreasingSubsequence {

	public static int longestIncSubSeq(int[] numbers){

		int[] dp = new int[numbers.length];
		int[] parent = new int[numbers.length];
		dp[0] = 1;


		for(int i=0; i< numbers.length -1 ; i++){
			if(numbers[i+1] > numbers[i]) {
				dp[i+1] = dp[i]+1;
				parent[i+1] = i;
			} else {
				dp[i+1] = dp[i];
				parent[i+1] = -1;
			}
		}
		
/*		for(int i= numbers.length-1; i>=0; i--){
			if(parent[i] != -1){
				System.out.print(numbers[i] + " ");
			}
		}*/
		return dp[numbers.length -1];
	}

	public static void main(String[] args){
		int[] numbers= {1,6,5,2,-3, -2, -1,3,4,5};

		System.out.println(longestIncSubSeq(numbers));
	}
}
