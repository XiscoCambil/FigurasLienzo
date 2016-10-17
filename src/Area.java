import java.awt.*;

/**
 *
 * Created by blackwidow on 11/10/16.
 * @author Xisco Cambil Reynes.
 * Clase abstracta creada para ser una plantilla de las formas cuadrada, circular y rectangular, dichas
 * formas utilizan los atributos especificados dentro de esta clase para la definicion de su tamaño, implementa
 * la interfaz Relleno que controla que las figuras puedan estar pintadas por dentro.
 */
public abstract class Area extends Forma implements Relleno{


    private int width, height;
    private boolean rellenar = false;

    public boolean isRellenar() {
        return rellenar;
    }

    public void setRellenar(boolean rellenar) {
        this.rellenar = rellenar;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {this.height = height;}

}
