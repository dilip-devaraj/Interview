
public class Combination {

	void combine(String input, StringBuilder sb, int index)
	{
	    for (int i = index; i < input.length(); i++)
	    {
	        sb.append(input.charAt(i));
	        System.out.println(sb);
	        combine(input, sb, i + 1);
	        System.out.println("-> Delete char:" + sb.deleteCharAt(sb.length() - 1));
	      //  sb.deleteCharAt(sb.length() - 1);
	    }
	}
	
	public static void main(String[] args) {
		Combination com = new Combination();
		com.combine("abc", new StringBuilder(), 0);
		System.out.println("End of program");
	}
}
