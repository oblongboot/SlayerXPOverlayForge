package com.github.oblongboot.slayerxpoverlayforge.utils.configUtils

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import net.minecraft.util.ChatComponentText
import java.io.File

object Config {
    private val configDir = File("config/slayerxpoverlayforge")
    private val configFile = File(configDir, "config.json")
    private val gson = GsonBuilder().setPrettyPrinting().create()
    private val configMap: MutableMap<String, Boolean> = mutableMapOf()

    init {
        if (!configDir.exists()) configDir.mkdirs()
        if (configFile.exists()) {
            val json = configFile.readText()
            val type = object : TypeToken<MutableMap<String, Boolean>>() {}.type
            val loaded = gson.fromJson<MutableMap<String, Boolean>>(json, type)
            configMap.putAll(loaded)
        } else {
            save()
        }
    }

    fun isModuleEnabled(module: String): Boolean {
        return configMap[module] ?: false
    }

    fun toggleModule(module: String): Boolean {
        val newState = !(configMap[module] ?: false)
        configMap[module] = newState
        save()
        return newState
    }

    private fun save() {
        configFile.writeText(gson.toJson(configMap))
    }
}
