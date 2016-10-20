import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase PuntoDialog creada para obtener los datos necesarios a traves de los textFilds y jcombox.
 */
public class PuntoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonPintar;
    private JButton buttonCancel;
    private JTextField xValue;
    private JTextField yValue;

    private int x, y;
    Color color;

    public PuntoDialog(JFrame parent) throws SQLException {
        super(parent);
        setLocationRelativeTo(parent);
        setContentPane(contentPane);
        setTitle("Dibujar Punto");
        setModal(true);
        getRootPane().setDefaultButton(buttonPintar);
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
        try {
            Map map = ObtenerValores();
            if ((x < 550 && x > 50) && (y > 50 && y < 550)) {
                Forma f = FiguraCache.getInstance().getCopiaForma("punto");
                f.fillAttributes(map);
                Main.listaFormas.add(f);
                Main.friendLienzo.getContentPane().repaint();
                Main.friendLienzo.getContentPane().setVisible(true);
                Main.friendLienzo.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "los valores de X o Y no pueden ser mayor que 600 o menor que 0");
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


    private Map ObtenerValores() {
        x = Integer.parseInt(xValue.getText());
        y = Integer.parseInt(yValue.getText());
        Map<String,Object> map = new HashMap<>();
        map.put("x",x);
        map.put("y",y);
        map.put("color", Color.black);
        return map;
    }

}
