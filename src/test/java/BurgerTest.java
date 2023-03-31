import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final List<Ingredient> ingredients = new ArrayList<>();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunCheck() {
        burger.setBuns(bun);
        assertEquals("Булочки отличаются", bun, burger.bun);
    }

    @Test
    public void addIngredientCheck() {
        int ListBeforeAdding = burger.ingredients.size();
        burger.addIngredient(ingredient);
        assertTrue("Список ингредиентов не увеличился", burger.ingredients.size() > ListBeforeAdding);
    }
}
