package com.example.finalmsptask4.data


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val username: String?,
    @ColumnInfo
    val email: String,
    @ColumnInfo
    val phonenumber: String,
)
