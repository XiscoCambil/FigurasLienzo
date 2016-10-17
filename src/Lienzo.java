import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.Lock;

/**
 * Clase Lienzo creada para albergar el Jpanel donde se van a pintar las figuras.
 */
public class Lienzo extends JPanel{
    private JPanel lienzo;
    private Forma forma;

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    /**
     *
     * @param g
     * Metodo utilizado para pintar las formas dentro del lienzo graphico. Primero se llama al metodo
     * del padre paint, y luego se utilizar los metodos pintarForma de los objetos de tipo Forma, los cuales
     * llevan los datos y metodos necesarios para pintar la forma especifica.
     */
    public void paint (Graphics g)
    {
        super.paint(g);
        forma = Main.listaFormas.get(Main.listaFormas.size()-1);
        forma.pintarForma(g);
    }
}
