package com.adnanabouelenein.boldic.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.adnanabouelenein.boldic.R
import com.adnanabouelenein.boldic.data.CurrentUser

class WelcomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val login = view.findViewById<Button>(R.id.login_btn_welcome_fragment)
        login.setOnClickListener { v -> Navigation.findNavController(v).
        navigate(R.id.action_welcomeFragment_to_loginFragment) }

        val signUp = view.findViewById<Button>(R.id.sign_up_btn_welcome_fragment)
        signUp.setOnClickListener { v -> Navigation.findNavController(v).
        navigate(R.id.action_welcomeFragment_to_signUpFragment) }
        return view
    }

    override fun onStart() {
        super.onStart()
        CurrentUser.checkIfUserIsLoggedIn(view, R.id.action_welcomeFragment_to_homeFragment)

    }


}