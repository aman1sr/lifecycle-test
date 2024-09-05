package com.aman.lifecycletest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.aman.lifecycletest.activitylifecycle.MainActivity2
import com.aman.lifecycletest.databinding.ActivityMainBinding
import com.aman.lifecycletest.fragmentlifecycle.TestFragment
import com.aman.lifecycletest.fragmentlifecycle.TestFragment2
const val TAG = "LifeCycle_d"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


   enum class ScreenType(val screentype: String){
        FRAGMENTADD("FRAGMENT1_ADD_SCREEN"),
        FRAGMENTREPLACE("FRAGMENT1_REPLACE_SCREEN"),
        ACTIVITY("ACTIVITY_SCREEN"),
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnFrgAdd.setOnClickListener {
            startActivity(BaseActivity.getIntent(this,ScreenType.FRAGMENTADD.screentype))
        }
        binding.btnFrgReplace.setOnClickListener {
            startActivity(BaseActivity.getIntent(this,ScreenType.FRAGMENTREPLACE.screentype))
        }
        binding.btnActivity.setOnClickListener {
            startActivity(BaseActivity.getIntent(this,ScreenType.ACTIVITY.screentype))
        }
    }


}