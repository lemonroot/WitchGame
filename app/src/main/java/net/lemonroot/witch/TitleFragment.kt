package net.lemonroot.witch

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import net.lemonroot.witch.databinding.FragmentAuthenticationBinding
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
            navController.navigate(R.id.homeFragment)
        } else {
            Toast.makeText(activity, "Please sign in.", Toast.LENGTH_SHORT).show()
            navController.navigate(R.id.authentication)
        }
    }
}
