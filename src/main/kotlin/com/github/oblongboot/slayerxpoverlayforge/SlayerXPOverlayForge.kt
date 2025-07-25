package com.github.oblongboot.slayerxpoverlayforge

import net.minecraft.client.Minecraft
import net.minecraft.init.Blocks
import net.minecraftforge.client.ClientCommandHandler
import com.github.oblongboot.slayerxpoverlayforge.command.SXPCommand
import com.github.oblongboot.slayerxpoverlayforge.utils.renderingShit.renderingstuff
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraft.client.renderer.GlStateManager
import net.minecraftforge.common.MinecraftForge


@Mod(modid = "slayerxpoverlayforge", useMetadata = true)
class slayerxpoverlayforge {
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        ClientCommandHandler.instance.registerCommand(SXPCommand())
        MinecraftForge.EVENT_BUS.register(renderingstuff)
        //MinecraftForge.EVENT_BUS.register(this) // not needed rn
        
    }
}
