import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestCat {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mustBeMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    Feline feline = Mockito.mock(Feline.class);

    @Test
    public void mustBeMeat() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Collections.singletonList("Мясо"));
        String actual = String.valueOf(cat.getFood());
        String expected = "[Мясо]";
        assertEquals(expected, actual);
    }
}
