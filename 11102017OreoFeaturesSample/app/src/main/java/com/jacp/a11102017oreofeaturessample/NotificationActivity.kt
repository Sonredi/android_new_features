package com.jacp.a11102017oreofeaturessample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    lateinit var notificationHelper: NotificationHelper

    companion object {
        private val NOTIFICATION_FOLLOW = 1100
        private val NOTIFICATION_UNFOLLOW = 1101
        private val NOTIFICATION_FRIEND = 1200
        private val NOTIFICATION_COWORKER = 1201
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        notificationHelper = NotificationHelper(this)

        a_notif_folow.setOnClickListener{sendNotification(NOTIFICATION_FOLLOW)}
        a_notif_unfollow.setOnClickListener{sendNotification(NOTIFICATION_UNFOLLOW)}
        a_notif_friend.setOnClickListener{sendNotification(NOTIFICATION_FRIEND)}
        a_notif_coworker.setOnClickListener{sendNotification(NOTIFICATION_COWORKER)}

    }

    private fun sendNotification(id: Int) {
        when (id) {
            NOTIFICATION_FOLLOW -> notificationHelper.notify(id, notificationHelper.
                    getNotificationFollower("Follower", "${notificationHelper.randomName} is now following you"))

            NOTIFICATION_UNFOLLOW -> notificationHelper.notify(id, notificationHelper.
                    getNotificationFollower("Follower", "${notificationHelper.randomName} has stoped following you"))

            NOTIFICATION_FRIEND -> notificationHelper.notify(id, notificationHelper.
                    getNotificationDM("Direct message", "${notificationHelper.randomName} washapp"))

            NOTIFICATION_COWORKER -> notificationHelper.notify(id, notificationHelper.
                    getNotificationDM("Direct message", "${notificationHelper.randomName} have you finished the report?"))
        }
    }
}
