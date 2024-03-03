package com.example.finalmsptask4.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun adduser(user:User)

    @Query("Select * FROM Users Order BY id ASC")
     fun readalldata():LiveData<List<User>>


}