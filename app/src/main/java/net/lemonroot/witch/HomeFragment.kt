package net.lemonroot.witch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import net.lemonroot.witch.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false)

        binding.btnFetch.setOnClickListener { v: View ->
            fetchInfo()
        }
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

    private fun fetchInfo() {
        val userRecord: String = FirebaseAuth.getInstance().currentUser!!.uid
// See the UserRecord reference doc for the contents of userRecord.
// See the UserRecord reference doc for the contents of userRecord.
        System.out.println("Successfully fetched user data: $userRecord")

    }
}