import java.util.ArrayList;
import java.util.List;

public class MaxLinesOnScreen {

	private static List<Integer> getMinUnoccupiedScreenLines(int screenSize, int[] sectionsLength){

		int[] minUnoccupiedScreenLines = new int[screenSize +1];
		minUnoccupiedScreenLines[0] =0;

		for(int i=1; i<minUnoccupiedScreenLines.length; i++){
			minUnoccupiedScreenLines[i] = i;
		}

		List<List<Integer>> allUsedSections = new ArrayList<List<Integer>>();
		allUsedSections.add(new ArrayList<Integer>(0));

		for(int i=1; i<= screenSize; i++)
		{
			List<Integer> usedSections = new ArrayList<Integer>();
			allUsedSections.add(usedSections);
			for(int j=0; j<sectionsLength.length;j++)
			{
				if(sectionsLength[j] <= i && ((i - sectionsLength[j]) - minUnoccupiedScreenLines[i - sectionsLength[j]] <= minUnoccupiedScreenLines[i]))
				{					
					if(! allUsedSections.get(i - sectionsLength[j]).contains(sectionsLength[j]))
					{
						usedSections.clear();
						usedSections.addAll(allUsedSections.get(i - sectionsLength[j]));
						usedSections.add(sectionsLength[j]);

						minUnoccupiedScreenLines[i] = i - getUsedSectionsLength(usedSections);
					}
					else {
						usedSections.addAll(allUsedSections.get(i - sectionsLength[j]));
						minUnoccupiedScreenLines[i] = i - getUsedSectionsLength(usedSections);
					}						
				}
			}


		}
		return allUsedSections.get(screenSize);
	}


	private static int getUsedSectionsLength(List<Integer> usedSections)
	{
		int sumLinesSoFar =0 ;
		for(int sectionLength: usedSections)
			sumLinesSoFar+=sectionLength;
		return sumLinesSoFar;
	}

	public static void main(String[] args){
		int[] sectionsLength = {1,3,5,6};
		System.out.println(getMinUnoccupiedScreenLines(100, sectionsLength));
	}
}
