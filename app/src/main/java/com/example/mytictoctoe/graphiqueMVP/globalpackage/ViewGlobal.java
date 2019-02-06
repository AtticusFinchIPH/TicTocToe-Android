package com.example.mytictoctoe.graphiqueMVP.globalpackage;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mytictoctoe.MainActivity;
import com.example.mytictoctoe.R;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.ViewGrid;

public class ViewGlobal extends LinearLayout implements IViewGlobal {

    private PresentationGlobal presGlobal;

    private MainActivity activity;

    private View racine;
    private TextView textView;
    private ViewGrid viewGrid;
    private Button playButton;

    public ViewGlobal(Context context){
        super(context);

        initGlobal(context);
    }

    public void setPresGlobal(PresentationGlobal presGlobal) {
        this.presGlobal = presGlobal;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void notifStartGame() {

    }

    public void initGlobal(Context context){
        racine = inflate(context, R.layout.view_global, this);

        textView = findViewById(R.id.textview);
        viewGrid = findViewById(R.id.viewgrid);
        playButton = findViewById(R.id.playbutton);
    }
}
