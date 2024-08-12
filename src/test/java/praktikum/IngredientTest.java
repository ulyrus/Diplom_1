package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void testGetPrice() {
        float expectedPrice = 25f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, TestDefs.CHEESY, expectedPrice);
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0f);
    }

    @Test
    public void testGetName() {
        String expectedName = TestDefs.CHEESY;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, expectedName, 25f);
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        IngredientType expectedType = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(expectedType, TestDefs.CHEESY, 25f);
        Assert.assertEquals(expectedType, ingredient.getType());
    }
}
