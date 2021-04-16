package com.adnanabouelenein.boldic.registeration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.adnanabouelenein.boldic.R
import com.adnanabouelenein.boldic.data.SendPasswordResetEmail

class ForgotPasswordFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_forgot_password, container, false)

        val sendPasswordResetEmail = SendPasswordResetEmail()
        val emailEditText = view.findViewById<EditText>(R.id.email_edit_text)
        val resetButton = view.findViewById<Button>(R.id.reset_button)

        resetButton.setOnClickListener { v: View? ->
            val email = emailEditText.text.toString()
            sendPasswordResetEmail.resetPassword(email, activity)
            emailEditText.setText("")
        }
        return view
    }
}