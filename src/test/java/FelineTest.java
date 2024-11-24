import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
        assertEquals(3, feline.getKittens(3));
    }
    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3)); // Проверяем метод с параметром
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

}


