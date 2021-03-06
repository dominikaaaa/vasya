package org.dominikaaaa.vasya

import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.TextFormat
import net.minecraft.text.LiteralText

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
open class Feature(
    val name: String,
    val description: String?,
    val category: Category,
    val bind: Int,
    _enabled: Boolean = false
) {

    var enabled = _enabled
        set(value) {
            if (field == value) return // Early return if field doesn't actually change
            field = value
            if (value)
                onEnable()
            else
                onDisable()
            onToggle()
        }

    open fun onEnable() {}

    open fun onDisable() {}

    open fun onToggle() {}

    open fun onUpdate() {}

    fun toggle() {
        enabled = !enabled
    }

    val mc: MinecraftClient = MinecraftClient.getInstance()

    fun registerUpdate() {
        if (enabled) {
            onUpdate()
        }
    }

    enum class Category(s: String) {
        PLAYER("Player"),
        WORLD("World")
    }

    companion object {
        fun sendMessage(message: String) {
            sendRawMessage("[" + TextFormat.GRAY + vasya + TextFormat.WHITE + "] $message")
        }

        fun sendRawMessage(message: String) {
            MinecraftClient.getInstance().player?.sendMessage(LiteralText(message))
        }

        const val vasya = "\u2c7d\u1d2c"
    }
}