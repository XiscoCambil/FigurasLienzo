import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

/**
 * Clase PanelPincipal creada para albergar el jpanel de nuestro menu principal.
 */
public class PanelPrincipal {
    private JButton textoButton;
    private JPanel panel;
    private JButton puntoButton;
    private JButton lineaButton;
    private JButton circuloButton;
    private JButton cuadradoButton;
    private JButton rectanguloButton;
    private JButton poligonoButton;
    private JButton historialDeFigurasButton;
    private JButton salirButton;
    private final JFrame frame = new JFrame("Figuras Geometricas");

    /**
     * Una vez se instancia el constructor, se inician las configuraciones necesarias para formar el frame
     * y se panel dentro. A parte de añadir todos los eventos a los botnes que formaran parte del menu.
     */
    public PanelPrincipal(){
        FiguraCache.getInstance();
        frame.setContentPane(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        textoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    TextoDialog td = new TextoDialog(frame);
                    td.pack();
                    td.setVisible(true);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        });

        lineaButton.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try{
                LineaDialog ld = new LineaDialog(frame);
                ld.pack();
                ld.setVisible(true);
            }catch (Exception e){
                e.getMessage();
            }
        }
    });
        puntoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    PuntoDialog pd = new PuntoDialog(frame);
                    pd.pack();
                    pd.setVisible(true);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        });
        circuloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    CirculoDialog cd = new CirculoDialog(frame);
                    cd.pack();
                    cd.setVisible(true);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        });
        cuadradoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    CuadradoDialog cd = new CuadradoDialog(frame);
                    cd.pack();
                    cd.setVisible(true);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        });
        rectanguloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    RectanguloDialog rd = new RectanguloDialog(frame);
                    rd.pack();
                    rd.setVisible(true);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        }); poligonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    PoligonoDialog pd = new PoligonoDialog(frame);
                    pd.pack();
                    pd.setVisible(true);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        });
        /**
         * Una vez se apreta el boton de generar historial se comprueba si hay figuras dentro de la lista,
         * si es asi, se cambia el panel de lienzo por el lienzoHistorial, debido a que necesitamos del metodo
         * paint de este ultimo para generar todas las formas sin problema.
         */
        historialDeFigurasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Main.listaFormas.size() <= 0){
                    JOptionPane.showMessageDialog(null, "No hay niguna forma en el historial");
                }else{
                    try{
                        final LienzoHistorial lienzoHistorial = new LienzoHistorial();
                        Main.friendLienzo.setContentPane(lienzoHistorial);
                        Main.friendLienzo.setVisible(true);
                    }catch (Exception e){
                        e.getMessage();
                    }
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                   frame.dispose();
                }catch (Exception e){
                    e.getMessage();
                }
            }
        });



    }


}
