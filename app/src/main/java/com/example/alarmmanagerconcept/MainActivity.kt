package com.example.alarmmanagerconcept

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var alarmManager: AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent: Intent = prepareIntent()

        val pendingIntent: PendingIntent = preparePendingIntent(intent)

        setupAlarm(pendingIntent)

    }

    private fun setupAlarm(pendingIntent: PendingIntent) {
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + 5 + 1_000L,
            pendingIntent
        )
    }

    private fun preparePendingIntent(intent: Intent): PendingIntent {
        return PendingIntent.getBroadcast(
            this,
            0,
            intent,
            FLAG_IMMUTABLE
        )
    }

    private fun prepareIntent(): Intent {
        return Intent(this, AlarmReceiver::class.java).apply {
            action = "Sohail"
            putExtra("name","Salman")
        }
    }
}