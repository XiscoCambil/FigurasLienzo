import java.awt.*;

/**
 * Created by blackwidow on 6/10/16.
 */
/**
 * Created by blackwidow on 6/10/16.
 * @author Xisco Cambil Reynes
 * Clase Poligono la cual hereda de la clase Forma. Esta clase es utilizada para obtener los datos
 * y pintar la forma en el lienzo. La clase Poligono implementa las dos interfazes PintarFormaGrafico y Relleno.
 */
public class Poligono extends Forma implements Relleno {

    private int[] varX = new int[3];
    private int[] varY = new int[3];
    private int nPuntas;
    private boolean rellenar;

    /**
     *
     * @param p1
     * @param p2
     * @param p3
     * @param puntas
     * @param color
     * @param rellenar
     * Con este constructor solo se puden generar poligonos de 3 puntas, si se deseara hacer poligonos de mas puntas
     * habria que crear tantos puntos de X y Y como numero de puntas tenga nuestro poligono.
     */
    public Poligono(Punto p1, Punto p2, Punto p3, int puntas, Color color, boolean rellenar) {
        varX[0] = p1.getX();
        varX[1] = p2.getX();
        varX[2] = p3.getX();
        varY[0] = p1.getY();
        varY[1] = p2.getY();
        varY[2] = p3.getY();
        nPuntas = puntas;
        setColor(color);
        this.rellenar = rellenar;
    }

    /**
     *
     * @param g
     * metodo utilizado para pintar la forma grafica en el lienzo.
     */
    @Override
    public void pintarForma(Graphics g) {
       Rellenar(rellenar,g);
    }

    /**
     *
     * @param hayRelleno
     * @param g
     * Este metodo heredado de la interfaz Rellenar tiene un condicional para saber si el usuario
     * a decidio si la figura se debe de pintar por dentro o solo su contorno. Utilizacion de los metodos
     * fillPolygon para pintar relleno y drawPolygon para pintar el controno.
     */
    @Override
    public void Rellenar(boolean hayRelleno, Graphics g) {
        g.setColor(getColor());
        if (rellenar) {
            g.fillPolygon(varX, varY, nPuntas);
        } else {
            g.drawPolygon(varX, varY, nPuntas);
        }

    }
}
