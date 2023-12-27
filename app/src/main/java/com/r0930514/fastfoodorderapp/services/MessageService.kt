package com.r0930514.fastfoodorderapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
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
        // 設定通知的樣式、內容等
        val notificationBuilder = NotificationCompat.Builder(this, "normal")
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.mipmap.icon1219r)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // 執行顯示通知
        notificationManager.notify(2, notificationBuilder.build())
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel.
            val name = "通知測試"
            val descriptionText = "通知測試"
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val mChannel = NotificationChannel("normal", name, importance)

            mChannel.description = descriptionText

            // Register the channel with the system. You can't change the importance
            // or other notification behaviors after this.
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }

}