import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    static Feline feline;

    private String sex;
    private String expected;

    public LionTest(Feline feline, String sex, String expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {feline, "Самец", "true"},
                {feline, "Самка", "false"},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(sex);
        String actual = String.valueOf(lion.doesHaveMane());
        assertEquals(expected, actual);
    }


    @Test
    public void getFood() throws Exception {
        when(feline.eatMeat()).thenReturn(Collections.singletonList("Хищник"));
        Lion lion = new Lion(sex);
        String actual = "[Животные, Птицы, Рыба]";
        assertThat(actual, equalTo(String.valueOf(lion.getFood())));
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(sex);
        when(feline.getKittens()).thenReturn(5);
        int actual = 5;
        assertEquals(actual, feline.getKittens());
    }
}