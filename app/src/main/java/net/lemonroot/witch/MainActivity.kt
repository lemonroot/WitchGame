package net.lemonroot.witch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import net.lemonroot.witch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAppBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        barSetup()
        navSetup()
    }

    // Setup navigation graph
    private fun navSetup() {
        var navigationView: NavigationView = binding.navView

        var navController: NavController =
            Navigation.findNavController(this, R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration)
        NavigationUI.setupWithNavController(navigationView, navController)
    }

    // Setup toolbar & navigation drawer
    private fun barSetup() {
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        var drawer: DrawerLayout = binding.drawerLayout
        mAppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.titleFragment, R.id.homeFragment
            ),
            binding.drawerLayout
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        var navController: NavController = Navigation.findNavController(this, R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp()
    }
}