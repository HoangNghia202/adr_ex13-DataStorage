package com.example.ex12_datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView email;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public  static  final String MyPreference = "myrefs";
    public static  final String Name = "nameKey";
    public static  final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);

        sharedPreferences = getSharedPreferences(MyPreference, MODE_PRIVATE);
        if (sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email, ""));
        }
    }

    public  void Save( View view){
        String n = name.getText().toString();
        String e = email.getText().toString();

        editor = sharedPreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }

    public  void Get (View view){
        name= findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);

//        Get from shared references. show in views
        sharedPreferences= getSharedPreferences(MyPreference, MODE_PRIVATE);
        if (sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name, ""));
        }

        if (sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email, ""));
        }

    }

    public  void clear( View view){
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        name.setText("");
        email.setText("");
    }

    public  void delete (View view){
       editor.clear();
       editor.commit();
       name.setText("");
         email.setText("");
    }
}

