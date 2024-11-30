package com.example.edutech

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

data class User(val email: String, val firstName: String, val lastName: String, val password: String)

class FirebaseHelper {
    private val database: DatabaseReference = FirebaseDatabase.getInstance("https://edutech-dd1c8-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("users")

    fun saveUser(user: User) {
        val userId = database.push().key // Generate a unique ID for each user
        userId?.let {
            database.child(it).setValue(user)
        }
    }
}
