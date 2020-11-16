package com.imran.android.languagepreference;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView languageTextView;
    private String keyLanguage;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageTextView = findViewById(R.id.languageTextView);
        sharedPreferences = this.getSharedPreferences("com.imran.android.languagepreference", Context.MODE_PRIVATE);

        String savedLanguage = sharedPreferences.getString(keyLanguage, "Not Found");

        if(savedLanguage.equals("Not Found")) {
            new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setTitle("Choose a language")
                .setMessage("Which language would you like to use")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Set English
                        setLanguage("English");
                    }
                })
                .setNegativeButton("Bengali", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Set Bengali
                        setLanguage("Bengali");
                    }
                })
                .show();
        } else {
            setLanguage(savedLanguage);
        }


    }

    public void setLanguage(String language) {
        sharedPreferences.edit().putString(keyLanguage, language).apply();
        languageTextView.setText(language);
    }
}