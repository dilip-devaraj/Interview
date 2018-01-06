
public class BirthdayParadox {
	
	static int getNumberPeopleToHaveSameBirthday(double minOdds) {
		//Prob they dont have same birthdays
		double target = ((double) 1- minOdds);
		int noPeople = 1;
		double probBdayDontMatch =1;
		
		while(probBdayDontMatch > target) {
			probBdayDontMatch = probBdayDontMatch * ((double) 1 - (double) noPeople/365);
			noPeople++;
		}
		return noPeople;
	}
	
	 public static void main(String args[])
	 {
	     System.out.println( getNumberPeopleToHaveSameBirthday(0.50));
	 }
}
