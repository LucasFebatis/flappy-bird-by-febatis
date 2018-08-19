package com.febatis.flappyexemplo.game.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

public class Cores {
    public static Paint getCorPassaro() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return  paint;
    }

    public static Paint getCorCano() {
        Paint paint = new Paint();
        paint.setColor(0xFF00FF00);
        return  paint;
    }

    public static Paint getCorPontuacao() {
        Paint paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5,0xFF000000);
        return  paint;
    }

    public static Paint getCorDoGameOver() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        vermelho.setTextSize(50);
        vermelho.setTypeface(Typeface.DEFAULT_BOLD);
        vermelho.setShadowLayer(2, 3, 3, 0xFF000000);
        return vermelho;
    }
}
