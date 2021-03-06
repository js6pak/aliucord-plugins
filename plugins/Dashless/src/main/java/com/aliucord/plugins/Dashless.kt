package com.aliucord.plugins

import android.content.Context
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.patcher.PinePatchFn
import com.discord.api.channel.Channel
import top.canyie.pine.Pine

@AliucordPlugin
class Dashless : Plugin() {
    override fun start(context: Context?) {
        patcher.patch(
            Channel::class.java.getDeclaredMethod("m"),
            PinePatchFn { callFrame: Pine.CallFrame ->
                callFrame.result = callFrame.result.toString().replace("-", " ")
            })
    }
    
    override fun stop(context: Context?) = patcher.unpatchAll()
}