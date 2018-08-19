package com.febatis.flappyexemplo.game.engine;

import com.febatis.flappyexemplo.game.elements.Canos;
import com.febatis.flappyexemplo.game.elements.Passaro;

public class VerificadorColisao {

    Passaro passaro;
    Canos canos;

    public VerificadorColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean isColidido(Som som) {

        return canos.existeColisao(passaro, som);
    }
}
