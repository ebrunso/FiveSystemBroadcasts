package com.example.fivesystembroadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ReceiverCallback  {

    var numBroadcast = 0

    val receiverOne = ReceiverOne()
    //val receiverTwo = ReceiverTwo()
    val localSecondReceiver = SecondReceiver(this)
//    val receiverThree = ReceiverThree()
    val intentFilter = IntentFilter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentFilter.addAction("broadcast")

        buttonStart.setOnClickListener(View.OnClickListener {
            ForegroundService.startService(this, "Foreground Service is running...")
        })
        buttonStop.setOnClickListener(View.OnClickListener {
            ForegroundService.stopService(this)
        })

    }

    override fun onStart(){
        super.onStart()
        registerReceiver(receiverOne, intentFilter)
        LocalBroadcastManager.getInstance(this).registerReceiver(localSecondReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiverOne)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localSecondReceiver)
    }

    fun onClick(view : View){
        when(view.id){
            R.id.btnSendMultiBroadcast -> {
                var enteredString = "First Broadcast"
                var intent = Intent("broadcast")
                intent.putExtra("KEY", enteredString)
                sendBroadcast(intent)

                enteredString = "Second Broadcast"
                intent = Intent("broadcast")
                intent.putExtra("KEY", enteredString)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

                enteredString = "Third Broadcast"
                intent = Intent("broadcast")
                intent.putExtra("KEY", enteredString)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

                enteredString = "Fourth Broadcast"
                intent = Intent("broadcast")
                intent.putExtra("KEY", enteredString)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

                enteredString = "Fifth Broadcast"
                intent = Intent("broadcast")
                intent.putExtra("KEY", enteredString)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            }
            R.id.btnStartIntentService -> {
                val intent = Intent(this, IntentPopulateRV::class.java)
                intent.action = ACTION_POPULATE_LIST
                startService(intent)
            }
        }
    }

    inner class ReceiverOne : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
            val messageRecieved = intent.getStringExtra("KEY")
            Log.d("TAG", "First Message Received: $messageRecieved")
            tvBroadcastOne.text = messageRecieved
            numBroadcast += 1
            tvBroadcastTotal.text = "Total number of Broadcast Messages: $numBroadcast"
        }
    }

    override fun passInfoToUI(passedValue: String) {
        if (passedValue == "Second Broadcast"){
            tvBroadcastTwo.text = passedValue
        }
        if (passedValue == "Third Broadcast"){
            tvBroadcastThree.text = passedValue
        }
        if (passedValue == "Fourth Broadcast"){
            tvBroadcastFour.text = passedValue
        }
        if (passedValue == "Fifth Broadcast"){
            tvBroadcastFive.text = passedValue
        }

        numBroadcast += 1
        tvBroadcastTotal.text = "Total number of Broadcast Messages: $numBroadcast"
    }

}
