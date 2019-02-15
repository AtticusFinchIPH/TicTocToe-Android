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
import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.ViewGrid;

public class ViewGlobal extends LinearLayout implements IViewGlobal, View.OnClickListener {

    private PresentationGlobal presGlobal;

    private MainActivity activity;

    private View racine;
    private TextView textView;
    private ViewGrid viewGrid;
    private PresentationGrid presGrid;
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
        player = presGlobal.getPresGrid().getModelGrid().getCurrentCharacter();
        textView.setText(player + "'s turn");
    }

    @Override
    public void notifEndGame() {
        textView.setText(presGlobal.getPresGrid().getModelGrid().getRecentCharacter()
                        + "is the winner!");
        playButton.setActivated(true);
        playButton.setText("Play");
        /*
        TODO
        The following line may cause problem. Not sure.
        */
        playButton.setOnClickListener(this);
    }

    public void initGlobal(Context context){
        racine = inflate(context, R.layout.view_global, this);

        textView = racine.findViewById(R.id.textView);
        viewGrid = racine.findViewById(R.id.viewgrid);
        presGrid = new PresentationGrid();
        viewGrid.setPresGrid(presGrid);
        presGrid.setViewGrid(viewGrid);
        playButton = racine.findViewById(R.id.button);

        presGrid.subscribeToGlobal(presGlobal);
        presGlobal.subscribeToGrid(presGrid);

        textView.setText("Click Play Button to Start Game");
        playButton.setActivated(true);
        playButton.setText("Play");
        playButton.setOnClickListener(this);
    }
}
