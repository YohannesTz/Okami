package com.yohannes.dev.app.okami.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.yohannes.dev.app.okami.R
import com.yohannes.dev.app.okami.databinding.SettingsActivityBinding
import com.yohannes.dev.app.okami.util.Constants

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: SettingsActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        setSupportActionBar(binding.toolbar)

    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }

        override fun onPreferenceTreeClick(preference: Preference): Boolean {
            return when (preference.key) {
                "send_feedback" -> {
                    val emailIntent = Intent(Intent.ACTION_SENDTO)
                    emailIntent.data = Uri.parse("mailto:")
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, Constants.EMAIL_ADDRESS)
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Personal feedback")
                    startActivity(Intent.createChooser(emailIntent, "Send Email"))
                    true
                }
                "telegram" -> {
                    val uri = Uri.parse(Constants.TELEGRAM_ADDRESS)

                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                    true
                }
                "github" -> {
                    val uri = Uri.parse(Constants.GITHUB_ADDRESS)

                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}