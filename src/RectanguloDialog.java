import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Clase RectanguloDialog creada para obtener los datos necesarios a traves de los textFilds y jcombox.
 */
public class RectanguloDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonPintar;
    private JButton buttonCancel;
    private JTextField xValue;
    private JTextField yValue;
    private JTextField heigthValue;
    private JTextField widthValue;
    private JComboBox resRellenar;
    private JComboBox colores;

    private int x,y,heigth,width;
    private boolean rellenar;
    private Color color;
    private String respuesta;


    public RectanguloDialog(JFrame parent) throws SQLException {
        super(parent);
        setLocationRelativeTo(parent);
        setContentPane(contentPane);
        setTitle("Dibujar Rectanuglo");
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
        // add your code here
        try{
           Map map = ObtenerValores();
            if (heigth == width) {
                JOptionPane.showMessageDialog(null, "Esto son las medidas de un cuadrado no de un Rectangulo");
            } else {
                if ((x < 550 && x > 50) && (y < 550 && y > 50)) {
                    //Punto p = new Punto(x,y);
                    //Forma f = new Rectangulo(p, width, heigth, color, rellenar);
                    Forma f = FiguraCache.getInstance().getCopiaForma("rectangulo");
                    f.fillAttributes(map);
                    Main.listaFormas.add(f);
                    Main.friendLienzo.getContentPane().repaint();
                    Main.friendLienzo.getContentPane().setVisible(true);
                    Main.friendLienzo.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "los valores de X o Y no pueden ser mayor que 600 o menor que 0");
                }
            }
        }catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Los valores no son correctos");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void onCancel() {
        // add your code here if necessary
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

    /*private void ObtenerValores() {
        x = Integer.parseInt(xValue.getText());
        y = Integer.parseInt(yValue.getText());
        width = Integer.parseInt(widthValue.getText());
        heigth =  Integer.parseInt(heigthValue.getText());
        color = (Color) colores.getSelectedItem();
        String respuesta = (String) resRellenar.getSelectedItem();
        rellenar = Objects.equals(respuesta, "Si");
    }*/

    private Map ObtenerValores() {
        respuesta = resRellenar.getSelectedItem().toString();
        x = Integer.parseInt(xValue.getText());
        y = Integer.parseInt(yValue.getText());
        width = Integer.parseInt(widthValue.getText());
        heigth = Integer.parseInt(heigthValue.getText());
        color = (Color) colores.getSelectedItem();
        Map<String,Object> map = new HashMap<>();
        map.put("x",x);
        map.put("y",y);
        map.put("color",color);
        map.put("width",width);
        map.put("height",heigth);
        map.put("rellenar", Objects.equals(respuesta, "Si"));
        return map;
    }


}

