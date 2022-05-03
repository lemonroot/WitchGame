package net.lemonroot.witch

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class OldSettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}