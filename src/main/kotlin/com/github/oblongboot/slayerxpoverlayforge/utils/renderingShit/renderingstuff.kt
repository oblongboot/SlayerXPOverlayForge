package com.github.oblongboot.slayerxpoverlayforge.utils.renderingShit

import com.github.oblongboot.slayerxpoverlayforge.utils.GeneralUtils
import net.minecraft.client.gui.ScaledResolution
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object renderingstuff {
    var shouldRender: Boolean = false

    fun dstring(msg: String, x: Float, y: Float, shadow: Boolean = false) {
        val fr = GeneralUtils.mc.fontRendererObj
        fr.drawString(msg, x.toFloat(), y.toFloat(), 0xFFFFFF, shadow)
    }

    fun startRenderingTest() {
        shouldRender = true
    }

    fun stopRenderingTest() {
        shouldRender = false
    }

    @SubscribeEvent
    fun onRender(event: RenderWorldLastEvent) {
        if (!shouldRender) return
        val scaledResolution = ScaledResolution(GeneralUtils.mc)
        val width = scaledResolution.scaledWidth.toFloat()
        val height = scaledResolution.scaledHeight.toFloat()
        val centerX = width / 2
        val centerY = height / 2
        dstring("Rendering test active!", centerX, centerY)
        GeneralUtils.modMessage("shit is rendering! $width $height $centerX $centerY")
    }

}
