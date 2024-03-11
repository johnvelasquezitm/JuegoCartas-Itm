package juegocartas;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JPanel;

public class Jugador {

    private int TOTAL_CARTAS = 10;
    private int MARGEN_SUPERIOR = 10;
    private int MARGEN_IZQUIERDA = 10;
    private int DISTANCIA = 50;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r;

    public Jugador() {
        r = new Random();
    }

    public void repartir() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        //for (int i = 0; i < cartas.length; i++) {

        int x = MARGEN_IZQUIERDA;
        for (Carta c : cartas) {
            //cartas[i].mostrar(pnl, 10, 5);
            c.mostrar(pnl, x, MARGEN_SUPERIOR);
            x += DISTANCIA;
        }
        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No se encontraron grupos";
        if (cartas[0] != null) {

            int[] contadores = new int[NombreCarta.values().length];

            for (Carta c : cartas) {
                contadores[c.ObtenerNombre().ordinal()]++;
            }

            int totalGrupos = 0;
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] > 1) {
                    totalGrupos++;
                }
            }

            if (totalGrupos > 0) {
                mensaje = "Los grupos encontrador fueron:\n";
                for (int i = 0; i < contadores.length; i++) {
                    if (contadores[i] > 1) {
                        mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                    }
                }
            }
        } else {
            mensaje = "No se han repartido cartas";
        }
        return mensaje;
    }

    public String getsecuencias() {
        String msj = "No se encontraron escaleras";
        if (cartas[0] != null) {
            int cont[] = new int[cartas.length];
            for (Carta c : cartas) {
                cont[c.obtenerPinta().ordinal()]++;
            }

            List<String> escaleras = new ArrayList<>();

            for (int i = 0; i < cont.length; i++) {
                if (cont[i] > 0) {
                    List<Carta> sequence = new ArrayList<>();
                    for (Carta ct : cartas) {
                        if (ct.obtenerPinta() == Pinta.values()[i]) {
                            sequence.add(ct);
                        }
                    }

                    sequence.sort(Comparator.comparing(Carta::ObtenerNombre));

                    for (int j = 0; j < sequence.size(); j++) {
                        for (int groupSize = 3; groupSize <= 10; groupSize++) {
                            if (j + groupSize - 1 >= sequence.size()) {
                                break;
                            }
                            boolean encontrado = true;
                            for (int k = 1; k < groupSize; k++) {
                                if (sequence.get(j).ObtenerNombre().ordinal() + k != sequence.get(j + k).ObtenerNombre().ordinal()) {
                                    encontrado = false;
                                    break;
                                }
                            }
                            if (encontrado) {
                                StringBuilder sb = new StringBuilder();
                                switch (groupSize) {
                                    case 3:
                                        sb.append("Terna de ");
                                        break;
                                    case 4:
                                        sb.append("Cuarta de ");
                                        break;
                                    case 5:
                                        sb.append("Quinta de ");
                                        break;
                                    case 6:
                                        sb.append("Sexta de ");
                                        break;
                                    case 7:
                                        sb.append("Séptima de ");
                                        break;
                                    case 8:
                                        sb.append("Octava de ");
                                        break;
                                    case 9:
                                        sb.append("Novena de ");
                                        break;
                                    case 10:
                                        sb.append("Décima de ");
                                }

                                sb.append(Pinta.values()[i]);
                                escaleras.add(sb.toString());
                            }
                        }
                    }
                }
            }
            if (!escaleras.isEmpty()) {
                msj = String.join(", ", escaleras);
            }
        }

        return msj;
    }

    public String getpuntaje() {
        String msj = "";
        int puntaje=0;
        
        if (cartas[0] != null) {
            int cont[] = new int[cartas.length];
            for (Carta c : cartas) {
            puntaje+=c.ObtenerValor();
            }
            
        } else {
            msj = "No se han repartido cartas";
        }
        return msj;
    }

}
