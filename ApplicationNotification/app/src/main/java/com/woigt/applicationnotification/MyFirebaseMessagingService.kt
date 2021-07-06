package com.woigt.applicationnotification


import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        Log.i("**newTokenService", FirebaseMessaging.getInstance().token.toString())
    }

    private val tag = "FirebaseMessagingServ"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i(tag,remoteMessage.from.toString())

        if (remoteMessage.notification != null) {
            this.showNotification("1234",
            remoteMessage.notification?.title.toString(),
            remoteMessage.notification?.body.toString())
        }
    }

}