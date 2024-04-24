package com.example.fillballoader;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class MainActivity extends AppCompatActivity {
    // Variables Declared
    CircularFillableLoaders circularFillableLoaders;
    SeekBar seekBar;

    int progress = 80;

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

        // Code for implementing Circular Fallible Loader
        circularFillableLoaders = (CircularFillableLoaders) findViewById(R.id.circularFillableLoaders);

        // Set Progress
        circularFillableLoaders.setProgress(progress);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(progress);
        seekBar.setMax(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Set Progress
                circularFillableLoaders.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}