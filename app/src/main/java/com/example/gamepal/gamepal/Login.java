package com.example.gamepal.gamepal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.gamepal.gamepal.ui.main.GridListFragment;
import com.example.gamepal.gamepal.ui.main.LoginFragment;
import com.example.gamepal.gamepal.ui.main.SignupFragment;

public class Login extends AppCompatActivity{
    public boolean loginOrSignup=true;


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


    public void switchFragments(){
        FragmentManager fm = getSupportFragmentManager();
        if (loginOrSignup) {
            fm.beginTransaction().replace(R.id.LoginSignupView, SignupFragment.newInstance()).commitNow();
        }else{
            fm.beginTransaction().replace(R.id.LoginSignupView, LoginFragment.newInstance()).commitNow();
        }
        loginOrSignup=!loginOrSignup;
        Log.d("current state","loginOrSignup(true is login, false is signup):" + loginOrSignup);
    }

    public void switchActivity(){
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

}