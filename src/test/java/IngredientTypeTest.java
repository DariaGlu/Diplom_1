import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final static String INGREDIENT_NAME = "Что-то вкусненькое";
    private final static float INGREDIENT_PRICE = 99.99F;
    private final IngredientType ingredientType;
    private Ingredient ingredient;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Test data: Type of an ingredient: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {FILLING},
                {SAUCE},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void getIngredientTypeReturnsEnteredValueTrue() {
        assertEquals("Типы начинок отличаются", ingredientType, ingredient.getType());
    }
}
