
public class KthSmallestTwoSortedArrays {

	static int findKthSmallest(int A[], int startA, int sizeA, int B[], int startB,  int sizeB, int k) {			  
	  int i = (int)((double)sizeA / (sizeA+sizeB) * (k-1));
	  int j = (k-1) - i;

	  int Ai_1 = ((i <= 0) ? Integer.MIN_VALUE : A[i-1]);
	  int Bj_1 = ((j <= 0) ? Integer.MIN_VALUE : B[j-1]);
	  int Ai   = ((i >= sizeA) ? Integer.MAX_VALUE : A[i]);
	  int Bj   = ((j >= sizeB) ? Integer.MAX_VALUE : B[j]);
	 
	  if (Bj_1 < Ai && Ai < Bj)
	    return Ai;
	  else if (Ai_1 < Bj && Bj < Ai)
	    return Bj;
	 
	  // if none of the cases above, then it is either:
	  if (Ai < Bj)
	    // exclude Ai and below portion
	    // exclude Bj and above portion
	    return findKthSmallest(A, i+1, sizeA - (i+1), B, startB, j, k-i-1);
	  else /* Bj < Ai */
	    // exclude Ai and above portion
	    // exclude Bj and below portion
	    return findKthSmallest(A, startA, i, B, j+1, sizeB - (j+1), k-j-1);
	}
	
	
	public static void main(String[] args) {
		int[] a = {5,8,12,15,16};
		int[] b = {3,7,11,13,13,14};
		
		int kthSmallest = findKthSmallest(a, 0, a.length, b, 0,  b.length, 11);
		System.out.println(kthSmallest);;
		
	}
}


