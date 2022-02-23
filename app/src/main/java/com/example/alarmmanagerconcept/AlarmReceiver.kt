package com.example.alarmmanagerconcept

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action == "Sohail"){
            val name = intent.getStringExtra("name")
            Toast.makeText(context, name,Toast.LENGTH_SHORT).show()
        }
    }

}