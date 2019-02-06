package com.example.mytictoctoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.PresentationGlobal;
import com.example.mytictoctoe.graphiqueMVP.globalpackage.ViewGlobal;
import com.example.mytictoctoe.noyaufonction.GameEngine;

public class MainActivity extends AppCompatActivity {

    private ViewGlobal viewGlobal;
    private PresentationGlobal presGlobal;

    private GameEngine gameEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewGlobal = findViewById(R.id.viewglobal);
    }
}
