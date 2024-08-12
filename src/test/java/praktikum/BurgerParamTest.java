package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerParamTest {

    private final Bun bun = new Bun(TestDefs.BLACK, 50f);

    private final List<Ingredient> ingredients;

    public BurgerParamTest(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters
    public static List<List<Ingredient>> data() {
        return List.of(
                List.of(
                        new Ingredient(IngredientType.FILLING, TestDefs.CUTLET, 150f),
                        new Ingredient(IngredientType.SAUCE, TestDefs.CHILI, 25f),
                        new Ingredient(IngredientType.SAUCE, TestDefs.MAJO, 25f)
                ),
                List.of(
                        new Ingredient(IngredientType.FILLING, TestDefs.CUTLET, 150f),
                        new Ingredient(IngredientType.FILLING, TestDefs.CUTLET, 150f),
                        new Ingredient(IngredientType.SAUCE, TestDefs.CHEESY, 25f),
                        new Ingredient(IngredientType.SAUCE, TestDefs.CHILI, 25f)
                )
        );
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            builder.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(), ingredient.getName()));
        }
        builder.append(String.format("(==== %s ====)%n%n", bun.getName()));
        builder.append(String.format("Price: %f%n", burger.getPrice()));
        String expect = builder.toString();
        Assert.assertEquals(expect, burger.getReceipt());
    }
}
