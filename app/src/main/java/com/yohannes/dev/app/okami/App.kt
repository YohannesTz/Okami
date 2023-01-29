package com.yohannes.dev.app.okami

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.HiltAndroidApp
import java.util.*


@HiltAndroidApp
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val themeId = sharedPreference.getString("theme", "Light")
        Log.e("themeId", themeId.toString())

        val themes = resources.getStringArray(R.array.theme)

//        when (themes[Integer.parseInt(themeId!!)]) {
        when (themeId) {
            "Light" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            "Dark" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            "Follow System" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
            "Save Battery" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
            }
            "Follow Time" -> {
                if (checkIfNight()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FirebaseMessaging", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.d("FirebaseMessaging", "this is the token {$token}")
        })
    }

    private fun checkIfNight(): Boolean {
        val start = 21
        val end = 7
        val hours = 24 - start + end
        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, start)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        val startHourMilli: Long = cal.timeInMillis
        Log.e("time",cal.time.toString())
        cal.add(Calendar.HOUR_OF_DAY, hours)
        val endHourMilli: Long = cal.timeInMillis
        val currentMilli: Long = Calendar.getInstance().timeInMillis
        return currentMilli in startHourMilli..endHourMilli
    }
}