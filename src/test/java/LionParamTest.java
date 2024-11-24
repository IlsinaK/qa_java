import com.example.Feline;
import com.example.Lion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"НекорректныйПол", false}
        };
    }

    @Test
    public void lionConstructorTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        if ("НекорректныйПол".equals(sex)) {
            try {
                new Lion(feline, sex);
            } catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
                return;
            }
            throw new AssertionError("Ожидалось исключение, но его не было");
        } else {
            Lion lion = new Lion(feline, sex);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        }
    }
}

