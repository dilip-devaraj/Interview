import java.util.Arrays;

public class KthMultiplicationTable {

	public int findKthNumber(int m, int n, int k) {
		int count = 0;
		int[] table = new int[m*n];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				table[count] = i * j;
				count++;
			}
		}
		Arrays.sort(table);
		return table[k-1];
	}

	public static void main(String[] args) {
		KthMultiplicationTable kthMult = new KthMultiplicationTable();
		System.out.println(kthMult.findKthNumber(5, 5, 16));
	}
}
