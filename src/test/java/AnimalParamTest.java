import com.example.Animal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final boolean shouldThrowException;

    public AnimalParamTest(String animalKind, List<String> expectedFood, boolean shouldThrowException) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения"), false},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), false},
                {"Некорректный вид", null, true}  // Проверка некорректного ввода
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();

        if (shouldThrowException) {
            try {
                animal.getFood(animalKind);
            } catch (Exception e) {
                assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
                return; // Успешно поймано исключение
            }
            throw new AssertionError("Ожидалось исключение, но его не было");
        } else {
            List<String> food = animal.getFood(animalKind);
            assertEquals(expectedFood, food);
        }
    }
}
