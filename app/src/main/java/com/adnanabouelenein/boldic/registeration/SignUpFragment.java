package com.adnanabouelenein.boldic.registeration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adnanabouelenein.boldic.data.Callable;
import com.adnanabouelenein.boldic.data.CreateAccountFirebase;
import com.adnanabouelenein.boldic.data.CreateAccountModel;
import com.adnanabouelenein.boldic.R;
import com.adnanabouelenein.boldic.data.SendUserDataToAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpFragment extends Fragment {

    private View view;
    private EditText emailEditText, passwordEditText, nameEditText, phoneNumberEditText;
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
        nameEditText = view.findViewById(R.id.name);
        phoneNumberEditText = view.findViewById(R.id.phone);

        signUpButton = view.findViewById(R.id.sign_up_button);
        createAccount();

        return view;
    }

    private void createAccount() {

        signUpButton.setOnClickListener(v -> {

            String name = nameEditText.getText().toString().trim();
            String phone = phoneNumberEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                SendUserDataToAPI sendUserDataToAPI = new SendUserDataToAPI();
                sendUserDataToAPI.sendData(name, phone, email, password, getActivity());

                CreateAccountFirebase createAccountFirebase = new CreateAccountFirebase();
                createAccountFirebase.createUsernameAndPassword(email, password, getActivity());
            }else
                Toast.makeText(getActivity(), "Check name, email, password or phone validation.", Toast.LENGTH_LONG).show();
        });
    }


}