import java.util.Arrays;

public class WildcardStarQuestionMatch2 {
    // Function that matches input str with
    // given wildcard pattern
	
    public boolean isMatch(String s, String p) {
		if(s == null || p == null){
			return false;
		}
        
        StringBuilder sb = new StringBuilder();
        
        boolean firstStar = true;
        for(int i=0; i< p.length(); i++){
            if(p.charAt(i) == '*' && firstStar == true){
                firstStar = false;
                sb.append('*');
            } else if(p.charAt(i) == '*' && firstStar == false){
                continue;
            } else {
                firstStar = true;
                sb.append(p.charAt(i));
            }
        }
        
		return isMatch(s, sb.toString(), s.length(), sb.toString().length());
	}
    
    static boolean isMatch(String str, String pattern,
                                 int n, int m)
    {
        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);
      
        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];
      
        // initailze lookup table to false
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);
         
      
        // empty pattern can match with empty string
        lookup[0][0] = true;
      
        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];
      
        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                                   lookup[i - 1][j];
      
                // Current characters are considered as
                // matching in two cases
                // (a) current character of pattern is '?'
                // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                    str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];
      
                // If characters don't match
                else lookup[i][j] = false;
            }
        }
      
        return lookup[n][m];
    }

	public static void main(String[] args) {
		WildcardStarQuestionMatch2 wildcard = new WildcardStarQuestionMatch2();
		System.out.println(wildcard.isMatch("aa", "*"));
		
		System.out.println(wildcard.isMatch("geeks", "g*ks"));
		
		System.out.println(wildcard.isMatch("geeksforgeeks", "ge?ks*"));
		
		System.out.println(wildcard.isMatch("gee", "g*k"));
		
		System.out.println(wildcard.isMatch("abcdhghgbcd", "abc*bcd"));
		
		System.out.println(wildcard.isMatch("abcd", "*c*d"));
		
		System.out.println(wildcard.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
				,"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));		
	}
}
