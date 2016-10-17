import java.awt.*;

/**
 * Created by blackwidow on 6/10/16.
 * @author Xisco Cambil Reynes
 * Clase Circulo la cual hereda de la clase area. Esta clase es utilizada para obtener los datos
 * y pintar la forma en el lienzo. La clase Circulo implementa las dos interfazes PintarFormaGrafico y Relleno.
 * Esta clase es utulizada en todos las formas para definir el punto de partida dentro del lienzo. Por ello todas
 * las clases que hereden de forma heredaran un atributo de tipo Punto.
 *
 */
public class Punto extends Forma{
    private int x,y;

    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param g
     * utilizacion del medodo fillOval() para pintar el punto en el lienzo.
     */
    @Override
    public void pintarForma(Graphics g) {
        g.setColor(getColor());
        g.fillOval(x,y,5,5);
    }
}
