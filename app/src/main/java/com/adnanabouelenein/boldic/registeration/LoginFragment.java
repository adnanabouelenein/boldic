package com.adnanabouelenein.boldic.registeration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.adnanabouelenein.boldic.MainActivity;
import com.adnanabouelenein.boldic.OnBoardingActivity;
import com.adnanabouelenein.boldic.R;
import com.adnanabouelenein.boldic.SplashActivity;

public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    private Button login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        TextView welcomeText = view.findViewById(R.id.welcome_text_login_fragment);

        login = view.findViewById(R.id.login_btn_login_fragment);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_homeFragment);
            }
        });

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_login_first_started),
                false);
        if (!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_login_first_started), Boolean.TRUE);
            edit.commit();
            welcomeText.setText("Welcome");

        } else {

            welcomeText.setText("Welcome back");
        }
        return view;

    }
}