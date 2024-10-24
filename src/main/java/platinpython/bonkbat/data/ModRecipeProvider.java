package platinpython.bonkbat.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.BatTypes;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
        super(lookupProvider, output);
    }

    @Override
    protected void buildRecipes() {
        BatTypes.TYPES.forEach(
            (name, type) -> ShapedRecipeBuilder.shaped(BuiltInRegistries.ITEM, RecipeCategory.COMBAT, type.bat().get())
                .group(ResourceLocation.fromNamespaceAndPath(BonkBat.MOD_ID, "bat").toString())
                .define('W', type.wood().get())
                .define('S', Items.STICK)
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .unlockedBy("has_wood", has(type.wood().get()))
                .save(this.output)
        );
    }

    public static class Runner extends RecipeProvider.Runner {
        protected Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
            return new ModRecipeProvider(lookupProvider, output);
        }

        @Override
        public String getName() {
            return "Bonk Bat Recipes";
        }
    }
}
