import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase LienzoHistorial creada para albergar el Jpanel donde se va a pintar el historial de figuras.
 */
public class LienzoHistorial extends Lienzo {

    /**
     * @param g
     * El metodo paint hace un for del tamaño de la lista de formas, llamando al metodo pintarForma de cada
     * uno de ellos.
     */
    public void paint (Graphics g) {
        Main.friendLienzo.setTitle("Lienzo historial");
            for (int i = 0; i < Main.listaFormas.size() ; i++) {
                setForma(Main.listaFormas.get(i));
                getForma().pintarForma(g);
            }
        }
    }

