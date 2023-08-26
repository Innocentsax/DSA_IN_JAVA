/**write me a function stringy that takes a size and returns a string of alternating '1s' and '0s'.

the string should start with a 1.

a string with size 6 should return :'101010'.

with size 4 should return : '1010'.

with size 12 should return : '101010101010'.

The size will always be positive and will only use whole numbers.*/

// Imperative solution
public class Kata {
  public static String stringy(int size) {
    // Your code here
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++){
      if(i % 2 == 0){
        sb.append("1");
      }else{
        sb.append("0");
      }
    }return sb.toString();
  }
}


// TEST FOR THE CODE ABOVE
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Random;

public class StringyExampleTests {
  @Test
  public void startTest() {
    assertEquals("Your string should start with a 1", '1', Kata.stringy(3).charAt(0));
  }
  
  @Test
  public void lengthTests() {
    Random randGen = new Random();
    for (int i = 0; i < 10; i++) {
      int size = randGen.nextInt(50);
      assertEquals("Wrong length using size " + size, size, Kata.stringy(size).length());
    }
  }
}
