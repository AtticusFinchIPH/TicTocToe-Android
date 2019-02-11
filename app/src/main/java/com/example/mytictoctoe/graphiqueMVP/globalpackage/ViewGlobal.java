package com.example.mytictoctoe.graphiqueMVP.globalpackage;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mytictoctoe.MainActivity;
import com.example.mytictoctoe.R;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.ViewGrid;

public class ViewGlobal extends LinearLayout implements IViewGlobal, View.OnClickListener {

    private PresentationGlobal presGlobal;

    private MainActivity activity;

    private View racine;
    private TextView textView;
    private ViewGrid viewGrid;
    private Button playButton;

    private static char player;

    public ViewGlobal(Context context){
        super(context);

        initGlobal(context);
    }

    public ViewGlobal(Context context, @Nullable AttributeSet attributeSet){
        super(context, attributeSet);

        initGlobal(context);
    }

    public ViewGlobal(Context context, @Nullable AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);

        initGlobal(context);
    }

    public void setPresGlobal(PresentationGlobal presGlobal) {
        this.presGlobal = presGlobal;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        presGlobal.pressButton();
        playButton.setActivated(false);
    }

    @Override
    public void notifSwitchPlayer() {
        player = presGlobal.getModel().getCurrentplayer();
        textView.setText(player + "'s turn");
    }

    @Override
    public void notifEndGame() {
        // set textView
        playButton.setActivated(true);
        playButton.setText("Play");
    }

    public void initGlobal(Context context){
        racine = inflate(context, R.layout.view_global, this);

        textView = findViewById(R.id.textview);
        viewGrid = findViewById(R.id.viewgrid);
        playButton = findViewById(R.id.playbutton);

        textView.setText("Click Play Button to Start");
        playButton.setActivated(true);
        playButton.setText("Play");
        playButton.setOnClickListener(this);
    }

}
