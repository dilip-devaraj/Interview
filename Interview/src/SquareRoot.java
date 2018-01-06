
public class SquareRoot {

	static double squareRoot(double num){
		double l=0.0;
		double h=num;
		double delta = 0.000001;
		double mid =0.0;

		while(l<=h){
			mid = (l+h)/2;

			if(Math.abs(mid * mid - num) <= delta){
				return mid;
			} else if (mid * mid < num){
				l = mid;
			} else{
				h = mid;
			}
		} 
		return mid;
	}
	
	
	public static void main(String[] args) {
		System.out.println(squareRoot(4));
	}
}
