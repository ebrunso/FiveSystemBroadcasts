package com.example.fivesystembroadcasts

import android.app.IntentService
import android.content.Intent
import android.content.Context

const val ACTION_POPULATE_LIST = "com.example.fivesystembroadcasts.action.FOO"

private const val EXTRA_PARAM1 = "com.example.fivesystembroadcasts.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.fivesystembroadcasts.extra.PARAM2"


class IntentPopulateRV : IntentService("IntentPopulateRV") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_POPULATE_LIST -> {
                handleActionPop()
            }
        }
    }

    private fun handleActionPop() {

    }

    companion object {
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, IntentPopulateRV::class.java).apply {
                action = ACTION_POPULATE_LIST
            }
            context.startService(intent)
        }

    }
}
