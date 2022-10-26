package com.ak87.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ak87.newsapp.databinding.ActivityMainBinding
import com.ak87.newsapp.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.http.Header

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mbinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.fragment_splash)
        Handler(Looper.myLooper()!!).postDelayed({
            setContentView(mbinding.root)
            bottom_nav_menu.setupWithNavController(
                navController = nav_host_fragment.findNavController()
            )
        }, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}