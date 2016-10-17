import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Se generan 3 variables estaticas, la lista de formas, el frame principal donde ira el menu del programa y
     * un segundo frame donde se cargar los lienzo creados con la clase Graphics
     */
    public static final List<Forma> listaFormas = new ArrayList<>();
    public static PanelPrincipal pp;
    public static JFrame friendLienzo;
    public static void main(String[] args) {
        pp = new PanelPrincipal();
        final Lienzo lienzo = new Lienzo();
        /**
         * Esta clase nos permite iniciar un segundo proceso en pararalelo y conseguir asi
         * una programacion concurrente.
         */
        Runnable guiThread = new Runnable() {
            public void run() {
                //Create and set up the window.
                friendLienzo = new JFrame("Lienzo");
                friendLienzo.setSize(500,500);
                friendLienzo.setContentPane(lienzo);
                friendLienzo.getContentPane().setVisible(true);
                friendLienzo.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        friendLienzo.setContentPane(lienzo);
                    }
                });
            }
        };

        /**
         * Una vez teminado el metodo run(), debemos de iniciar nuestro proceso hijo.
         */
        try {
            SwingUtilities.invokeAndWait(guiThread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}