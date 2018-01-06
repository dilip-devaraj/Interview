
public class OuterClass {
	int a = 1;
	static int b = 2;
	
	class InnerClass{
		int c = 3 + a;
		int d = 4 * b;
	}
	
	static class StaticInnerClass{
		int e = 5;
		int f = 6 *b;
	}
	
	void printInnerClassMembers() {
		InnerClass ic = new InnerClass();
		System.out.println("c=" + ic.c + " d=" + ic.d);
	}

	void printStaticClassMembers() {
		StaticInnerClass sic = new StaticInnerClass();
		System.out.println("e=" + sic.e + " f=" + sic.f);
	}
	
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.printInnerClassMembers();
		oc.printStaticClassMembers();
		
		OuterClass.InnerClass ic = new  OuterClass().new InnerClass();
		OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
	}
	
}
