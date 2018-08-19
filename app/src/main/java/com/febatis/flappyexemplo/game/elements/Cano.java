package com.febatis.flappyexemplo.game.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.febatis.flappyexemplo.R;
import com.febatis.flappyexemplo.game.graphic.Cores;
import com.febatis.flappyexemplo.game.graphic.Tela;

public class Cano {

    private static final Paint VERDE = Cores.getCorCano();
    private final int alturaCanoInferior;
    private final int alturaCanoSuperior;
    private int posicao;
    private Tela tela;
    private static  final int TAMANHO_CANO = 250;
    private static  final int LARGURA_CANO = 100;

    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.posicao = posicao;
        alturaCanoInferior = tela.getAltura() - TAMANHO_CANO - valorAleatorio();
        alturaCanoSuperior = TAMANHO_CANO + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_CANO, alturaCanoInferior, false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_CANO, alturaCanoSuperior, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferior(canvas);
        desenhaCanosuperior(canvas);
    }

    private  void desenhaCanoInferior(Canvas canvas) {
        //canvas.drawRect(posicao, alturaCanoInferior, posicao + LARGURA_CANO, tela.getAltura(), VERDE);
        canvas.drawBitmap(canoInferior, posicao, alturaCanoInferior, null);
    }

    private  void desenhaCanosuperior(Canvas canvas) {
        //canvas.drawRect(posicao, 0, posicao + LARGURA_CANO, alturaCanoSuperior, VERDE);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    public void move() {
        this.posicao -= 5;
    }

    public boolean saiuTela() {
        return posicao + LARGURA_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean isColididoHorizontal(Passaro passaro) {
        return this.posicao < passaro.X + passaro.RAIO;
    }

    public boolean isColididoVertical(Passaro passaro) {
        return passaro.getY() - passaro.RAIO < this.alturaCanoSuperior
                || passaro.getY() + passaro.RAIO > this.alturaCanoInferior;
    }
}
