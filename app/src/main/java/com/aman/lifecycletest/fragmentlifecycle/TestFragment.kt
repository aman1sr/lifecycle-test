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
import com.aman.lifecycletest.databinding.FragmentTestBinding
import com.aman.lifecycletest.utils.Utils


class TestFragment : Fragment() {
    lateinit var transactionType: String
    lateinit var binding: FragmentTestBinding

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
        Log.i(TAG, "Frg onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            transactionType = it.getString(ARG_PARAM1)!!
        }
        Log.i(TAG, "Frg onCreate: ")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTestBinding.inflate(inflater, container, false)

        Log.i(TAG, "Frg onCreateView: TYPE: ${transactionType}")

        binding.btnFrg.text = "${transactionType.toUpperCase()} Fragment"

        binding.btnFrg.setOnClickListener {
            if (transactionType == "add") {
//                Utils.addFragmentToParentFrg(parentFragment = TestFragment(),
//                    destinationFrg =  TestFragment2.newInstance(transactionType),R.id.main)

                parentFragmentManager.beginTransaction()
                    .add(R.id.main, TestFragment2.newInstance("add"))
                    .addToBackStack(null)  // Optional: Add to back stack
                    .commit()

            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, TestFragment2.newInstance("replace"))
                    .addToBackStack(null)  // Optional: Add to back stack
                    .commit()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "Frg onViewCreated: ")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "Frg onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Frg onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Frg onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Frg onPause: ")
    }

//    override fun onRestart() {
//        super.onRestart()
//        Log.v(TAG, " onRestart: ")
//    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Frg onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "Frg onDestroy: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Frg onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "Frg onDetach: ")
    }
}