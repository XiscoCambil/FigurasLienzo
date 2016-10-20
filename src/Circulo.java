import java.awt.*;
import java.util.Map;

/**
 * Created by blackwidow on 6/10/16.
 * @author Xisco Cambil Reynes
 * Clase Circulo la cual hereda de la clase area. Esta clase es utilizada para obtener los datos
 * y pintar la forma en el lienzo. La clase Circulo implementa las dos interfazes PintarFormaGrafico y Relleno.
 */
public class Circulo extends Area{

    public Circulo(Punto punto, int radio, Color color, boolean respuesta) {
        setColor(color);
        setWidth(radio);
        setHeight(radio);
        setRellenar(respuesta);
        setPunto(punto);
    }

    public Circulo(){}



    /**
     *
     * @param g
     * metodo utilizado para pintar la forma grafica en el lienzo.
     */
    @Override
    public void pintarForma(Graphics g) {
        Rellenar(isRellenar(),g);
    }

    @Override
    public void fillAttributes(Map<String,Object> map) {
        super.fillAttributes(map);
        setWidth((Integer) map.get("radio"));
        setHeight((Integer) map.get("radio"));
        setRellenar((Boolean) map.get("rellenar"));
    }

    /**
     * @param hayRelleno
     * @param g
     * Este metodo heredado de la interfaz Rellenar tiene un condicional para saber si el usuario
     * a decidio si la figura se debe de pintar por dentro o solo su contorno. utlizacion de los metodos
     * fillOval para lo el relleno y drawOval para pintar el contorno.
     */

    @Override
    public void Rellenar(boolean hayRelleno, Graphics g) {
        g.setColor(getColor());
        if (isRellenar()) {
            g.fillOval(getPunto().getX(), getPunto().getY(), getWidth(), getHeight());
        } else {
            g.drawOval(getPunto().getX(), getPunto().getY(), getWidth(), getHeight());
        }
    }

}
