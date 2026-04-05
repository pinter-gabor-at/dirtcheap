package eu.pintergabor.dirtcheap.datagen;

import static net.minecraft.data.recipes.RecipeProvider.getSimpleRecipeName;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import eu.pintergabor.dirtcheap.Global;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;


public class ModRecipeProvider extends FabricRecipeProvider {

	public ModRecipeProvider(
		FabricPackOutput output,
		CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	/**
	 * Create recipe name.
	 *
	 * @param i from this {@link Item}
	 */
	private @NonNull String makeRecipeName(@NonNull Item i) {
		return Global.MODID + ":" + getSimpleRecipeName(Items.DIRT) + "-" + getSimpleRecipeName(i);
	}

	/**
	 * Generate recipes.
	 */
	@Override
	protected @NonNull RecipeProvider createRecipeProvider(
		HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput exporter
	) {
		return new RecipeProvider(registries, exporter) {
			@Override
			public void buildRecipes() {
				// Generate two shapeless recipes:
				// Mix DIRT with BONE_MEAL or with ROTTEN_FLESH to create 2 DIRTs.
				Stream.of(Items.BONE_MEAL, Items.ROTTEN_FLESH)
					.forEach(i -> shapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT, 2)
						.requires(i)
						.requires(Items.DIRT)
						.unlockedBy(getHasName(Items.DIRT), has(Items.DIRT))
						.unlockedBy(getHasName(i), has(i))
						.save(exporter, makeRecipeName(i)));
				// Generate two shapeless recipes:
				// Mix SAND or CLAY with large amounts of BONE_MEAL and ROTTEN_FLESH to create DIRT.
				Stream.of(Items.CLAY, Items.SAND)
					.forEach(i -> shapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT)
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
						.save(exporter, makeRecipeName(i)));
			}
		};
	}

	@Override
	public @NonNull String getName() {
		return Global.MODID + " recipes";
	}
}
