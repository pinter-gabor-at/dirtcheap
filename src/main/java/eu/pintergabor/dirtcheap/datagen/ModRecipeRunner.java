package eu.pintergabor.dirtcheap.datagen;

import eu.pintergabor.dirtcheap.Global;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;


public class ModRecipeRunner extends RecipeProvider.Runner{

	public ModRecipeRunner(
		PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	@NotNull
	protected RecipeProvider createRecipeProvider(
		@NotNull HolderLookup.Provider registries,
		@NotNull RecipeOutput output) {
		return new ModRecipeProvider(registries, output);
	}

	@Override
	@NotNull
	public String getName() {
		return Global.MODID + " recipes";
	}
}
