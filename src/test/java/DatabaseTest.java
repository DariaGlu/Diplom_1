import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    private static final int SIZE_LIST_BUN = 3;
    private static final int SIZE_LIST_INGREDIENT = 6;
    private Database database;
    @Before
    public void setUp() {
        database = new Database();
    }
    @Test
    public void quantityAvailableBuns() {
        assertEquals("Количество доступных видов булочек отличатеся", SIZE_LIST_BUN, database.availableBuns().size());
    }
    @Test
    public void quantityAvailableIngredients() {
        assertEquals("Количество доступных видов ингредиентов отличатеся", SIZE_LIST_INGREDIENT, database.availableIngredients().size());
    }

}
