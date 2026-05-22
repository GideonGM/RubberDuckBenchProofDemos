package com.example.java10test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static Context context;
    public static final String DUMMY_VALUE = "DUMMY_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        Intent startingIntent = new Intent(context, MainActivity.class);
        //Define "DUMMY_VALUE string"
        startingIntent.putExtra(MainActivity.DUMMY_VALUE,"DUMMY_VALUE");
        Log.d("MyTag", "Printing added string with name \"DUMMY_VALUE\":");
        Log.d("MyTag", Objects.requireNonNull(startingIntent.getStringExtra("DUMMY_VALUE")));
        //Redefine "DUMMY_VALUE" string
        startingIntent.putExtra(MainActivity.DUMMY_VALUE,MainActivity.DUMMY_VALUE);
        Log.d("MyTag", "Printing added string with name MainActivity.DUMMY_VALUE:");
        Log.d("MyTag", Objects.requireNonNull(startingIntent.getStringExtra("DUMMY_VALUE")));
        //Both values are equal, so "DUMMY_VALUE" can be used in place of MainActivity.DUMMY_VALUE

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}