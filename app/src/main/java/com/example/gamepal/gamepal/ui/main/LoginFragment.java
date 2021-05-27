package com.example.gamepal.gamepal.ui.main;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamepal.gamepal.AppGlobalExtension;
import com.example.gamepal.gamepal.Login;
import com.example.gamepal.gamepal.MainActivity;
import com.example.gamepal.gamepal.R;

public class LoginFragment extends Fragment {
    Button logIn;
    Button ChangeFragment;
    AppCompatImageView showPW;
    EditText email;
    EditText password;
    private MainViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }
    public FragmentTransaction ft;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View thisView = inflater.inflate(R.layout.login_fragment, container, false);
        logIn = thisView.findViewById(R.id.buttonLogin);
        showPW = thisView.findViewById(R.id.button_showPW);
        email = thisView.findViewById(R.id.inputEmailEditText);
        password = thisView.findViewById(R.id.inputPasswordEditText);
        ChangeFragment = thisView.findViewById(R.id.SignUpLogin);




        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String emailStr = email.getText().toString();
                    String passwordStr = password.getText().toString();
                    if(AppGlobalExtension.checkLoginValidity(emailStr,passwordStr)){
                        Toast.makeText(getContext(), "Successfully logged in!", Toast.LENGTH_SHORT).show();
                        try{
                            ((Login)getActivity()).switchActivity(); //maybe works?
                        }catch(Exception e){
                            Toast.makeText(getContext(),"Error: " + e.toString(),Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getContext(), "Failed to log in,\ncheck email/password!", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getContext(),"Error: " + e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

        ChangeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Login)getActivity()).switchFragments(); //maybe works?
            }
        });
        showPW.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_HOVER_EXIT:
                    case MotionEvent.ACTION_CANCEL:
                        thisView.performClick();
                        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        return true;
                    case MotionEvent.ACTION_UP:
                        password.setInputType(129);
                        return true;
                }
                return false;
            }
        });

        return thisView;
    }
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        }
*/
}