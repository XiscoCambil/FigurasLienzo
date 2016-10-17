import javax.swing.*;
import java.awt.*;

/**
 * Created by blackwidow on 6/10/16.
 * @author Xisco Cambil Reynes.
 * Clase Texto la cual hereda de la clase area. Esta clase es utilizada para obtener los datos
 * y pintar la forma en el lienzo. La clase Circulo implementa la interfaz PintarFormaGrafico.
 */
public class Texto extends Forma{

    private String texto;

    public Texto(String texto,Punto punto,Color color){
        this.texto = texto;
        setPunto(punto);
        setColor(color);
    }

    public String getTexto() {
        return texto;
    }

    /**
     * @param g
     * metodo utilizado para pintar la forma grafica en el lienzo.
     * Utiliza el metodo drawString para pintar el texto.
     *
     */
    @Override
    public void pintarForma(Graphics g) {
        g.setColor(getColor());
        g.drawString(getTexto(),getPunto().getX(),getPunto().getY());

    }
}
