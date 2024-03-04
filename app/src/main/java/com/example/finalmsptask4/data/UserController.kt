package com.example.finalmsptask4.data

import androidx.lifecycle.LiveData

class UserController(userDao: UserDao){
    private val usersRepo = UsersRepo(userDao)
      var usersList:LiveData<List<User>>

    fun adduser(user:User){
    usersRepo.adduser(user)
    }
    fun deleteuser(user: User){
        usersRepo.deleteuser(user)
    }

    init {
       usersList=usersRepo.readalldata

   }

}