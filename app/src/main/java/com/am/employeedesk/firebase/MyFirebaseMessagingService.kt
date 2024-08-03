package com.am.employeedesk.firebase


import android.content.Context
import androidx.core.app.NotificationCompat
import com.am.employeedesk.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import okhttp3.internal.notify
import timber.log.Timber


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Timber.e("Refreshed ", token)
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fcm_token", token).apply()
    }

    override fun onMessageReceived(message: RemoteMessage) {
        if (message.data.isNotEmpty()) {

        }
        message.notification?.let {
            val messageBody = it.body
            val messageTitle = it.title
            val builder = NotificationCompat.Builder(this, "Test")
                .setSmallIcon(R.drawable.network_check)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()
        }
    }

    companion object {
        fun getToken(context: Context): String? {
            return context.getSharedPreferences("_", MODE_PRIVATE).getString("fcm_token", "empty")
        }
    }


}