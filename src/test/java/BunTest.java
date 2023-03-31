import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final static String BUN_NAME = "Сладкая булочка";
    private final static float BUN_PRICE = 150.5F;
    private Bun bun;
    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }
    @Test
    public void getBunName(){
        assertEquals("Названия отличаются", BUN_NAME, bun.getName());
    }
    @Test
    public void getBunPrice(){
        assertEquals("Цены отличаются", BUN_PRICE, bun.getPrice(), 0);
    }

}
