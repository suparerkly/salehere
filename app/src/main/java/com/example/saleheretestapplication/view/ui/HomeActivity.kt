package com.example.saleheretestapplication.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.saleheretestapplication.R
import com.example.saleheretestapplication.databinding.ActivityHomeScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment

    private var socket: Socket? = null

    private val viewBinding: ActivityHomeScreenBinding by lazy {
        ActivityHomeScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initControl()
        initEvent()
        initSocket()
    }

    private fun initEvent() {
        viewBinding.bottomNavigationView.setOnNavigationItemSelectedListener { page ->
            when (page.itemId) {
                R.id.homeScreen -> navController.navigate(R.id.homeFragment)
                R.id.achievementScreen -> navController.navigate(R.id.achievementFragment)
                R.id.accountScreen -> sendSocket()
            }
            true
        }

    }

    private fun initControl() {
        bottomNavigation = findViewById(R.id.bottomNavigationView)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(
            bottomNavigation, navController
        )
    }

    private fun initSocket(){
        try {
            socket = IO.socket("https://px-socket-emitter.saleherethailand.com")
            socket?.connect()
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }

    private fun sendSocket(){
        socket?.emit("new-notification","Hello")
    }
}