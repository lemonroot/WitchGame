package net.lemonroot.witch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import net.lemonroot.witch.databinding.FragmentHomeBinding
import net.lemonroot.witch.databinding.FragmentSettingsBinding
import net.lemonroot.witch.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentSettingsBinding>(
            inflater, R.layout.fragment_settings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myToolbar.inflateMenu(R.menu.menu)

        binding.myToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.action_settings -> {
                    val navController = Navigation.findNavController(view)
                    navController.navigate(R.id.settingsFragment)
                    true
                } else -> false
            }
        }
    }
}