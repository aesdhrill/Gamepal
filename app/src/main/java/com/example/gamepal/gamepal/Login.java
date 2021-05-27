package com.example.gamepal.gamepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gamepal.gamepal.ui.main.GridListFragment;
import com.example.gamepal.gamepal.ui.main.LoginFragment;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.LoginSignupView, LoginFragment.newInstance())
                    .commitNow();
        }


    }

}