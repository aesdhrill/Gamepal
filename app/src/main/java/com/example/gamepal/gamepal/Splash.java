package com.example.gamepal.gamepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread bgThread=new Thread(){
                public void run(){
                        try{
                                sleep(3*1000);
                                Intent i = new Intent(getBaseContext(),MainActivity.class);
                                startActivity(i);
                                finish();
                        }catch(Exception e){
                        }
                }
        };
        bgThread.start();
    }
}