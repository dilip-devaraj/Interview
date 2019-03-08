import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUid = 1L;
	String name= "Dilip";
	int age=30;


	public static void main(String[] args) throws IOException, ClassNotFoundException{
		FileOutputStream fo = new FileOutputStream("/Users/ddevaraj/1.txt");
		ObjectOutputStream os = new ObjectOutputStream(fo);
		os.writeObject(new Employee());

		FileInputStream fi = new FileInputStream("/Users/ddevaraj/1.txt");
		ObjectInputStream is = new ObjectInputStream(fi);
		Employee e = (Employee) is.readObject();
		System.out.println(e.name + e.age);
	}
}
