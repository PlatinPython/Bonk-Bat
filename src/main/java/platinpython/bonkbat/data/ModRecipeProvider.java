package platinpython.bonkbat.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import platinpython.bonkbat.util.BatTypes;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        BatTypes.TYPES.forEach(
            (name, type) -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, type.bat().get())
                .define('W', type.wood().get())
                .define('S', Items.STICK)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .unlockedBy("has_wood", has(type.wood().get()))
                .save(writer)
        );
    }
}
