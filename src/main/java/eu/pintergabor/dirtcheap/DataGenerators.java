package eu.pintergabor.dirtcheap;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.dirtcheap.datagen.ModRecipeProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ModCommon.MODID, value = Dist.CLIENT)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		event.addProvider(new ModRecipeProvider.Runner(output, lookupProvider) {
			@Override
			protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
				return new ModRecipeProvider(provider, recipeOutput);
			}

			@Override
			public @NotNull String getName() {
				return "Name";
			}
		});
//		DataGenerator generator = event.getGenerator();
//		PackOutput packOutput = generator.getPackOutput();
//		generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
	}
}
