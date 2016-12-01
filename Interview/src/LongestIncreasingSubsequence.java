import java.util.Stack;

public class LongestIncreasingSubsequence {

	public static int longestIncSubSeq(int[] numbers){
        Stack<Integer> numStack = new Stack<Integer>();
		int[] dp = new int[numbers.length];
		int[] parent = new int[numbers.length];
		int longestLengthEndingIndex = 0;
		int longestLength = 0;
		
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
			if(dp[i] > longestLength) {
				longestLength= dp[i];
				longestLengthEndingIndex = i;
			}
		}

		int i=longestLengthEndingIndex;
		while (parent[i] != i){
			numStack.push(numbers[i]);
			i = parent[i];			
		}
		numStack.push(numbers[i]);
	
		while(! numStack.isEmpty()){
			System.out.print(numStack.pop() + " ");
		}
		
		System.out.println();
		return dp[longestLengthEndingIndex];
	}

	public static void main(String[] args){
		int[] numbers= {1,6,5,2,-3, -2, -1,3,4,5};
		// int[] numbers= {5,3,4,8,6,7};
		System.out.println(longestIncSubSeq(numbers));
	}
}
