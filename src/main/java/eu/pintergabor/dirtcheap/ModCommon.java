package eu.pintergabor.dirtcheap;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;


@Mod(Global.MODID)
public class ModCommon {

	// The constructor for the mod class is the first code that is run when your mod is loaded.
	// FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
	public ModCommon(IEventBus modEventBus, ModContainer modContainer) {
//        // Register the commonSetup method for modloading
//        modEventBus.addListener(this::commonSetup);
//
//        // Register ourselves for server and other game events we are interested in.
//        // Note that this is necessary if and only if we want *this* class (DirtCheap) to respond directly to events.
//        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
//        NeoForge.EVENT_BUS.register(this);
//		//NeoForge.EVENT_BUS.register(DataGenerators.class);
//
//        // Register the item to a creative tab
//        modEventBus.addListener(this::addCreative);
//
//        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
//        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

//    private void commonSetup(final FMLCommonSetupEvent event)
//    {
//
////        if (Config.logDirtBlock)
////            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
////
////        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
////
////        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
//    }
//
//    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
//    @EventBusSubscriber(modid = Global.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientModEvents
//    {
//        @SubscribeEvent
//        public static void onClientSetup(FMLClientSetupEvent event)
//        {
//            // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
//        }
//    }
}
