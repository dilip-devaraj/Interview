import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {
	private final Map<String, Set<String>> abbrDict = new HashMap<>();

	public UniqueWordAbbreviation(String[] dictionary) {
		for (String s : dictionary) {
			String abbr = toAbbr(s);
			Set<String> dictWords = abbrDict.containsKey(abbr)
					? abbrDict.get(abbr) : new HashSet<>();
					dictWords.add(s);
					abbrDict.put(abbr, dictWords);
		}
	}

	public boolean isUnique(String word) {
		String abbr = toAbbr(word);
		Set<String> dictWords = abbrDict.get(abbr);
		return dictWords == null || (dictWords.size() == 1 && dictWords.contains(word));
	}

	private String toAbbr(String s) {
		int n = s.length();
		if (n <= 2) {
			return s;
		}
		return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
	}
}