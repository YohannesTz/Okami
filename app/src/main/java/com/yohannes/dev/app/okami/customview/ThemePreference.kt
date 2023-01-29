package com.yohannes.dev.app.okami.customview


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceManager
import com.yohannes.dev.app.okami.R
import java.util.*

class ThemePreference : ListPreference {
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
            super(context!!, attrs, defStyleAttr, defStyleRes)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context!!,attrs,defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)

    constructor(context: Context?) : super(context!!)

    override fun onClick() {
        val builder = AlertDialog.Builder(context).setSingleChoiceItems(entries,getValueIndex())
        { dialog, index ->
            if (callChangeListener(entryValues[index].toString())) {
                setValueIndex(index)

                val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
                val editor = sharedPreference.edit()
                Log.e("selectedIndex", index.toString())
                editor.putString("theme", index.toString())
                editor.apply()

                /*when (index.toString()) {
                    "1" -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    }
                    "2" -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }
                    "3" -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    }
                    "4" -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                    }
                    "5" -> {
                        if (checkIfNight()) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        }
                    }
                    else -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    }
                }*/
            }
            dialog.dismiss()
            val activity = context as Activity
            activity.recreate()
        }.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }.setTitle(title)

        val dialog = builder.create()
        //dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_borders)
        dialog.show()
    }

    private fun getValueIndex() = entryValues.indexOf(value)

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