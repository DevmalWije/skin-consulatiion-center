//package phase1ToPhase3;
//
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.text.JTextComponent;
//import java.awt.*;
//
//// Create a custom cell renderer
//class CustomCellRenderer extends DefaultTableCellRenderer {
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        // Call the parent method to get the default cell renderer component
//        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//        // Enable text wrapping for the cell
//        if (c instanceof JTextComponent) {
//            JTextComponent textComponent = (JTextComponent) c;
//            textComponent.setW(true);
//            textComponent.setLineWrap(true);
//        }
//
//        return c;
//    }
//}
