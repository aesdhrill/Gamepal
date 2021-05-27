package com.example.gamepal.gamepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread bgThread=new Thread(){
                public void run(){
                        try{
                                sleep(3*1000);
                                Intent i = new Intent(getBaseContext(),Login.class);
                                startActivity(i);
                                finish();
                        }catch(Exception e){
                            Log.e("Error thrown","Error has been thrown:"+e.toString());
                        }
                }
        };
        bgThread.start();
    }
}