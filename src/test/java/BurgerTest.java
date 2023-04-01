import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final static String INGREDIENT_NAME = "2 мясных котлеты гриль";
    private final static String BUN_NAME = "всё на булочке с кнужутом";
    private final static float INGREDIENT_PRICE = 10.5F;
    private final static float BUN_PRICE = 7.5F;
    private final static IngredientType INGREDIENT_TYPE = FILLING;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        Mockito.when(ingredient1.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredient1.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient1.getType()).thenReturn(INGREDIENT_TYPE);
    }

    @Test
    public void setBunCheck() {
        burger.setBuns(bun);
        assertEquals("Булочки отличаются", bun, burger.bun);
    }

    @Test
    public void addIngredientCheck() {
        int ListBeforeAdding = burger.ingredients.size();
        burger.addIngredient(ingredient1);
        assertTrue("Список ингредиентов не увеличился", burger.ingredients.size() > ListBeforeAdding);
    }

    @Test
    public void removeIngredientCheck() {
        burger.addIngredient(ingredient1);
        int ListBeforeRemove = burger.ingredients.size();
        burger.removeIngredient(0);
        assertTrue("Список ингредиентов не уменьшился", ListBeforeRemove > burger.ingredients.size());
    }

    @Test
    public void moveIngredientCheck() {
        int oldIndex = 1;
        int newIndex = 0;
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(oldIndex, newIndex);
        assertEquals("Ингредиент не переместился", newIndex, burger.ingredients.indexOf(ingredient2));
    }

    @Test
    public void burgerGetPrice() {
        float totalPrice = BUN_PRICE * 2 + INGREDIENT_PRICE;
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Assert.assertThat("Цена отличается", burger.getPrice(), is(totalPrice));
    }

    @Test
    public void burgerGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        String totalReceipt = String.format("(==== %s ====)%n", BUN_NAME) +
                String.format("= %s %s =%n", INGREDIENT_TYPE.toString().toLowerCase(), INGREDIENT_NAME) +
                String.format("(==== %s ====)%n", BUN_NAME) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals("Чеки отличаются", totalReceipt, burger.getReceipt());
    }

}
