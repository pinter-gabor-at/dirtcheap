package eu.pintergabor.dirtcheap.datagen;

import eu.pintergabor.dirtcheap.Global;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

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
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                // Generate two shapeless recipes:
                // Mix DIRT with BONE_MEAL or with ROTTEN_FLESH to create 2 DIRTs.
                for (Item i : new Item[]{Items.BONE_MEAL, Items.ROTTEN_FLESH}) {
                    createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT, 2)
                            .input(i)
                            .input(Items.DIRT)
                            .criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT))
                            .criterion(hasItem(i), conditionsFromItem(i))
                            .offerTo(exporter,
                                    Global.MODID + ":" + getRecipeName(Items.DIRT) + "-" + getRecipeName(i));
                }
            }
        };
    }

    @Override
    public String getName() {
        return Global.MODID + " recipes";
    }
}
