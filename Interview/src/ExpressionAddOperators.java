import java.util.ArrayList;
import java.util.List;

// Put all possible binary operator in between two digits and evaluating them and then check they evaluate to target or not.
//a little trick is that we should save the value that is to be multiplied in the next recursion.
//for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right? 
//If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, 
//so you want to take it out from the existing eval. 
//You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4). 

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if(num == null || num.length() == 0) return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}
	// pos - position till which input number is processed (0 .... num.length())
	public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long last){
		
		System.out.println("path= " + path + " last=" + last + " eval =" + eval + ", pos=" + pos);
		
		if(pos == num.length()){
			if(target == eval)
				rst.add(path);
			return;
		}
		for(int i = pos; i < num.length(); i++){
			// '0' cannot be leading number, so stop further dfs
			if(i != pos && num.charAt(pos) == '0') break;
			
			// current list of digits we are processing
			long cur = Long.parseLong(num.substring(pos, i + 1));
			System.out.println("cur =" + cur);
			
			if(pos == 0){
				helper(rst, path + cur, num, target, i + 1, cur, cur);
			}
			else{
				helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

				helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);

				helper(rst, path + "*" + cur, num, target, i + 1, eval - last + last * cur, last * cur );
			}
		}
	}
	
	public static void main(String[] args) {
		ExpressionAddOperators ea = new ExpressionAddOperators();
		List<String> result = ea.addOperators("232", 8);
		// List<String> result = ea.addOperators("1234", 10);
		// List<String> result = ea.addOperators("3456237490", 9191);
		System.out.println(result.toString());
	}
}
