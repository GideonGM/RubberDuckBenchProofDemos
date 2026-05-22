package com.example.javatest;
import android.util.Log;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.res.Configuration;


public class MainActivity extends AppCompatActivity {

    private int orientation = Configuration.ORIENTATION_UNDEFINED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d("MyTag", "Orientation before:");
        Log.d("MyTag", String.valueOf(orientation));
        if (orientation != newConfig.orientation) {
            orientation = newConfig.orientation;
        }
        //The fact that the orientation changes before and after
        //the global variable is called shows both the necessity
        //of updating newConfig after any type of view change,
        //not just orientation, as well as the redundancy
        //of the global variable.
        Log.d("MyTag", "Orientation after:");
        Log.d("MyTag", String.valueOf(orientation));
        configureForOrientation(orientation, newConfig);
    }

    private void configureForOrientation(int orientation, Configuration newConfig) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            newConfig.orientation = Configuration.ORIENTATION_PORTRAIT;
            Log.d("MyTag", "Set to vertical.");
        } else {
            newConfig.orientation = Configuration.ORIENTATION_LANDSCAPE;
            Log.d("MyTag", "Set to horizontal.");
        }
    }
}