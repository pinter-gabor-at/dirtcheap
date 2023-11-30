package eu.pintergabor.dirtcheap.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;


public class ModRecipeGenerator extends FabricRecipeProvider {
	public ModRecipeGenerator(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(RecipeExporter exporter) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT)
				.input(Items.BONE_MEAL)
				.input(Blocks.DIRT)
				.offerTo(exporter, new Identifier("dirt2-bone_meal"));
	}
}
