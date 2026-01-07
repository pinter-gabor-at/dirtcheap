package eu.pintergabor.dirtcheap;

import eu.pintergabor.dirtcheap.datagen.ModRecipeRunner;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jspecify.annotations.NonNull;


@EventBusSubscriber(modid = Global.MODID, value = Dist.CLIENT)
public class ModDataGenerator {

	@SubscribeEvent
	public static void init(GatherDataEvent.@NonNull Client event) {
		// Create recipes.
		event.createProvider(ModRecipeRunner::new);
	}
}
