package com.aman.lifecycletest.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aman.lifecycletest.R
import com.aman.lifecycletest.TAG
import com.aman.lifecycletest.databinding.FragmentTest2Binding
import com.aman.lifecycletest.databinding.FragmentTestBinding


class TestFragment2 : Fragment() {
    lateinit var transactionType: String
    lateinit var binding: FragmentTest2Binding

    companion object {
        private val ARG_PARAM1 = "ARG_PARAM1"

        @JvmStatic
        fun newInstance(param1: String) =
            TestFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.w(TAG, "Frg2 onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            transactionType = it.getString(ARG_PARAM1)!!
        }
        Log.w(TAG, "Frg2 onCreate: TYPE: ${transactionType}")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.w(TAG, "Frg2 onCreateView: ")
        binding = FragmentTest2Binding.inflate(inflater, container, false)

        binding.btnFrg.text = "${transactionType.toUpperCase()} Fragment"

        binding.btnFrg.setOnClickListener {
            if (transactionType == "add") {
                parentFragmentManager.beginTransaction()
                    .add(R.id.main, TestFragment3())
                    .addToBackStack(null)  // Optional: Add to back stack
                    .commit()

            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, TestFragment3())
                    .addToBackStack(null)  // Optional: Add to back stack
                    .commit()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w(TAG, "Frg2 onViewCreated: ")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.w(TAG, "Frg2 onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.w(TAG, "Frg2 onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG, "Frg2 onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG, "Frg2 onPause: ")
    }

//    override fun onRestart() {
//        super.onRestart()
//        Log.v(TAG, " onRestart: ")
//    }

    override fun onStop() {
        super.onStop()
        Log.w(TAG, "Frg2 onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w(TAG, "Frg2 onDestroy: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(TAG, "Frg2 onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.w(TAG, "Frg2 onDetach: ")
    }
}