import java.awt.*;

/**
 * Created by blackwidow on 11/10/16.
 * @author Xisco Cambil Reynes
 * Interfaz Relleno creada para controlar y obligar a las clases que le implementenm,
 * tener un metodo que decidiara si la figura debe ir rellenada o no.
 */

public interface Relleno {
    /**
     * @param hayRelleno
     * @param g
     * como parametro se necesita un boleano para decidir si pintar o no rellenado y
     * la variable de tipo Graphics donde se plasmara el dibujo.
     */
    void Rellenar(boolean hayRelleno, Graphics g);
}
