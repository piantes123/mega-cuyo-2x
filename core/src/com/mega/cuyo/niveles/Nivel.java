package com.mega.cuyo.niveles;

public interface Nivel {
    
    void pintarNivel();
    void cargarNivel();
    void actualizarElementos();
    Nivel siguienteNivel();
    boolean finalizaNivel();
    

}
