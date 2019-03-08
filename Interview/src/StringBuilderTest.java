

import java.util.HashMap;
import java.util.Map;

public class StringBuilderTest {

	public static void main(String[] args) {
		String word = "abc";
		StringBuilder sb= new StringBuilder();
		sb.append(word);
		String reversedWord = sb.reverse().toString();
		System.out.println(reversedWord);
		
		boolean b =true;
		
		String textTabs = "\t\t\tfile2";
		System.out.println(textTabs.length());
		System.out.println(textTabs.lastIndexOf("\n"));
		
		Map<Integer, Integer> testMap = new HashMap<>();
		testMap.getOrDefault(1, 0);
		
		
		byte[] byteArray = new byte[10];
		char[] charArray = new char[10];
	}
}
