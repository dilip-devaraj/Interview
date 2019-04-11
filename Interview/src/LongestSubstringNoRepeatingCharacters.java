import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(i, map.get(s.charAt(j)) + 1);
			}
			map.put(s.charAt(j), j);
			ans = Math.max(ans, j - i + 1);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		LongestSubstringNoRepeatingCharacters longestSubstringNoRepeatingCharacters = new LongestSubstringNoRepeatingCharacters();
		System.out.println(longestSubstringNoRepeatingCharacters.lengthOfLongestSubstring("abba"));
		
	}
}