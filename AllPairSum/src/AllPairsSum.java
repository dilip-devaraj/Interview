import java.util.Arrays;

public class AllPairsSum {

	public static void findAllPairsSum(int[] array, int sum) {
		Arrays.sort(array);
		int first =0;
		int last = array.length -1;
		while(first <last){
			if(array[first] + array[last] == sum) {
				System.out.println(array[first] + " "  + array[last]);
				first++;
				last--;
			}
			else if(array[first] + array[last] < sum)
				first ++;
			else
				last--;
		}			
	}
	
	public static void main(String[] args){
		int a[] = new int[]{1,3,5,7,9,11,-5,6,7,3,2};
		findAllPairsSum(a,10);
	}
}
