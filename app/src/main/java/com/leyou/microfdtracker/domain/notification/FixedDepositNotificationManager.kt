package com.leyou.microfdtracker.domain.notification

import com.leyou.microfdtracker.data.alarm.AlarmScheduler
import java.util.Date
import javax.inject.Inject

class FixedDepositNotificationManager @Inject constructor(private val alarmScheduler: AlarmScheduler) {

    fun scheduleNotification(fdId: Int, title: String, message: String, date: Date, daysBefore: Int) {
        alarmScheduler.scheduleAlarm(fdId, title, message, date.time, daysBefore)
    }

    fun cancelNotification(fdId: Int) {
        alarmScheduler.cancelAlarm(fdId)
    }
}