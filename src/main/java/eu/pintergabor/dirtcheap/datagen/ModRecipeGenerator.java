package eu.pintergabor.dirtcheap.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;


public class ModRecipeGenerator extends FabricRecipeProvider {
	public ModRecipeGenerator(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(RecipeExporter exporter) {
		for (Item i : new Item[]{Items.BONE_MEAL, Items.ROTTEN_FLESH}) {
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.DIRT)
					.input(i)
					.input(Items.DIRT)
					.criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT))
					.criterion(hasItem(i), conditionsFromItem(i))
					.offerTo(exporter, new Identifier(getRecipeName(Items.DIRT) + "-" + getRecipeName(i)));
		}
	}
}
