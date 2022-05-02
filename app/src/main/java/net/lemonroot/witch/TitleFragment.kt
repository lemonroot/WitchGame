package net.lemonroot.witch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import net.lemonroot.witch.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater, R.layout.fragment_title, container, false)

        binding.btnStart.setOnClickListener {v: View ->
            v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToHomeFragment())
        }

        return binding.root
    }
}