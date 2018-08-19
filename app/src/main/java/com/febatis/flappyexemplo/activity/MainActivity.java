package com.febatis.flappyexemplo.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.febatis.flappyexemplo.R;
import com.febatis.flappyexemplo.broadcast.GameBroadcast;
import com.febatis.flappyexemplo.game.engine.GameView;

public class MainActivity extends Activity {

    GameView gameView;

    GameBroadcast gameBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = new GameView(this);

        FrameLayout container = findViewById(R.id.container);
        container.addView(gameView);

    }

    public void enviarBroadcast() {
        Intent in = new Intent("gameBroadcast");
        sendBroadcast(in);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.iniciar();
        new Thread(gameView).start();
    }

    public void iniciarGame() {
        gameView = new GameView(this);
        gameView.iniciar();

        FrameLayout container = findViewById(R.id.container);
        container.removeAllViews();
        container.addView(gameView);

        new Thread(gameView).start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        gameView.pausar();
    }
}
