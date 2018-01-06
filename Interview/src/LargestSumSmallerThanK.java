
public class LargestSumSmallerThanK {

	static int getLargestSumSmallerThanK(int[] a, int k){
		int sum =0,maxSum = Integer.MIN_VALUE;
		for(int i=0; i< a.length; i++){
			sum =0;
			for(int j=i; j<a.length; j++){
				sum = sum +a[j];
				if(sum <=k){
					if(sum > maxSum){
						maxSum = sum;
					}
				}
			}
		}
		return maxSum;
	}


	public static void main(String[] args) {
		int[] a = new int[] {2,3,4,7,2,3,6,7};
		int k = 10;
		System.out.println(getLargestSumSmallerThanK(a,k));
	}
}

