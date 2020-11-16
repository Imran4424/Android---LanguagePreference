package com.imran.android.languagepreference;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView languageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageTextView = findViewById(R.id.languageTextView);

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
    }

    public void setLanguage(String language) {
        languageTextView.setText(language);
    }
}