package eu.pintergabor.dirtcheap.datagen;

import eu.pintergabor.dirtcheap.Global;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;


public class ModRecipeProvider extends RecipeProvider {
	private final RecipeOutput exporter;

	public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
		super(registries, output);
		this.exporter = output;
	}

	/**
	 * Generate recipes
	 */
	@Override
	protected void buildRecipes() {

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
}
