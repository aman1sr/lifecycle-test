package com.aman.lifecycletest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.aman.lifecycletest.activitylifecycle.MainActivity2
import com.aman.lifecycletest.databinding.ActivityBaseBinding
import com.aman.lifecycletest.fragmentlifecycle.TestFragment
import com.aman.lifecycletest.fragmentlifecycle.TestFragment2


class BaseActivity : AppCompatActivity() {
    lateinit var binding: ActivityBaseBinding

    companion object{
        val INTENT_TAG = "SCREEN_NAME"
        fun getIntent(context: Context,screenType: String): Intent {
            return Intent(context,BaseActivity::class.java).apply {
                putExtra(INTENT_TAG,screenType)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        Log.d(TAG, "Activity1 onCreate: ")
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val screenType : String? = intent.getStringExtra(BaseActivity.INTENT_TAG)
/*
* Behavior:
* The add method adds the fragment to the specified container, preserving any existing fragments. The newly added fragment will coexist with any other fragments already in the container.
* The replace method removes any existing fragments in the specified container and then adds the new fragment. This ensures that only one fragment is displayed in the container at any time.
* */
        when (screenType) {
            MainActivity.ScreenType.FRAGMENTADD.screentype -> {
                // todo: remove a section in top bar-> Add btn ->  to add more Frg into  -> check Lifecycle
                addFragment(TestFragment.newInstance("add"))
                Toast.makeText(this, "Fragment Added", Toast.LENGTH_SHORT).show()
            }
            MainActivity.ScreenType.FRAGMENTREPLACE.screentype -> {
                replaceFragment(TestFragment.newInstance("replace"))
                Toast.makeText(this, "Fragment Replaced", Toast.LENGTH_SHORT).show()
            }
            MainActivity.ScreenType.ACTIVITY.screentype -> {
               binding.llActivityLayout.visibility = View.VISIBLE
            }
        }

        binding.btnOpenActivity.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity1 onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity1 onResume: ")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Activity1 onPause: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Activity1 onRestart: ")
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity1 onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity1 onDestroy: ")
    }

    fun addFragment(frg: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.main, frg)
            .addToBackStack(null) // Optional: to add the transaction to the back stack
            .commit()
    }

    fun replaceFragment(frg: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, frg)
            .addToBackStack(null)
            .commit()
    }
}