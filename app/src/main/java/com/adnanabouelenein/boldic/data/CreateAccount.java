package com.adnanabouelenein.boldic.data;


import android.content.Context;
import android.util.Log;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.adnanabouelenein.boldic.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccount extends AppCompatActivity {
    public final void createUsernameAndPassword(String email, String password, Context context) {

        if (!email.isEmpty() && !password.isEmpty()) {
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(context,
                                        "We sent a verification link to your email",
                                        Toast.LENGTH_SHORT).show();

                                SendEmailVerification sendEmailVerification = new SendEmailVerification();
                                sendEmailVerification.sendEmailToVerify(context);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(context,
                                        "Failed check your connection or email",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(context, R.string.email_password_empty, Toast.LENGTH_SHORT).show();
        }
    }


}
