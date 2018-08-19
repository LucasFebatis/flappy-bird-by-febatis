package com.febatis.flappyexemplo.game.engine;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.febatis.flappyexemplo.R;
import com.febatis.flappyexemplo.activity.MainActivity;
import com.febatis.flappyexemplo.game.elements.GameOver;
import com.febatis.flappyexemplo.game.elements.Canos;
import com.febatis.flappyexemplo.game.elements.Passaro;
import com.febatis.flappyexemplo.game.elements.Pontuacao;
import com.febatis.flappyexemplo.game.graphic.Tela;

public class GameView extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();

    Passaro passaro;
    Pontuacao pontuacao;
    Canos canos;
    Bitmap fundo;
    Tela tela;
    Som som;
    GameOver gameOver;
    private MainActivity activity;

    public GameView(MainActivity activity) {
        super(activity);
        tela = new Tela(activity);
        som = new Som(activity);
        this.activity = activity;
        inicializarElementos();

        setOnTouchListener(this);
    }

    private void inicializarElementos() {
        passaro = new Passaro(tela, activity, som);
        pontuacao = new Pontuacao(som);
        canos = new Canos(tela, pontuacao, activity, som);
        gameOver = new GameOver(tela);

        Bitmap fundo = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.fundo = Bitmap.createScaledBitmap(fundo, fundo.getWidth(), tela.getAltura(), false);

    }

    @Override
    public void run() {
        while (isRunning) {
            if(!holder.getSurface().isValid()) continue;

            //Renderização do jogo
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(fundo, 0, 0, null);
            passaro.desenhaNo(canvas);
            passaro.cair();

            canos.desenhaNo(canvas);
            canos.mover();

            pontuacao.desenhaNo(canvas);

            if(new VerificadorColisao(passaro, canos).isColidido(som)) {
                gameOver.desenhaNo(canvas);
                isRunning = false;
            }

            //Atualiza a View
            holder.unlockCanvasAndPost(canvas);

        }
    }

    public void iniciar() {
        isRunning = true;
    }

    public void pausar() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(!gameOver.isShow()) {
            passaro.pular();
        } else {
            activity.iniciarGame();
        }
        return false;
    }
}
