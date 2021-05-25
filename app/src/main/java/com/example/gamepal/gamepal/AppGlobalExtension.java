package com.example.gamepal.gamepal;

import android.app.Application;
import android.util.Pair;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppGlobalExtension extends Application {

    final private Set<String> languagesAvailable=new HashSet<>(Arrays.asList("English","Spanish","Portuguese","German","Polish"));

    private HashMap<String, String> loginData = new HashMap<String, String>(){{
        put("dupadupa@ua.pt", "UAjestFajne");
        put("ablachnicki@ua.pt", "wsadwsad12");
    }};

    public void addToLogin(String email, String pwd){
        if (!this.loginData.containsKey(email)){
            this.loginData.put(email,pwd);
        }else{
            Toast.makeText(getApplicationContext(),"User already exists!",Toast.LENGTH_LONG);
        }
    }

    public boolean checkLoginValidity(String email, String pwd){
        if(this.loginData.containsKey(email)){
            Object value = loginData.get(email);// (pwd)
            if (value.equals(pwd)) return true;
        }
        return false;
    }

}
