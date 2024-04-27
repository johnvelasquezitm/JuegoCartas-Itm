package juegocartas;

import java.util.Random;
import javax.swing.*;

public class Carta {

    private int indice;

    public int getIndice() {
        return indice;
    }
    
    //metodo constructor
    public Carta(Random r) {
        //generar el indice de la carta de manera aleatoria
        indice = r.nextInt(52) + 1;
    }

    public Pinta getPinta() {
        //devolver la pinta que corresponde al indice de la carta
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

    public NombreCarta getNombre() {
        int numero = indice % 13;
        if (numero == 0) {
            numero = 13;
        }
        return NombreCarta.values()[numero - 1];
    }

    public void mostrar(JPanel pnl, int x, int y) {

        //obtener el nombre del archivo de la carta
        String nombreImagen = "/imagenes/CARTA" + String.valueOf(indice) + ".jpg";

        //cargar la imagen
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));

        //Instanciar el objeto JLABEL que mostrará la carta
        JLabel lbl = new JLabel(imagen);

        //definir las coordenadas y dimensión de la imagen
        lbl.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());

        //mostrar la carta en el objeto PANEL de despliegue
        pnl.add(lbl);

    }

}
