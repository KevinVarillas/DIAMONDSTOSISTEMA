
package DISEÑO;


import java.awt.Component;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderImagen extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        if (value instanceof BufferedImage) {
            BufferedImage imagen = (BufferedImage) value;
            ImageIcon icono = new ImageIcon(imagen);
            JLabel label = new JLabel();
            label.setIcon(icono);
            return label;
        } else if (value instanceof ImageIcon) {
            JLabel label = new JLabel();
            label.setIcon((ImageIcon) value);
            return label;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

    

