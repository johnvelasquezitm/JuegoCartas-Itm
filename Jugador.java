package juegocartas;

import java.util.*;
import javax.swing.JPanel;

public class Jugador {

    private int TOTAL_CARTAS = 10;
    private int DISTANCIA = 40;
    private int MARGEN = 5;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r = new Random();

    public void repartir() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        for (int i = 0; i < cartas.length; i++) {
            cartas[i].mostrar(pnl, MARGEN + TOTAL_CARTAS * DISTANCIA - i * DISTANCIA, MARGEN);
        }
        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No hay grupos";
        int[] contadores = new int[NombreCarta.values().length];

        for (int i = 0; i < cartas.length; i++) {
            contadores[cartas[i].getNombre().ordinal()]++;
        }
        

        int totalGrupos = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                totalGrupos++;
            }
        }
        if (totalGrupos > 0) {
            mensaje = "Los grupos encontrados fueron:\n";
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] >= 2) {
                    mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                }
            }
        }
        
        int totGrupos = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] == 1) {
                totGrupos++;
            }
        }
        if (totGrupos > 0) {
            mensaje += "\n";
            mensaje += "Tu puntaje fue: ";
            int acumulador = 0;
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] == 1) {
                    if(NombreCarta.values()[i] == NombreCarta.AS){
                        acumulador += 10;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.JACK){
                        acumulador += 10;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.QUEEN){
                        acumulador += 10;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.KING){
                        acumulador += 10;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.DOS){
                        acumulador += 2;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.TRES){
                        acumulador += 3;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.CUATRO){
                        acumulador += 4;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.CINCO){
                        acumulador += 5;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.SEIS){
                        acumulador += 6;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.SIETE){
                        acumulador += 7;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.OCHO){
                        acumulador += 8;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.NUEVE){
                        acumulador += 9;
                    }
                    else if(NombreCarta.values()[i] == NombreCarta.DIEZ){
                        acumulador += 10;
                    }
                }
            }
            mensaje += acumulador + "\n";
        }
        return mensaje;
    }
    
    public void ordenar(){
        
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length; j++){
                if(cartas[i].getIndice() > cartas[j].getIndice()){
                    Carta ct = cartas[i];
                    cartas[i] = cartas[j];
                    cartas[j] = ct;
                }
            }
        }
        
    }
}
