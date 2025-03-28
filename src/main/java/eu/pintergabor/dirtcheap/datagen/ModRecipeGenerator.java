package eu.pintergabor.dirtcheap.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.dirtcheap.Global;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;


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
	protected RecipeGenerator getRecipeGenerator(
		RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
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
				// Generate two shapeless recipes:
				// Mix SAND or CLAY with large amounts of BONE_MEAL and ROTTEN_FLESH to create DIRT.
				for (Item i : new Item[]{Items.CLAY, Items.SAND}) {
					createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT)
						// Suggest a default arangement of input items
						.input(Items.ROTTEN_FLESH)
						.input(Items.BONE_MEAL)
						.input(Items.ROTTEN_FLESH)
						.input(Items.BONE_MEAL)
						.input(i)
						.input(Items.BONE_MEAL)
						.input(Items.ROTTEN_FLESH)
						.input(Items.BONE_MEAL)
						.input(Items.ROTTEN_FLESH)
						.criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
						.criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
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
