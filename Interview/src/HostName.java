import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HostName {
	public static void main(String[] args) throws UnknownHostException {

		System.out.println(Math.abs(InetAddress.getLocalHost().getHostName().hashCode() % 24));

		Set<String> blacklistSet = new HashSet<>();
		List<String> listWords = new ArrayList<>();
		int numBlackListedWords = 1000;

		for(int i=0; i< numBlackListedWords; i++) {
			listWords.add(Integer.toString(i));
			blacklistSet.add(Integer.toString(i));
		}

		Random randomNumber = new Random();
		long totalTime1 =0, totalTime2 =0;
		int match1 =0, match2 = 0;
		for(int j=0; j < 10000000; j++) {
			String word = Integer.toString(randomNumber.nextInt(10000000));

			// check in set
			long timeStart1 = System.currentTimeMillis();
			if(blacklistSet.contains(word)) {
				match1++;
			}
			totalTime1 = System.currentTimeMillis() - timeStart1;

			// check in list
			long timeStart2 = System.currentTimeMillis();
			for(String blackWord : listWords) {
				if(blackWord.equals(word)) {
					match2++;
					break;
				}
			}
			totalTime2 = System.currentTimeMillis() - timeStart2;
		}
		
		System.out.println("Set total time in ms=" +  totalTime1 + " matches =" + match1);
		System.out.println("List total time in ms=" +  totalTime2 + " matches =" + match2);
	}
}
