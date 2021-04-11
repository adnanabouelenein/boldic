package com.adnanabouelenein.boldic.data;

import android.view.View;

import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CurrentUser {

    public static void checkIfUserIsLoggedIn(View view, int direction) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Navigation.findNavController(view).navigate(direction);
        }
    }
}
