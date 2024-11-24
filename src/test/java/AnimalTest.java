import com.example.Animal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}

