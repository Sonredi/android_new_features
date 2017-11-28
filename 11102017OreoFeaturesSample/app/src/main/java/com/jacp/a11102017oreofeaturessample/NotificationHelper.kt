package com.jacp.a11102017oreofeaturessample

import android.app.*
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Color
import java.util.*

/**
 * Created by Aptivist-U002 on 11/10/2017.
 */
class NotificationHelper(contex: Context) : ContextWrapper(contex) {

    companion object {
        val followerChannel = "follower"
        val dmChannel = "dm_channel"
    }


    private val mNotificationManager:NotificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    init {
        val followerChannel = buildChannel(followerChannel, "Follower channel", Color.GRAY)
        val dmChannel = buildChannel(dmChannel, "Direct Messages channel", Color.RED)
        mNotificationManager.createNotificationChannel(followerChannel)
        mNotificationManager.createNotificationChannel(dmChannel)

    }

    private fun buildChannel(followerChannel: String, s: String, gray: Int): NotificationChannel {
        val channel = NotificationChannel(followerChannel, s, NotificationManager.IMPORTANCE_DEFAULT)

        channel.lightColor = Color.GREEN
        channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 500, 200, 500)
        return channel
    }

    fun getNotificationFollower(title:String, body: String): Notification.Builder {
        return Notification.Builder(applicationContext, followerChannel)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(smallIcon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
    }

    fun getNotificationDM(title:String, body: String): Notification.Builder {
        return Notification.Builder(applicationContext, dmChannel)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(smallIcon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
    }
    private val pendingIntent: PendingIntent
    get() {
        val openMainIntent = Intent(this, NotificationActivity::class.java)
        val stackBuilder = TaskStackBuilder.create(this)
        stackBuilder.addParentStack(MainActivity::class.java)
        stackBuilder.addNextIntent(openMainIntent)
        return stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT)
    }

    private val smallIcon: Int get() = android.R.drawable.stat_notify_call_mute

    val randomName: String
        get() {
            var names = Arrays.asList("JACP", "Edwin", "Omar")
            return names[Random().nextInt(names.size)]
        }

    fun notify(id: Int, notification: Notification.Builder) {
        mNotificationManager.notify(id, notification.build())
    }

}