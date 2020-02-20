package com.example.fivesystembroadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SecondReceiver(val receiverCallback: ReceiverCallback) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val messageRecieved = intent.getStringExtra("KEY")
        Log.d("TAG", "Passed Message Received: $messageRecieved")
        receiverCallback.passInfoToUI(messageRecieved)

    }
}

interface ReceiverCallback{
    fun passInfoToUI(passedValue : String)
}