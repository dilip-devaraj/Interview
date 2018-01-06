
public class LargestNumFromDigits {

	static int getLargestNum(int input){
		int largestNum=0;
		int[] digitsCount = new int[10];
		while(input != 0){
			int digit = input%10;
			digitsCount[digit]++;
			input = input/10;
		}

		for(int i=9; i>=0; i--){
			for(int j=0; j<digitsCount[i]; j++){
				largestNum = largestNum*10+i;
			}
		}

		return largestNum;
	}
	
	public static void main(String[] args) {
		int input = 1203465;
		System.out.println(getLargestNum(input));
	}
}
