
public class NestedProbability {

	static double getProbability (int n, int nestings, int target)
	{
		int i, j, k;
		double[] a = new double[1001];
		double[] b = new double[1001];

		// A[I] represents the probability of number I  to appear

		for (i = 0; i < n ; i++)  a[i] = (double) 1 / n;
		for (k = 2; k <= nestings; k++)
		{
			for (i = 0; i < n; i++)  b[i] = 0;
			// for each I between 0 and N-1 we call the function "random(I)"
			// as described in the problem statement
			for (i = 0; i < n; i++)
			{
				for (j = 0; j < i; j++) {
					b[j] +=  (double) a[i] / i;
				}
			}
			for (i = 0; i < n; i++)  a[i] = b[i];
		}
		return a[target];
	}

	public static void main(String[] args) {
		System.out.println(getProbability(4, 3, 1));
	}
}
