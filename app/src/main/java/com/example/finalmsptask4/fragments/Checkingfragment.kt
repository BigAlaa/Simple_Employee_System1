package com.example.finalmsptask4.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalmsptask4.R
import com.example.finalmsptask4.databinding.FragmentLoginfragment2Binding



class checkingfragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val SPLASH_DELAY: Long = 2000 // 2 seconds

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_checkingfragment, container, false)
        val sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireActivity())
        val handler:Handler= Handler(Looper.getMainLooper())
        val username =sharedPref.getString("username",null)
        val email= sharedPref.getString("email",null)
        val phonenumber = sharedPref.getString("phone",null)


        handler.postDelayed({
            if (username!=null && email!=null && phonenumber != null) {

                findNavController().navigate(R.id.action_checkingfragment_to_userslistfragment)
            }
            else
                findNavController().navigate(R.id.action_checkingfragment_to_loginfragment2)

                            },SPLASH_DELAY)

        return view
    }


}