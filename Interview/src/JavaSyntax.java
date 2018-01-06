import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JavaSyntax {
	static int staticVar;
	
	public static void main(String args[])
	{
		int var1 = 1;
		System.out.println(var1 = 5);
		System.out.println(staticVar);
		
		int[] a = new int[5];
		Arrays.fill(a, 6);
		System.out.println(Arrays.toString(a));
		
		List<Integer> intList = new ArrayList<>();
		// Integer[] b = (Integer[])intList.toArray();
		
		//intList = Arrays.asList(b);
		
		System.out.println(Math.sqrt(10));
		
		
		
	} 
}
