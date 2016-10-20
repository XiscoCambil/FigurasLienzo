import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
    private int x,x2,x3,y,y2,y3;
    private Color color;
    private boolean rellenar;
    private String respuesta;

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
        Map map = ObtenerValores();
        try{
            if((x < 550 && x > 50) && (y < 550 && y > 50) &&
                 (x2 < 550 && x2 > 50) && (y2 < 550 && y2 > 50) &&
                    (x3 < 550 && x3 > 50) && (y3 < 550 && y3 > 50)){
                Forma f = FiguraCache.getInstance().getCopiaForma("poligono");
                f.fillAttributes(map);
                Main.listaFormas.add(f);
                Main.friendLienzo.getContentPane().repaint();
                Main.friendLienzo.getContentPane().setVisible(true);
                Main.friendLienzo.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "los valores de X o Y no pueden ser mayor que 600 o menor que 0");
            }
        }catch (NumberFormatException n){
            JOptionPane.showMessageDialog(null, "Los valores no son correctos");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
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

    /*
    private void ObtenerValores() {
        punto1 = new Punto(Integer.parseInt(xValue.getText()),Integer.parseInt(yValue.getText()));
        punto2 = new Punto(Integer.parseInt(x2Value.getText()),Integer.parseInt(y2Value.getText()));
        punto3 = new Punto(Integer.parseInt(x3Value.getText()),Integer.parseInt(y3Value.getText()));
        puntas = Integer.parseInt(nPuntas.getText());
        color = (Color) colores.getSelectedItem();
        String respuesta = (String) resRellenar.getSelectedItem();
        rellenar = Objects.equals(respuesta, "Si");

    }
       */

    private Map ObtenerValores() {
        respuesta = (String) resRellenar.getSelectedItem();
        x = Integer.parseInt(xValue.getText());
        y = Integer.parseInt(yValue.getText());
        x2 = Integer.parseInt(x2Value.getText());
        y2 = Integer.parseInt(y2Value.getText());
        x3 = Integer.parseInt(x3Value.getText());
        y3 = Integer.parseInt(y3Value.getText());
        puntas = Integer.parseInt(nPuntas.getText());
        color = (Color) colores.getSelectedItem();
        rellenar = Objects.equals(respuesta, "Si");
        Map<String,Object> map = new HashMap<>();
        map.put("x",x);
        map.put("y",y);
        map.put("x2",x2);
        map.put("y2",y2);
        map.put("x3",x3);
        map.put("y3",y3);
        map.put("color",color);
        map.put("npuntas",puntas);
        map.put("rellenar",rellenar);
        return map;
    }
}
