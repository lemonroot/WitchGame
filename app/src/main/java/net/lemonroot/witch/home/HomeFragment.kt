package net.lemonroot.witch.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import net.lemonroot.witch.R
import net.lemonroot.witch.activities.TitleActivity
import net.lemonroot.witch.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false)

        binding.btnSignout.setOnClickListener { v: View ->
            signOut()
        }
        navController = findNavController()

        return binding.root
    }

    private fun signOut() {
        // [START auth_fui_signout]
        AuthUI.getInstance()
            .signOut(requireActivity())
            .addOnCompleteListener {
                // ...
            }
        Toast.makeText(activity, "Signed out.", Toast.LENGTH_SHORT).show()
        val switchActivityIntent = Intent(context, TitleActivity::class.java)
        startActivity(switchActivityIntent)
        // [END auth_fui_signout]
    }
}