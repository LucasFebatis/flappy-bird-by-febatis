package com.febatis.flappyexemplo.game.elements;

import android.app.Activity;
import android.graphics.Canvas;

import com.febatis.flappyexemplo.game.engine.Som;
import com.febatis.flappyexemplo.game.graphic.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Canos {

    private final List<Cano> canos = new ArrayList<>();
    private static final int DISTANCIA_ENTRE_CANOS = 200;
    private static final int QTD_CANOS = 5;
    private final Tela tela;
    private Pontuacao pontuacao;
    private Activity activity;

    public Canos(Tela tela, Pontuacao pontuacao, Activity activity, Som som) {
        this.tela = tela;
        this.pontuacao = pontuacao;
        this.activity = activity;
        int posicao = 400;
        for (int i = 0; i < QTD_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao, activity);
            canos.add(cano);
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano: canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void mover() {
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()) {
            Cano cano = iterator.next();
            cano.move();
            if(cano.saiuTela()) {
                pontuacao.aumentar();
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, activity);
                iterator.add(outroCano);
            }
        }
    }

    private int getMaximo() {
        int maximo = 0;
        for (Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean existeColisao(Passaro passaro, Som som) {
        for (Cano cano : canos) {
            if(cano.isColididoHorizontal(passaro) && cano.isColididoVertical(passaro)) {
                som.toca(som.getColisao());
                return true;
            }
        }
        return false;
    }
}
