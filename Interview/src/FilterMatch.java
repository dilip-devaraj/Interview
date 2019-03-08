import java.util.regex.Matcher;

import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;

public class FilterMatch {


	static boolean containsFilter(String str) {
		if(str == null || str.isEmpty()) {
			return false;
		}

		Pattern pattern = Pattern.compile("\\**");
		Matcher matcher = pattern.matcher(str);

		return !matcher.matches();
	}

	public static void main(String[] args) {
		System.out.println(containsFilter("*"));


		if(!StringUtils.isEmpty("abc")) {
			System.out.println("input is empty");
		}
	}
}
