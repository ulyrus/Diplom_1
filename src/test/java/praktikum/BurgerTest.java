package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final Bun bun = new Bun(TestDefs.BLACK, 50f);

    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient sauce2;
    @Mock
    private Ingredient fill;

    @Before
    public void setUp() {
        Mockito.when(sauce.getPrice()).thenReturn(25f);
        Mockito.when(sauce2.getPrice()).thenReturn(25f);
        Mockito.when(fill.getPrice()).thenReturn(150f);
    }

    @Test
    public void testAddIngredientAdded() {
        Burger burger = new Burger();
        Ingredient ingredient = sauce;
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(sauce2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(sauce, burger.ingredients.get(1));
    }

    @Test
    public void testBurgerPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        float expectPrice = burger.bun.price * 2f;
        List<Ingredient> ingredients = List.of(sauce, sauce2, fill);
        for (Ingredient ingredient : ingredients) {
            expectPrice += ingredient.getPrice();
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(expectPrice, burger.getPrice(), 0f);
    }
}
