import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


public class IngredientTest {
    private final static String INGREDIENT_NAME = "Котлетка из ёжика";
    private final static float INGREDIENT_PRICE = 88;
    private final static IngredientType INGREDIENT_TYPE = SAUCE;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void getIngredientName() {
        assertEquals("Названия отличаются", INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void getIngredientPrice() {
        assertEquals("Цены отличаются", INGREDIENT_PRICE, ingredient.getPrice(), 0);
    }

}
