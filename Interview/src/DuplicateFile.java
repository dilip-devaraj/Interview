import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFile {
	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> result = new ArrayList<>();

		HashMap<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] files = path.split(" ");
			for (int i = 1; i < files.length; i++) {
				int p = files[i].indexOf('(');
				String key = files[i].substring(p);
				if (!map.containsKey(key)) map.put(key, new ArrayList<>());
				map.get(key).add(files[0] + "/" + files[i].substring(0, p));
			}
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) result.add(entry.getValue());
		}
		return result;
	}

	public static void main(String[] args) {
		DuplicateFile df = new DuplicateFile();
		String[] input = new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/d 6.txt(d)", "root/c/d 4.txt(efgh) 5.txt(dd)", "root 4.txt(efgh)"};
		List<List<String>> output = df.findDuplicate(input);

		for(List<String> fileNames : output) {
			for(String fileName : fileNames) {
				System.out.print(fileName + "  ");
			}
			System.out.println();
		}
	}
}