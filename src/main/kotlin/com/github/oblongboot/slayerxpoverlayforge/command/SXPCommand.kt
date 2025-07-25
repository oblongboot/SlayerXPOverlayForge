package com.github.oblongboot.slayerxpoverlayforge.command

import com.github.oblongboot.slayerxpoverlayforge.utils.GeneralUtils
import com.github.oblongboot.slayerxpoverlayforge.utils.configUtils.Config
import com.github.oblongboot.slayerxpoverlayforge.utils.renderingShit.renderingstuff
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentText

class SXPCommand : CommandBase() {
    override fun getCommandName(): String = "sxp"
    override fun getCommandAliases(): List<String> = listOf("slayerxpoverlay", "sxpoverlay")
    override fun getCommandUsage(sender: ICommandSender): String = "/sxp <toggle|edit|help>"
    override fun processCommand(sender: ICommandSender, args: Array<String>) {
        if (args.isEmpty()) {
            GeneralUtils.modMessage("", true) 
            return
        }

        when (args[0].toLowerCase()) {
            "toggle" -> {
                val state = Config.toggleModule("overlay")
                val status = if (state) "ENABLED" else "DISABLED"
                GeneralUtils.modMessage("Overlay is now $status")
            }

            "edit" -> {
                GeneralUtils.modMessage("Edit mode enabled!")
            }

            "help" -> {
                GeneralUtils.modMessage("", true)
            }
            "teststuffignorepls" -> {
                GeneralUtils.modMessage("test command for testing shit")
                renderingstuff.startRenderingTest()
            }
            "teststuffstopignorepls" -> {
                GeneralUtils.modMessage("stopping test command for testing")
                renderingstuff.stopRenderingTest()
            }
            else -> {
                GeneralUtils.modMessage("Unknown setting: ${args[0]}")
                GeneralUtils.modMessage("", true)
            }
        }
    }

    override fun getRequiredPermissionLevel(): Int = 0 
}
