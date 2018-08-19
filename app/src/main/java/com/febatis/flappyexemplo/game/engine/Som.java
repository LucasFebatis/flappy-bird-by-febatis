package com.febatis.flappyexemplo.game.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.febatis.flappyexemplo.R;


public class Som {

    private final int pulo;
    private final int pontos;
    private final int colisao;
    private SoundPool soundPool;

    public Som(Context context) {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        pulo = soundPool.load(context, R.raw.pulo, 1);
        pontos = soundPool.load(context, R.raw.pontos, 1);
        colisao = soundPool.load(context, R.raw.colisao, 1);
    }

    public void toca(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }

    public int getPulo() {
        return pulo;
    }

    public int getPontos() {
        return pontos;
    }

    public int getColisao() {
        return colisao;
    }
}
