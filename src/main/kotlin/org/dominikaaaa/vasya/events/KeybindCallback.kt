package org.dominikaaaa.vasya.events

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory

interface KeybindCallback {
    fun press(key: Int, state: Int)

    companion object {
        @JvmField
        val EVENT: Event<KeybindCallback> = EventFactory.createArrayBacked(
            KeybindCallback::class.java
        ) {
            object : KeybindCallback {
                override fun press(key: Int, state: Int) {
                }
            }
        }
    }
}