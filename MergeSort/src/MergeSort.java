public class MergeSort{

	private int[] b;

	public int[] mergeSort(int[] input){
		if(input == null || input.length ==0 ) {
			return input;
		}

		b = new int[input.length];
		splitData(input, 0, input.length-1);
		return b;
	}	

	private void splitData(int[] input, int low, int high) {
		if (low < high) {
			int mid = (low + high) /2;
			splitData(input, low, mid);
			splitData(input, mid+1, high);
			merge(input, low, mid, high);
		}
	}

	private void merge(int[] input, int low, int mid, int high){
		for (int i = low; i <= high; i++) {
			b[i] = input[i];
		}

		int i= low;
		int j = mid+1;
		int k= low;

		while (i <= mid && j<= high) {
			if (input[i] > input[j]) {
				b[k] = input[j];
				j++;
			}
			else {
				b[k] = input[i];
				i++;
			}
			k++;
		}

		while(i <= mid) {
			b[k] = input[i];
			i++;
			k++;
		}

	}


	public static void main(String[] args) {
		int a[] = new int[] {8,4,3,2,5,6};
		MergeSort ms= new MergeSort();
		int[] sortedOutput = ms.mergeSort(a);

		for(int i=0; i< sortedOutput.length; i++) {
			System.out.print(sortedOutput[i] + " ");
		}
	}
}