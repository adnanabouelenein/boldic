package com.adnanabouelenein.boldic.data

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SendPasswordResetEmail : AppCompatActivity() {
    var auth = FirebaseAuth.getInstance()

    fun resetPassword(email: String?, context: Context?) {

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context,
                                "Check Your Email to Reset Your Password",
                                Toast.LENGTH_LONG).show()
                    }else
                        Toast.makeText(context,
                                "Check Your Connection Or Your Email",
                                Toast.LENGTH_LONG).show()
                }
    }
}