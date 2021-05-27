package com.example.gamepal.gamepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.gamepal.gamepal.ui.main.GridListFragment;
import com.example.gamepal.gamepal.ui.main.ListViewFragment;

import java.util.Arrays;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private static final String PREFERENCES= "globalValues";
    public SharedPreferences.Editor editor;
    SharedPreferences globalVarsStore;
    private final boolean LayoutTypeGrid=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

//        globalVarsStore=getSharedPreferences(PREFERENCES,Context.MODE_PRIVATE);
//      if (!(globalVarsStore.contains("firstRunDone"))){
//            editor.putBoolean("LayoutTypeGrid",false); //grid, list
//            editor.putBoolean("firstRunDone",true);
//            editor.putStringSet("validLanguages",new HashSet<>(Arrays.asList("English","Spanish","Portuguese","German","Polish")));
//            editor.putStringSet("validEmails", new HashSet<String>(Arrays.asList("dupadupa@ua.pt","ablachnicki@ua.pt","aiaiminato@gmail.com")));
//            editor.putStringSet("validPasswords", new HashSet<String>(Arrays.asList("UAjestFajne","Szyfr12345","3GLepszeOdLTE")));
//            editor.apply();
//        }

        if (savedInstanceState == null) {
            if(LayoutTypeGrid){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_grid, GridListFragment.newInstance())
                        .commitNow();
            }
            else{
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_grid, ListViewFragment.newInstance())
                        .commitNow();
            }
        }
    }


}