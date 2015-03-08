import java.util.Arrays;
import java.util.Comparator;

public class ArraySortLength {

	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "Tom";
		array[1] = "Dick";
		array[2] = "Harry";
		
		Arrays.sort(array, new Comparator<String>() {

		public int compare(String s1, String s2) {
			if(s1.length() < s2.length())
				return -1;
			else if (s1.length() == s2.length())
				return 0;
			else 
				return 1;
		}
	});
		
		print(array);
	}
	
	public static void print(String[] array)
	{
		for(String s: array){
			System.out.println(s);
		}
	}
}
