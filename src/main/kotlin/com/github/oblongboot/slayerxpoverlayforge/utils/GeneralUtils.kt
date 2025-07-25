package com.github.oblongboot.slayerxpoverlayforge.utils

import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText

object GeneralUtils {
    val mc: Minecraft = Minecraft.getMinecraft()

    fun modMessage(message: String, help: Boolean? = false) {
        if (help != true) {
            mc.thePlayer?.addChatMessage(ChatComponentText("§bSlayerXPOverlay » §3$message"))
        } else {
            val helpMessage = listOf(
                "I can't be bothered to make a GUI for this! So it's a chat config instead!",
                "USAGE:",
                "  /sxp <setting>",
                "Valid settings include:",
                "  • edit §7(to edit the overlay’s position)",
                "  • toggle §7(to toggle the overlay on/off)",
                "That’s all I think maybe"
            )
            helpMessage.forEach { msg -> 
                mc.thePlayer?.addChatMessage(ChatComponentText("§bSlayerXPOverlay » §3$msg"))
            }
        }
    }
}
