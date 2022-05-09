package net.lemonroot.witch.title

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import net.lemonroot.witch.activities.MainActivity
import net.lemonroot.witch.R
import net.lemonroot.witch.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater, R.layout.fragment_title, container, false
        )
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener { checkAuth() }
    }

    // Check if user is signed in. If not, redirect to AuthenticationFragment.
    private fun checkAuth() {
        val navController = findNavController()
        val user = Firebase.auth.currentUser
        if (user != null) {
            Toast.makeText(activity, "Welcome back, " + user.uid, Toast.LENGTH_SHORT).show()

            val switchActivityIntent = Intent(context, MainActivity::class.java)
            startActivity(switchActivityIntent)
        } else {
            Toast.makeText(activity, "Please sign in.", Toast.LENGTH_SHORT).show()
            navController.navigate(R.id.action_titleFragment_to_authentication)
        }
    }
}
