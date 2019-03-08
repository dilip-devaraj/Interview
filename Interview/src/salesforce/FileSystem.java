package salesforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;


public class FileSystem {

	File root = null;

	class File {
		boolean isFile = false;
		Map<String, File> children = new HashMap<>();
		String content = "";
		Date date;
	}

	public FileSystem() {
		root = new File();
	}

	public List<String> ls(String path) {
		String[] dirs = path.split("/");
		String lastPath = null;

		if(path.endsWith("*")) {
			lastPath = dirs[dirs.length -1];
			lastPath = lastPath.substring(0, lastPath.length() -1);
			dirs[dirs.length -1] = "";
		}

		File node = root;
		List<String> result = new ArrayList<>();
		String name = "";
		for (String dir : dirs) {
			if (dir.length() == 0) continue;

			if (!node.children.containsKey(dir)) {
				return result;
			}
			node = node.children.get(dir);
			name = dir;
		}

		if (node.isFile) {
			if(path.endsWith("*")) {
				if(name.startsWith(lastPath)) {
					result.add(name);
				}
			} else {
				result.add(name);
			}
		}
		else {
			for (String key : node.children.keySet()) {
				if(path.endsWith("*")) {
					if(key.startsWith(lastPath)) {
						result.add(key);
					}
				} else {
					result.add(key);
				}
			}
		}

		Collections.sort(result);

		return result;
	}

	public void mkdir(String path) {
		String[] dirs = path.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}
	}

	public void writeToFile(String filePath, String content) {
		String[] dirs = filePath.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}
		node.isFile = true;
		node.content += content;
	}

	public String readFromFile(String filePath) {
		String[] dirs = filePath.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}

		return node.content;
	}

	public static void main(String args[])
	{
		FileSystem fs = new FileSystem();

		fs.mkdir("/var/lib/docker");
		fs.mkdir("/var/lib/docker2");
		fs.mkdir("/var/lib/bcker2");
		fs.mkdir("/var/lib2/docker");

		// Multi file asserion list from root directory
		List<String> files = fs.ls("/var");
		for(String file: files) {
			System.out.println(file);
		}
		List<String> actual = Arrays.asList("lib","lib2");
		assertEquals(actual, files);

		List<String> files2 = fs.ls("/var/lib");
		// Multi file asserion list
		for(String file: files2) {
			System.out.println(file);
		}		
		actual = Arrays.asList("bcker2", "docker","docker2");
		assertEquals(actual, files2);

		List<String> filesPrefix = fs.ls("/var/lib/d*");
		// Multi file asserion list
		for(String file: filesPrefix) {
			System.out.println(filesPrefix);
		}		
		actual = Arrays.asList("docker","docker2");
		assertEquals(actual, filesPrefix);

		// Single file assertion list
		List<String> files3 = fs.ls("/var/lib2");
		actual = Arrays.asList("docker");
		assertEquals(actual, files3);

		fs.writeToFile("/var/lib/1.txt", "content1");

		// check valid file content
		String content = fs.readFromFile("/var/lib/1.txt");
		assertEquals(content, "content1");

		// check invalid file content
		content = fs.readFromFile("/var/lib/1.txt");
		assertEquals(content, "content2");
	}

}