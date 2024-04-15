package multiteam.bloomanddoom.forge.data;

import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.item.ModItems;
import multiteam.bloomanddoom.tags.ModItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider {
    public ModRecipesProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        planksFromLog(consumer, ModBlocks.STEM_PLANKS.get().asItem(), ModItemTags.STEMS, 4);
        pressurePlate(consumer, ModBlocks.STEM_PRESSURE_PLATE.get(), ModBlocks.STEM_PLANKS.get());
        buttonBuilder(ModBlocks.STEM_BUTTON.get(), Ingredient.of(ModBlocks.STEM_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.STEM_PLANKS.get()), has(ModBlocks.STEM_PLANKS.get()))
                .save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEM_SLAB.get(), ModBlocks.STEM_PLANKS.get());
        stairBuilder(ModBlocks.STEM_STAIRS.get(), Ingredient.of(ModBlocks.STEM_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.STEM_PLANKS.get()), has(ModBlocks.STEM_PLANKS.get()))
                .save(consumer);


        doorBuilder(ModBlocks.STEM_DOOR.get(), Ingredient.of(ModBlocks.STEM_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.STEM_PLANKS.get()), has(ModBlocks.STEM_PLANKS.get()))
                .save(consumer);

        fenceBuilder(ModBlocks.STEM_FENCE.get(), Ingredient.of(ModBlocks.STEM_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.STEM_PLANKS.get()), has(ModBlocks.STEM_PLANKS.get()))
                .save(consumer);

        fenceGateBuilder(ModBlocks.STEM_FENCE_GATE.get(), Ingredient.of(ModBlocks.STEM_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.STEM_PLANKS.get()), has(ModBlocks.STEM_PLANKS.get()))
                .save(consumer);

        trapdoorBuilder(ModBlocks.STEM_TRAPDOOR.get(), Ingredient.of(ModBlocks.STEM_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.STEM_PLANKS.get()), has(ModBlocks.STEM_PLANKS.get()))
                .save(consumer);

        woodFromLogs(consumer, ModBlocks.STEM_BUNDLE.get(), ModBlocks.STEM.get());

        woodenBoat(consumer, ModItems.STEM_BOAT.get(), ModBlocks.STEM_PLANKS.get());
        chestBoat(consumer, ModItems.STEM_CHEST_BOAT.get(), ModItems.STEM_BOAT.get());

        signBuilder(ModBlocks.STEM_SIGN.get(), Ingredient.of(ModBlocks.STEM_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.STEM_PLANKS.get()), has(ModBlocks.STEM_PLANKS.get()))
                .save(consumer);

        hangingSign(consumer, ModBlocks.STEM_HANGING_SIGN.get(), ModBlocks.STRIPPED_STEM.get());
    }
}
