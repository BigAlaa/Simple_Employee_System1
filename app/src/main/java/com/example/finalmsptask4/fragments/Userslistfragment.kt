package com.example.finalmsptask4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalmsptask4.R
import com.example.finalmsptask4.adapter.ListAdapter
import com.example.finalmsptask4.adapter.Onclicked
import com.example.finalmsptask4.data.User
import com.example.finalmsptask4.data.UserController
import com.example.finalmsptask4.data.UserDatabase
import com.example.finalmsptask4.databinding.FragmentUserslistfragmentBinding


class userslistfragment : Fragment(),Onclicked {
    private var binding: FragmentUserslistfragmentBinding? = null
    private val _binding get() = binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        val binding = FragmentUserslistfragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val floatingActionButton = binding.FloatingActionButton


        val usersDatabase: UserDatabase by lazy {
            UserDatabase.getdatabase(requireContext())
        }
        val userController: UserController by lazy {
            UserController(usersDatabase.userDao())
        }
        val adapter =ListAdapter()
        val recyclerView =binding.recyclerView
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        adapter.onclicked=this

        userController.usersList.observe(viewLifecycleOwner,Observer{user -> adapter.setData(user)})

        floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_userslistfragment_to_adduserfragment)
        }

        return view
    }

    override fun OnClicked(user: User) {
        findNavController().navigate(R.id.action_userslistfragment_to_update_deletefragment)

    }

}