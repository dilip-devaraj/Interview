public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		int i = 0;
		while(i < A.length){
			// Only if nums is between 1 and nums.length and not in right place we continue to call swap, until it is in right place
            if(A[i] >= 1 && A[i] <= A.length && A[A[i]-1] != A[i]) {
                swap(A, i, A[i]-1);
            }else{
                i++;
            }
		}
		i = 0;
		while(i < A.length && A[i] == i+1) i++;
		return i+1;
	}

	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
