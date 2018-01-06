import java.util.Arrays;

public class WildcardStarQuestionMatch {
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
        
        Boolean[][] table = new Boolean[s.length()][sb.toString().length()];
        
        for(int i = 0;  i < s.length(); i++)
        		for(int j = 0; j< sb.toString().length(); j++) 
        			table[i][j] = null;
        
		return isMatch(s, sb.toString(), 0, 0, table);
	}

	boolean isMatch(String word, String pattern, int l1, int l2, Boolean[][] table){

		if(l1 == word.length() && l2 == pattern.length()){
			return true;
		}
		
		if (l2 == pattern.length() && l1 != word.length()){
			return false;
		}
		
		if((l1 == word.length() && pattern.charAt(l2) == '*' && ((l2+1) < pattern.length()))){
			return false;
		} else if((l1 == word.length() && pattern.charAt(l2) == '*' && ((l2+1) == pattern.length()))){
			return true;
		} else if(l1 == word.length() && l2 != pattern.length()){
            return false;
        }

		if(table[l1][l2] != null) {
			return table[l1][l2];
		}
		
		if(word.charAt(l1) == pattern.charAt(l2)){
			table[l1][l2] = isMatch(word, pattern, l1+1, l2+1, table);
		} else if(pattern.charAt(l2) == '?'){
			table[l1][l2] = isMatch(word, pattern, l1+1, l2+1,table);
		} else if(pattern.charAt(l2) == '*'){
			table[l1][l2] = isMatch(word, pattern, l1, l2+1,table) || isMatch(word, pattern, l1+1, l2,table);
		} else {
			table[l1][l2] = false;
		}
		return table[l1][l2];
	}

	public static void main(String[] args) {
		WildcardStarQuestionMatch wildcard = new WildcardStarQuestionMatch();
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
