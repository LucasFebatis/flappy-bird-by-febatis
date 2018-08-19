package com.febatis.flappyexemplo.game.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.febatis.flappyexemplo.R;
import com.febatis.flappyexemplo.game.engine.Som;
import com.febatis.flappyexemplo.game.graphic.Cores;
import com.febatis.flappyexemplo.game.graphic.Tela;

public class Passaro {

    public static final float X = 100;
    public static final int RAIO = 50;
    private static final Paint COLOR_VERMELHA = Cores.getCorPassaro();
    private final Bitmap passaro;

    public float getY() {
        return Y;
    }

    private float Y;
    private Tela tela;
    private Som som;

    public Passaro(Tela tela, Context context, Som som) {
        this.tela = tela;
        this.Y = 100;
        this.som = som;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
    }

    public void desenhaNo(Canvas canvas) {
        //canvas.drawCircle(X, Y, RAIO, COLOR_VERMELHA);
        canvas.drawBitmap(passaro, X - RAIO, Y - RAIO, null);
    }

    public void cair() {
        boolean isChao = (Y + RAIO) > tela.getAltura();
        if(!isChao) {
            this.Y += 5;
        }
    }

    public void pular() {
        boolean isTopo = (Y - RAIO) < 0;
        if(!isTopo) {
            som.toca(som.getPulo());
            Y -= 150;
        }
    }
}
