import java.util.TreeSet;

public class LargestSumSmallerThanKTreeSet {

	static int getLargestSumSmallerThanK(int[] a, int k){
		int rightCumSum =0;
		Integer leftCumSum =0;
		int maxSum = Integer.MIN_VALUE;
		int rightIndex = -1;
		int sumElements =0;
		int leftIndex = -1;
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(0);

		for(int i=0 ; i< a.length; i++) {
			rightCumSum = rightCumSum + a[i];

			leftCumSum = ts.ceiling(rightCumSum -k);
			if(leftCumSum !=null) {
				if(maxSum < rightCumSum - leftCumSum) {
					maxSum = rightCumSum - leftCumSum;
					rightIndex = i;
				}
			}
			ts.add(rightCumSum);
		}

		System.out.println("rightIndex = " + rightIndex);

		if(rightIndex == -1) {
			System.out.println("leftIndex = " + leftIndex);
			return maxSum;
		}

		leftIndex = rightIndex;
		while(sumElements < maxSum && leftIndex >=0 ) {
			sumElements += a[leftIndex];
			leftIndex--;
		}

		System.out.println("leftIndex = " + (leftIndex +1) );
		return maxSum;
	}


	public static void main(String[] args) {
		int[] a = new int[] {2,3,4,34,57,52,33,56,67};
		int k = 10;
		System.out.println(getLargestSumSmallerThanK(a,k));
	}
}

