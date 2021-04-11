package com.adnanabouelenein.boldic.data;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SendEmailVerification {
    
    public void sendEmailToVerify(Context context){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Check your email to verify", Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(context, "Check your connection", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
