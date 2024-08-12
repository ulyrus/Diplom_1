package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void testGetName() {
        String name = TestDefs.BLACK;
        Bun bun = new Bun(name, 50f);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        float price = 50f;
        Bun bun = new Bun(TestDefs.BLACK, price);
        Assert.assertEquals(price, bun.getPrice(), 0f);
    }
}