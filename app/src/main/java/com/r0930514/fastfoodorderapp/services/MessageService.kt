package com.r0930514.fastfoodorderapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.r0930514.fastfoodorderapp.R


class MessageService: FirebaseMessagingService(){
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("MessageService", "onNewToken: $token")
        Log.d("TAG", "onNewToken: $token")
        showNotification("程式初始化", "通知初始化")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d("TAG", "From: ${remoteMessage.from}")
        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("TAG", "Message data payload: ${remoteMessage.data}")
        }
        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            showNotification(it.title, it.body)
        }

    }
    private fun showNotification(title: String?, body: String?) {
        createNotificationChannel()
        // 在這裡實作通知的顯示邏輯
        // 可以使用 NotificationManager 來顯示通知
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        // 設定通知的樣式、內容等
        val notificationBuilder = NotificationCompat.Builder(this, "normal")
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.mipmap.icon1219r)
            .setSound(soundUri)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_MAX)

        // 執行顯示通知
        notificationManager.notify(2, notificationBuilder.build())
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel.
        val name = "通知測試"
        val descriptionText = "通知測試"
        val importance = NotificationManager.IMPORTANCE_HIGH

        val mChannel = NotificationChannel("normal", name, importance)
        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        mChannel.description = descriptionText
        mChannel.setSound(soundUri, null)

        // Register the channel with the system. You can't change the importance
        // or other notification behaviors after this.
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(mChannel)
    }


}