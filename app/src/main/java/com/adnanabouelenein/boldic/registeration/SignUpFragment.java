package com.adnanabouelenein.boldic.registeration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.adnanabouelenein.boldic.CreateAccount;
import com.adnanabouelenein.boldic.R;

public class SignUpFragment extends Fragment {
    private View view;
    private EditText emailEditText, passwordEditText;
    private Button signUpButton;


    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        emailEditText = view.findViewById(R.id.email_edit_text_sign_up_fragment);
        passwordEditText = view.findViewById(R.id.password_edit_text_sign_up_fragment);

        signUpButton = view.findViewById(R.id.sign_up_button);

        createAccount();
        return view;
    }

    private void createAccount() {
        CreateAccount createAccount = new CreateAccount();
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Log.d("EMAIL", email);
                Log.d("PASSWORD", password);
                createAccount.createUsernameAndPassword(email, password, getActivity());
            }
        });
    }
}