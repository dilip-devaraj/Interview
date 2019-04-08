import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<>();
		remove(s, ans, 0, 0, new char[]{'(', ')'});
		return ans;
	}

	public void remove(String s, List<String> ans, int startIndex, int lastRemovedIndex,  char[] par) {
		int stack = 0;
		for (int i = startIndex; i < s.length(); ++i) {
			if (s.charAt(i) == par[0]) stack++;
			if (s.charAt(i) == par[1]) stack--;
			if (stack >= 0) continue;
			for (int j = lastRemovedIndex; j <= i; ++j)
				if (s.charAt(j) == par[1] && (j == lastRemovedIndex || s.charAt(j - 1) != par[1]))
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (par[0] == '(') // finished left to right
			remove(reversed, ans, 0, 0, new char[]{')', '('});
		else // finished right to left
			ans.add(reversed);
	}
}
