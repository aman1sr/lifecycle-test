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
import com.aman.lifecycletest.databinding.FragmentTest3Binding

class TestFragment3 : Fragment() {
    lateinit var transactionType: String
    lateinit var binding: FragmentTest3Binding

    companion object {
        private val ARG_PARAM1 = "ARG_PARAM1"

        @JvmStatic
        fun newInstance(param1: String) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
       Log.wtf(TAG, "Frg3 onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            transactionType = it.getString(ARG_PARAM1)!!
        }
        Log.wtf(TAG, "Frg3 onCreate: ", )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTest3Binding.inflate(inflater, container, false)
        Log.wtf(TAG, "Frg3 onCreateView: ", )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       Log.wtf(TAG, "Frg2 onViewCreated: ")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       Log.wtf(TAG, "Frg2 onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
       Log.wtf(TAG, "Frg2 onStart: ")
    }

    override fun onResume() {
        super.onResume()
       Log.wtf(TAG, "Frg2 onResume: ")
    }

    override fun onPause() {
        super.onPause()
       Log.wtf(TAG, "Frg2 onPause: ")
    }

//    override fun onRestart() {
//        super.onRestart()
//        Log.v(TAG, " onRestart: ")
//    }

    override fun onStop() {
        super.onStop()
       Log.wtf(TAG, "Frg2 onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
       Log.wtf(TAG, "Frg2 onDestroy: ")
    }

    override fun onDestroy() {
        super.onDestroy()
       Log.wtf(TAG, "Frg2 onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
       Log.wtf(TAG, "Frg2 onDetach: ")
    }

}