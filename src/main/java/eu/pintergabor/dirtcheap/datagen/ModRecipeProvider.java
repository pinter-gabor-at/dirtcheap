package eu.pintergabor.dirtcheap.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.dirtcheap.Global;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.HolderLookup;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import org.jetbrains.annotations.NotNull;


public class ModRecipeProvider extends FabricRecipeProvider {

	public ModRecipeProvider(
		FabricDataOutput output,
		CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	/**
	 * Generate recipes
	 */
	@Override
	@NotNull
	protected RecipeProvider createRecipeProvider(
		HolderLookup.Provider registries, RecipeOutput exporter) {
		return new RecipeProvider(registries, exporter) {
			@Override
			public void buildRecipes() {
				// Generate two shapeless recipes:
				// Mix DIRT with BONE_MEAL or with ROTTEN_FLESH to create 2 DIRTs.
				for (Item i : new Item[]{Items.BONE_MEAL, Items.ROTTEN_FLESH}) {
					shapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT, 2)
						.requires(i)
						.requires(Items.DIRT)
						.unlockedBy(getHasName(Items.DIRT), has(Items.DIRT))
						.unlockedBy(getHasName(i), has(i))
						.save(exporter,
							Global.MODID + ":" + getSimpleRecipeName(Items.DIRT) + "-" + getSimpleRecipeName(i));
				}
				// Generate two shapeless recipes:
				// Mix SAND or CLAY with large amounts of BONE_MEAL and ROTTEN_FLESH to create DIRT.
				for (Item i : new Item[]{Items.CLAY, Items.SAND}) {
					shapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT)
						// Suggest a default arangement of requires items
						.requires(Items.ROTTEN_FLESH)
						.requires(Items.BONE_MEAL)
						.requires(Items.ROTTEN_FLESH)
						.requires(Items.BONE_MEAL)
						.requires(i)
						.requires(Items.BONE_MEAL)
						.requires(Items.ROTTEN_FLESH)
						.requires(Items.BONE_MEAL)
						.requires(Items.ROTTEN_FLESH)
						.unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
						.unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
						.unlockedBy(getHasName(i), has(i))
						.save(exporter,
							Global.MODID + ":" + getSimpleRecipeName(Items.DIRT) + "-" + getSimpleRecipeName(i));
				}
			}
		};
	}

	@Override
	@NotNull
	public String getName() {
		return Global.MODID + " recipes";
	}
}
