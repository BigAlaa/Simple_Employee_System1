package com.example.finalmsptask4.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.example.finalmsptask4.R
import com.example.finalmsptask4.data.UserController
import com.example.finalmsptask4.data.UserDatabase
import com.example.finalmsptask4.databinding.FragmentAdduserfragmentBinding
import com.example.finalmsptask4.databinding.FragmentUpdateDeletefragmentBinding


class update_deletefragment : Fragment() {
    private var binding: FragmentUpdateDeletefragmentBinding? = null
    private val _binding get() = binding!!
        private val args by navArgs<update_deletefragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentUpdateDeletefragmentBinding.inflate(inflater, container, false)
        val view =binding.root
        val usersDatabase: UserDatabase by lazy {
            UserDatabase.getdatabase(requireContext())
        }
        val userController: UserController by lazy {
            UserController(usersDatabase.userDao())
        }
        binding.FloatingDeleteButton.setOnClickListener{
            userController.deleteuser(args.currentUser)
            Toast.makeText(requireContext(),"succesfully removed",Toast.LENGTH_SHORT).show()
        }
        binding.id.setText(args.currentUser.id.toString())
        binding.username.setText(args.currentUser.username)
        binding.email.setText(args.currentUser.email.toString())
        binding.phone.setText(args.currentUser.phonenumber.toString())

        return view
    }


}