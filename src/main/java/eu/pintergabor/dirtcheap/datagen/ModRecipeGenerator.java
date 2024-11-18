package eu.pintergabor.dirtcheap.datagen;

import eu.pintergabor.dirtcheap.Global;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(
            FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * Generate recipes
     */
    @Override
    public void generate(RecipeExporter exporter) {
        // Generate two shapeless recipes:
        // Mix DIRT with BONE_MEAL or with ROTTEN_FLESH to create 2 DIRTs.
        for (Item i : new Item[]{Items.BONE_MEAL, Items.ROTTEN_FLESH}) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.DIRT, 2)
                    .input(i)
                    .input(Items.DIRT)
                    .criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT))
                    .criterion(hasItem(i), conditionsFromItem(i))
                    .offerTo(exporter, Identifier.of(
                            Global.MODID,
                            getRecipeName(Items.DIRT) + "-" + getRecipeName(i)));
        }
    }
}
