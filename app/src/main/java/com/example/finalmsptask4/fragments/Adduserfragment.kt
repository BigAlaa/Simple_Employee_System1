package com.example.finalmsptask4.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalmsptask4.R
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalmsptask4.data.User
import com.example.finalmsptask4.data.UserController
import com.example.finalmsptask4.data.UserDatabase
import com.example.finalmsptask4.databinding.FragmentAdduserfragmentBinding



class adduserfragment : Fragment() {

    private var binding: FragmentAdduserfragmentBinding? = null
    private val _binding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View{

        val usersDatabase: UserDatabase by lazy {
            UserDatabase.getdatabase(requireContext())
        }
         val userController: UserController by lazy {
            UserController(usersDatabase.userDao())
        }
        val binding = FragmentAdduserfragmentBinding.inflate(inflater, container, false)
        val view =binding.root
        val addbtn = binding.addButton
         addbtn.setOnClickListener{
             fun insertdatatodatabase( userController: UserController ) {
                 val username = binding.usernameText.text.toString()
                 val email= binding.emailText.text.toString()
                 val phonenumber = binding.phonenumberText.text.toString()
                 if (inputcheck(username,email,phonenumber))
                 { val user = User(0,username,email,phonenumber)
                     userController.adduser(user)
                     Toast.makeText(requireContext(),"succesfully added",Toast.LENGTH_LONG).show()
                     findNavController().navigate(R.id.action_adduserfragment1_to_userslistfragment)
                 }
                 else
                 {
                     Toast.makeText(requireContext(),"please fill all fields",Toast.LENGTH_LONG).show()
                 }
             }
           insertdatatodatabase( userController)
         }
        return view
    }


    private fun inputcheck(firstname: String,email :String , phonenumber :String): Boolean{
        return !(TextUtils.isEmpty(firstname) &&TextUtils.isEmpty(email) && TextUtils.isEmpty(phonenumber)  )
    }

}