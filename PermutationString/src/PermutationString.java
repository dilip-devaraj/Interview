
public class PermutationString {

	static void printPermutation(String word)
	{
		if(word == null) return;
		printPermutation(word, "");
	}

	static void printPermutation(String word, String prefix)
	{
		if(word.length() == 0)
		{
			System.out.println(prefix);
		}
		else
		{
			for(int i=0; i< word.length(); i++)
			{
				printPermutation(word.substring(0,i) + word.substring(i+1), prefix + word.charAt(i));
			}
		}
	}

	public static void main(String[] args)
	{
		printPermutation("ABCDEFGHI");
	}
}
