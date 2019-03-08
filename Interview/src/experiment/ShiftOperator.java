package experiment;

import java.util.HashMap;
import java.util.Map;

public class ShiftOperator {

	public static void main(String[] args) {
		int num1 = 4;
		int num2 = -4;
		
		System.out.println(num1>>1);
		System.out.println(num2>>1);
		System.out.println(num1>>>1);
		System.out.println(num2>>>1);
		System.out.println(num1<<1);
		System.out.println(num2<<1);
	}
}
