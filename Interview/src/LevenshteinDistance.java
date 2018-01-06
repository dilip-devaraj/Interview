import java.util.Stack;

public class LevenshteinDistance {

	int getDistance(String s1, String s2, int i1, int i2, int cost) {
		if(s1== null || s1.isEmpty()) {
			return (s2!=null ? s2.length():0);
		}
		if(s1.length() > s2.length()) {
			return getDistanceCalc(s2, s1, i1, i2, cost);
		} else {
			return getDistanceCalc(s1, s2, i1, i2, cost);
		}
	}

	int getDistanceCalc(String s1, String s2, int i1, int i2, int cost) {
		if(s2.length() == i1 && s2.length() == i2) {
			return cost;
		}

		if(i1<s1.length() && s1.charAt(i1) == s2.charAt(i2)) {
			return getDistanceCalc(s1, s2, i1+1, i2+1, cost);
		} else {

			//insert
			int c1 = getDistanceCalc(s1.substring(0,i1) + s2.charAt(i2) + s1.substring(i1), s2, i1+1, i2+1, cost+1);
			int distCost = c1;
			
			//delete
			if(i1 < s1.length()) {
				int c2 = getDistanceCalc(s1.substring(0,i1) + s1.substring(i1+1), s2, i1, i2, cost+1);
				distCost = Math.min(distCost, c2);
			}

			//edit
			if(i1 < s1.length()) {
				int c3 = getDistanceCalc(s1.substring(0,i1) + s2.charAt(i2) + s1.substring(i1+1), s2, i1+1, i2+1, cost+1);
				distCost = Math.min(distCost, c3);
			}
			
			return distCost;
		}
	}

	public static void main(String[] args) {
		LevenshteinDistance ld = new LevenshteinDistance();

		System.out.println(ld.getDistance("ab", "abc", 0, 0, 0));
		
		System.out.println(ld.getDistance("abc", "ab", 0, 0, 0));
		
		System.out.println(ld.getDistance("ab", "adbc", 0, 0, 0));
		
		System.out.println(ld.getDistance("abc", "abe", 0, 0, 0));
		
		System.out.println(ld.getDistance("aab", "abc", 0, 0, 0));
		
		System.out.println(ld.getDistance("kitten", "sitting", 0, 0, 0));
		
		System.out.println(ld.getDistance("intention", "execution", 0, 0, 0));
	}
}
