package com.example.gamepal.gamepal.ui.main;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamepal.gamepal.Login;
import com.example.gamepal.gamepal.R;

//TODO: Fix after LoginFragment works;

public class SignupFragment extends Fragment {
    Button logIn;
    TextView ChangeFragment;

    private MainViewModel mViewModel;

    public static SignupFragment newInstance() {
        return new SignupFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View thisView = inflater.inflate(R.layout.signup_fragment, container, false);
        logIn = thisView.findViewById(R.id.buttonLogin);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Button was clicked",Toast.LENGTH_SHORT).show();
            }
        });

        ChangeFragment = thisView.findViewById(R.id.LoginSignup); //this is null?
        try{
            ChangeFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Login)getActivity()).switchFragments(); //maybe works?
                }
            });
        }catch(Exception e){
            Log.e("errorListener","error setting onclick (signup): "+e);
        }
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