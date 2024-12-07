package com.example.servicesapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyAirplaneModeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if(intent?.action != null && intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){

            var isAirplaneModeOn: Boolean = intent.getBooleanExtra("state", false)

            if(isAirplaneModeOn){
                Toast.makeText(context,
                    "Airplane Mode is ON!!",
                    Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context,
                    "Airplane Mmode is OFF!!",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

}