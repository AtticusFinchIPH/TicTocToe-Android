package com.example.mytictoctoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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

        Log.d("Geste", "Dans OnCreate");

        gameEngine = new GameEngine();
        viewGlobal = this.findViewById(R.id.view_global);
        presGlobal = new PresentationGlobal();
        presGlobal.setView(viewGlobal);
        presGlobal.setGameEngine(gameEngine);
        viewGlobal.setPresGlobal(presGlobal);
        viewGlobal.setActivity(this);
    }
}
