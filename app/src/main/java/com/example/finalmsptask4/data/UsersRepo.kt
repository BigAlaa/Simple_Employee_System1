package com.example.finalmsptask4.data
import androidx.lifecycle.LiveData

class UsersRepo(private val userDao: UserDao) {
    val readalldata: LiveData<List<User>> =userDao.readalldata()
    fun adduser(user :User){
        userDao.adduser(user)
    }



}