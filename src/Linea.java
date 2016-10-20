import java.awt.*;
import java.util.Map;

/**
 * Created by blackwidow on 6/10/16.
 * @author Xisco Cambil Reynes
 * Clase Linea la cual hereda de la clase Forma. Esta clase es utilizada para obtener los datos
 * y pintar la forma en el lienzo. La clase implementa la interfaz PintarFormaGrafico.
 */
public class Linea extends Forma implements PintarFormaGrafica{

    /**
     * se añade un segundo punto para obtener las cordenadas de x2 y y2(segundo punto donde pintar);
     */
    private Punto punto2;

    public Linea(Punto punto1,Punto punto2,Color color){
        setColor(color);
        setPunto(punto1);
        this.punto2 = punto2;
    }

    public Linea(){}

    @Override
    public void fillAttributes(Map<String,Object> map) {
        super.fillAttributes(map);
        punto2 = new Punto((Integer) map.get("x2"),(Integer) map.get("y2"));
    }

    /**
     *
     * @param g Lienzo grafico donde se va a pintar las figuras;
     * Utilizacion del metodo drawLine para pintar una Linea en el lienzo.
     */
    @Override
    public void pintarForma(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getPunto().getX(),getPunto().getY(),punto2.getX(),punto2.getY());

    }
}
