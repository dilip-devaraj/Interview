
public class IntegerFloat {

	public static void main(String[] args) {
		System.out.println("Float.MAX_VALUE="+ Float.MAX_VALUE);
		System.out.println("Float.MIN_VALUE="+ Float.MIN_VALUE);
		System.out.println("largest negative Float"+ - Float.MAX_VALUE);
		
		System.out.println("Float.POSITIVE_INFINITY="+ Float.POSITIVE_INFINITY);
		System.out.println("Float.NEGATIVE_INFINITY="+ Float.NEGATIVE_INFINITY);
		
		System.out.println("Integer.MAX_VALUE="+ Integer.MAX_VALUE);
		System.out.println("Integer.MIN_VALUE="+ Integer.MIN_VALUE);
		
		System.out.println("Double.MAX_VALUE="+ Double.MAX_VALUE);
		System.out.println("Double.MIN_VALUE="+ Double.MIN_VALUE);
		System.out.println("Long.MAX_VALUE="+ Long.MAX_VALUE);
		System.out.println("Long.MIN_VALUE="+ Long.MIN_VALUE);
		
		long l1Max = 9223372036854775807L;
		long l1Min = -9223372036854775808L;
		float f1Max =  l1Max;
		float f1Min = l1Min;
		System.out.println("f1Max="+ f1Max + ", f1Min=" + f1Min);
		
		long l2Max =  (long) f1Max;
		long l2Min = (long) f1Min;
		System.out.println("l2Max="+ l2Max + ", l2Min=" + l2Min);
		
	}
}
