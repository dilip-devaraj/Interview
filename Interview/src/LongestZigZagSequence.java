
import java.util.Stack;

public class LongestZigZagSequence {

	public static int longestZigZagSeq(int[] numbers){
        Stack<Integer> numStack = new Stack<Integer>();
		int[][] dp = new int[numbers.length][2];
		int[] parent = new int[numbers.length];
		int longestLengthEndingIndex = 0;
		int longestLength = 1;
		int biggerLength;
		
		// Each number starts with longest sub seq length corresponding to itself.
		// dp[i][0] is increasing , and dp[i][1] is decreasing
		for(int i=0; i< numbers.length; i++){
			dp[i][0] = dp[i][1] = 1;
			parent[i] = i;
		}

		
		for(int i=1; i< numbers.length; i++){
			for(int j=0; j<i; j++) {
				if(numbers[i] >= numbers[j] && dp[i][0] < dp[j][1] +1) {
					dp[i] [0]= dp[j][1]+1;
					parent[i] = j;
				}
				if(numbers[i] < numbers[j] && dp[i][1] < dp[j][0] +1) {
					dp[i] [1]= dp[j][0]+1;
					parent[i] = j;
				}
			}
			biggerLength =  Math.max(dp[i][0], dp[i][1]);

			if(biggerLength > longestLength) {
				longestLength= biggerLength;
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
		return longestLength;
	}

	public static void main(String[] args){
		int[] numbers= { 10, 22, 9, 33, 49, 50, 31, 60 };
		// int[] numbers= {1,6,5,2,-3, -2, -1,3,4,5};
		// int[] numbers= {5,3,4,8,6,7};
		System.out.println(longestZigZagSeq(numbers));
	}
}
