package eu.pintergabor.dirtcheap;

import eu.pintergabor.dirtcheap.datagen.ModRecipeRunner;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;


@EventBusSubscriber(modid = Global.MODID, value = Dist.CLIENT)
public class DataGen {

	@SubscribeEvent
	public static void init(GatherDataEvent.Client event) {
		// Create recipes.
		event.createProvider(ModRecipeRunner::new);
	}
}
