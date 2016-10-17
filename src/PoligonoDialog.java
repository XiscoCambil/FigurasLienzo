import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Objects;
/**
 * Clase CirculoDialog creada para obtener los datos necesarios a traves de los textFilds y jcombox.
 */
public class PoligonoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonPintar;
    private JButton buttonCancel;
    private JTextField xValue;
    private JTextField x2Value;
    private JTextField x3Value;
    private JTextField y3Value;
    private JTextField y2Value;
    private JTextField yValue;
    private JComboBox resRellenar;
    private JComboBox colores;
    private JTextField nPuntas;

    private int puntas;
    private Punto punto1,punto2,punto3;
    private Color color;
    private boolean rellenar;

    public PoligonoDialog(JFrame parent) throws SQLException {
        super(parent);
        setLocationRelativeTo(parent);
        setContentPane(contentPane);
        setTitle("Dibujar Poligono");
        setModal(true);
        getRootPane().setDefaultButton(buttonPintar);
        CreateComboColor(colores);
        CreateComboRespuesta(resRellenar);

        buttonPintar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPintar();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Se comprueban que los valores introducidos dentro de los inputs sean los correctos
     * Una vez que se consigen los datos se introduce la forma dentro de la lista de formas.
     * El lienzo se vuelve a repintar y llama al metodo paint de la clase jpanel, este metodo
     * se ejecuta de manera autimatica cuando se hace visible el frame del lienzo.
     *
     */
    private void onPintar() {
        try{
            ObtenerValores();
            if((punto1.getX() < 550 && punto1.getX() > 50) && (punto1.getY() < 550 && punto1.getY() > 50) &&
                 (punto2.getX() < 550 && punto2.getX() > 50) && (punto2.getY() < 550 && punto2.getY() > 50) &&
                    (punto3.getX() < 550 && punto3.getX() > 50) && (punto3.getY() < 550 && punto3.getY() > 50)){
                Forma f = new Poligono(punto1,punto2,punto3,puntas,color, rellenar);
                Main.listaFormas.add(f);
                Main.friendLienzo.getContentPane().repaint();
                Main.friendLienzo.getContentPane().setVisible(true);
                Main.friendLienzo.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "los valores de X o Y no pueden ser mayor que 600 o menor que 0");
            }
        }catch (NumberFormatException n){
            JOptionPane.showMessageDialog(null, "Los valores no son correctos");
        }
    }

    private void onCancel() {
        Main.friendLienzo.dispose();
        dispose();
    }

    private void CreateComboColor(JComboBox comboBox) throws SQLException {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        dcb.addElement(Color.black);
        dcb.addElement(Color.WHITE);
        dcb.addElement(Color.GREEN);
        dcb.addElement(Color.BLUE);
        dcb.addElement(Color.CYAN);
        dcb.addElement(Color.YELLOW);
        comboBox.setModel(dcb);
        comboBox.setVisible(true);
    }

    private void CreateComboRespuesta(JComboBox comboBox) throws SQLException {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        dcb.addElement("Si");
        dcb.addElement("No");
        comboBox.setModel(dcb);
        comboBox.setVisible(true);
    }

    private void ObtenerValores() {
        punto1 = new Punto(Integer.parseInt(xValue.getText()),Integer.parseInt(yValue.getText()));
        punto2 = new Punto(Integer.parseInt(x2Value.getText()),Integer.parseInt(y2Value.getText()));
        punto3 = new Punto(Integer.parseInt(x3Value.getText()),Integer.parseInt(y3Value.getText()));
        puntas = Integer.parseInt(nPuntas.getText());
        color = (Color) colores.getSelectedItem();
        String respuesta = (String) resRellenar.getSelectedItem();
        rellenar = Objects.equals(respuesta, "Si");

    }

}
