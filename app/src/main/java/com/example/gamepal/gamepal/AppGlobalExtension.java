package com.example.gamepal.gamepal;

import android.app.Application;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppGlobalExtension extends Application {
    public static String testString = "Shithole";
    final static public Set<String> languagesAvailable=new HashSet<>(Arrays.asList("English","Spanish","Portuguese","German","Polish"));

    public static HashMap<String, String> loginData = new HashMap<String, String>(){{
        put("dupadupa@ua.pt", "UAjestFajne");
        put("ablachnicki@ua.pt", "wsadwsad12");
    }};

    public void addToLogin(String email, String pwd){
        if (!loginData.containsKey(email)){
            loginData.put(email,pwd);
        }else{
            Toast.makeText(this,"User already exists!",Toast.LENGTH_LONG).show();
        }
    }

    public static boolean checkLoginValidity(String email, String pwd){
        if(loginData.containsKey(email)){
            Object value = loginData.get(email);// (pwd)
            if (value.equals(pwd)) return true;
        }
        return false;
    }

    public static HashMap<String, String> getLoginData(){
        return loginData;
    }

    protected void hideKeyboard(View view){
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private static AppGlobalExtension singleton;

    public static AppGlobalExtension getInstance(){
        return singleton;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        singleton=this;
    }
}
