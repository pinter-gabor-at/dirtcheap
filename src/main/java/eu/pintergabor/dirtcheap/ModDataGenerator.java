package eu.pintergabor.dirtcheap;

import eu.pintergabor.dirtcheap.datagen.ModRecipeGenerator;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import org.jspecify.annotations.NonNull;


@EventBusSubscriber(modid = Global.MODID, value = Dist.CLIENT)
public class ModDataGenerator {

	@SubscribeEvent
	public static void listen(@NonNull GatherDataRegistryEntriesEvent event) {
		event
			// Create recipes.
			.add(ModRecipeGenerator.create());
	}
}
