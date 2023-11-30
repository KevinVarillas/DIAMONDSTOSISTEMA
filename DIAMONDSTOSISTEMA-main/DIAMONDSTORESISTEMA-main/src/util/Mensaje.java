
package util;

import java.awt.Component;
import javax.swing.JOptionPane;
public class Mensaje {
     private Mensaje() {
    }

    public static void info(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "DIAMOND STORE 21- INFORMACIÓN",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "DIAMOND STORE 21 - ERROR",
                JOptionPane.ERROR_MESSAGE);
    }
}
