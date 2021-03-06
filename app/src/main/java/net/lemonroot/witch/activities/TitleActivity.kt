package net.lemonroot.witch.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import net.lemonroot.witch.databinding.ActivityTitleBinding


class TitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navController: NavController =
            Navigation.findNavController(this, net.lemonroot.witch.R.id.nav_host_fragment)
    }
}