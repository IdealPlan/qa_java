import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFeline {
    private int countKittens;
    private int expected;

    public TestFeline(int countKittens, int expected) {
        this.countKittens = countKittens;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { 10, 10},
                { 4, 4},
        };
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens(countKittens);
        assertEquals(expected, actual);
    }

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        String actual = String.valueOf(feline.eatMeat());
        assertEquals("[Животные, Птицы, Рыба]", actual);
    }

    @Test
  public void getFamily(){
        Feline feline = new Feline();
      assertEquals("Кошачьи", feline.getFamily());
  }

}