package net.lemonroot.witch.activities

import android.R.attr.radius
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import net.lemonroot.witch.R
import net.lemonroot.witch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAppBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("firing main activity")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        barSetup()
        navSetup()
    }

    // Setup toolbar & navigation drawer
    private fun barSetup() {
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        mAppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.titleFragment, R.id.homeFragment
            ),
            binding.drawerLayout
        )
    }

    // Setup navigation graph
    private fun navSetup() {
        var navigationView: NavigationView = binding.navView
        val navViewBackground = navigationView.background as MaterialShapeDrawable
        navViewBackground.shapeAppearanceModel = navViewBackground.shapeAppearanceModel
            .toBuilder()
            .setTopRightCorner(CornerFamily.ROUNDED, radius.toFloat())
            .setBottomRightCorner(CornerFamily.ROUNDED, radius.toFloat())
            .build()

        var navController: NavController =
            Navigation.findNavController(this, R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration)
        NavigationUI.setupWithNavController(navigationView, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the top action bar
        menuInflater.inflate(R.menu.top_bar_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        // Supports up button
        var navController: NavController = Navigation.findNavController(this,
            R.id.myNavHostFragment
        )
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp()
    }
}