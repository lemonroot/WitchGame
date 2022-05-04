package net.lemonroot.witch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import net.lemonroot.witch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        navController = findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        binding.topToolbar.setupWithNavController(navController, appBarConfiguration)


        //val navController = this.findNavController(R.id.myNavHostFragment)
        //NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)
        //NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}