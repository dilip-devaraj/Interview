import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteConversion {
  public static void main(String[] args) {
	  int dateInSec = (int) (1525824000);
	  byte[] bytes = ByteBuffer.allocate(4).putInt(dateInSec).array();
	  
	  System.out.println(Arrays.toString(bytes));
	  
	  byte[] bytes2 = { 0, 0, 1, 14, -121, 125 };
	  
	  System.out.println(ByteBuffer.wrap(bytes).getInt());
	  System.out.println(ByteBuffer.wrap(bytes2).getInt());
	  
	  byte b = -1;
	  System.out.println(b & 0xff);
			  
  }
}
