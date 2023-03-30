import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;
    private Bun bun;
    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }
    @Parameterized.Parameters(name = "Test data: Название булочки {0}, цена: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Вкусная булка", 50},
                {"Luchshaja bulochka", -263},
                {"Interest булочка", 25.5F},
                {"", 0},
                {null, 1},
        };
    }
    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void getBunName(){
        assertEquals("Названия отличаются", bunName, bun.getName());
    }
    @Test
    public void getBunPrice(){
        assertEquals("Цены отличаются", bunPrice, bun.getPrice(), 0);
    }

}
