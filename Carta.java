package juegocartas;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carta {

    private int indice;

    public int getIndice() {
        return indice;
    }
    
    
    public Carta(Random r) {
        
        indice = r.nextInt(52) + 1;
    }

    public void mostrar(JPanel pnl, int x, int y) {
        String nombreArchivo = "/imagenes/CARTA" + String.valueOf(indice) + ".jpg";

        
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreArchivo));

        JLabel lbl = new JLabel(imagen);
        lbl.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());
        pnl.add(lbl);
    }

    public Pinta obtenerPinta() {
        if (indice <= 13) {
            return Pinta.TREBOL;
        } else if (indice <= 26) {
            return Pinta.PICA;
        } else if (indice <= 39) {
            return Pinta.CORAZON;
        } else {
            return Pinta.DIAMANTE;
        }
    }

    public NombreCarta ObtenerNombre() {
        int residuo = indice % 13;
        if (residuo == 0) {
            residuo = 13;
        }
        return NombreCarta.values()[residuo - 1];
    }
    
    public int ObtenerValor(){
        return 0;
    }

}
