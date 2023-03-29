import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final String expectedName;
    private final float bunPrice;
    private final float expectedPrice;
    private Bun bun;
    public BunTest(String bunName, String expectedName, float bunPrice, float expectedPrice) {
        this.bunName = bunName;
        this.expectedName = expectedName;
        this.bunPrice = bunPrice;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters(name = "Test data: Название булочки {0}, цена: {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Вкусная булка", "Вкусная булка", 50, 50},
                {"Luchshaja bulochka", "Luchshaja bulochka", -263, -263},
                {"Interest булочка", "Interest булочка", 25.5F, 25.5F},
                {"", "", 0, 0},
                {null, null, 1, 1},
        };
    }
    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getBunName(){
        assertEquals("Названия отличаются", expectedName, bun.getName());
    }
    @Test
    public void getBunPrice(){
        assertEquals("Цены отличаются", expectedPrice, bun.getPrice(), 0);
    }

}
