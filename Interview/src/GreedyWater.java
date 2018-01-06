/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

class GreedyWater {
	public static void main(String args[] ) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int t = Integer.parseInt(line);


		for(int i=0; i<t; i++){
			line = br.readLine();
			String[] params = line.split(" ");
			int n = Integer.parseInt(params[0]);
			int x = Integer.parseInt(params[1]);

			int[] bottleCap = new int[n];

			/*
        Scanner s = new Scanner(System.in);
        for (int j = 0; j < n; j++) {
             bottleCap[j] = s.nextInt();
        }
        s.close();
			 */

			line =br.readLine();
			String values[]= line.split(" ");

			for (int j = 0; j < n; j++) {
				bottleCap[j] = Integer.parseInt(values[j]);
			}

			Arrays.sort(bottleCap);
			int noBottles = 0;
			int usedCap =0;
			int k =0;
			usedCap = usedCap + bottleCap[k];

			while(usedCap <= x){
				noBottles++;
				k++;
				usedCap = usedCap + bottleCap[k];
			}

			System.out.println(noBottles);
		}
	}
}
