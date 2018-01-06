import java.util.Arrays;
import java.util.Comparator;

public class largestNumCombination {
	
	String largestNum (int[] nums) {
		String[] numsString = new String[nums.length];
		for(int i =0; i< nums.length; i++) {
			numsString[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(numsString, new Comparator<String>() {
			@Override
			public int compare (String a, String b) {
				return Integer.valueOf((b+a)) - Integer.valueOf((a +b)); 
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i< numsString.length; i++) {
			sb.append(numsString[i]);
		}	
		return sb.toString();
	}

	public static void main(String[] args) {
		largestNumCombination lnc = new largestNumCombination();
		int[] nums = new int[] {1, 34, 3, 98, 9, 76, 45, 4};
		System.out.println(lnc.largestNum(nums));
	}
}
