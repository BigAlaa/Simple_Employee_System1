package com.example.finalmsptask4.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavDirections

import android.widget.TextView
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.finalmsptask4.R
import com.example.finalmsptask4.data.User
import com.example.finalmsptask4.data.UserController
import com.example.finalmsptask4.data.UserDatabase
import com.example.finalmsptask4.fragments.userslistfragment
import kotlin.coroutines.coroutineContext

class ListAdapter :RecyclerView.Adapter<ListAdapter.MyViewHolder>(){
    private var userlist= ArrayList<User>()
    lateinit var onclicked:Onclicked


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customrecyclerview,parent,false))
    }

    override fun getItemCount(): Int {
    return userlist.size
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var person:User=userlist.get(position)

        holder.bind(person)

    }

    fun setData(user: List<User>){
        this.userlist= user as ArrayList<User>
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {



        var Username: TextView =itemView.findViewById(R.id.usernamerec)
        var Email: TextView =itemView.findViewById(R.id.emailrec)
        var Phonenumber: TextView =itemView.findViewById(R.id.phonerec)
        var ID: TextView =itemView.findViewById(R.id.idrec)


        fun bind(user: User){

            ID.text = user.id.toString() // Use the user parameter directly
            Username.text = user.username
            Email.text = user.email
            Phonenumber.text = user.phonenumber

            itemView.setOnClickListener {

                onclicked.OnClicked(user)
            }

        }
    }
}