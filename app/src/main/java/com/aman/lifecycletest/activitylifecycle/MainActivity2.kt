package com.aman.lifecycletest.activitylifecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aman.lifecycletest.R
import com.aman.lifecycletest.TAG

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.v(TAG, "Activity2 onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "Activity2 onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "Activity2 onResume: ")

    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "Activity2 onPause: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "Activity2 onRestart: ")
    }


    override fun onStop() {
        super.onStop()
        Log.v(TAG, "Activity2 onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "Activity2 onDestroy: ")
    }

}