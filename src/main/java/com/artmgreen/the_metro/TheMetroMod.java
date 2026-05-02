package com.artmgreen.the_metro;   // <-- adjust this line

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod("the_metro")
public class TheMetroMod {

    public static final String METRO_DIM = "the_metro:the_metro";

    public TheMetroMod(IEventBus modEventBus) {
        modEventBus.addListener(this::onCommonSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        // Glass frame -> Overworld <-> Metro
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.GLASS)
                .destDimID(ResourceLocation.parse(METRO_DIM))
                .returnDim(ResourceLocation.withDefaultNamespace("overworld"), true)
                .tintColor(0xbce0ff)
                .registerPortal();

        // Red glass -> Nether <-> Metro
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.RED_STAINED_GLASS)
                .destDimID(ResourceLocation.parse(METRO_DIM))
                .returnDim(ResourceLocation.withDefaultNamespace("the_nether"), true)
                .tintColor(0xff4d4d)
                .registerPortal();

        // Yellow glass -> End <-> Metro
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.YELLOW_STAINED_GLASS)
                .destDimID(ResourceLocation.parse(METRO_DIM))
                .returnDim(ResourceLocation.withDefaultNamespace("the_end"), true)
                .tintColor(0xffff66)
                .registerPortal();
    }
}
