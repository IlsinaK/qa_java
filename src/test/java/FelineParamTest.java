import com.example.Feline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final String foodType;
    private final List<String> expectedFood;

    public FelineParamTest(String foodType, List<String> expectedFood) {
        this.foodType = foodType;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood(foodType);
        assertEquals(expectedFood, food);
    }

}

