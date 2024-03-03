package com.example.finalmsptask4.fragments

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalmsptask4.R
import com.example.finalmsptask4.data.UserController
import com.example.finalmsptask4.data.UserDatabase
import com.example.finalmsptask4.databinding.FragmentLoginfragment2Binding


class loginfragment2 : Fragment() {
    private var binding: FragmentLoginfragment2Binding? = null
    private val _binding get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        val binding = FragmentLoginfragment2Binding.inflate(inflater, container, false)
        val view=binding.root
        val usersDatabase: UserDatabase by lazy {
            UserDatabase.getdatabase(requireContext())
        }
        val userController: UserController by lazy {
            UserController(usersDatabase.userDao())
        }
        val sharedprefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedprefs.edit()

        val registerbutton =binding.registerbutton
        registerbutton.setOnClickListener{
            val username = binding.usernameregisterText.text.toString()
            val email= binding.emailregisterText.text.toString()
            val phonenumber = binding.phoneregisterText.text.toString()
            editor.apply{
                putString("username",username.toString())
                putString("email",email.toString())
                putString("phone",phonenumber.toString())
                apply()
                Toast.makeText(requireContext(),"registered succesfully",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginfragment2_to_userslistfragment)
            }

        }
    return view
    }

}