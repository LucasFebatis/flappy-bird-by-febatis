package com.febatis.flappyexemplo.game.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.febatis.flappyexemplo.game.engine.Som;
import com.febatis.flappyexemplo.game.graphic.Cores;

public class Pontuacao {

    private static final Paint BRANCA = Cores.getCorPontuacao();
    private int pontos = 0;

    private Som som;

    public Pontuacao(Som som) {
        this.som = som;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCA);
    }

    public void aumentar() {
        som.toca(som.getPontos());
        pontos++;
    }
}
