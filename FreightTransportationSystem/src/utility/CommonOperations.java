package utility;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class CommonOperations {
    public static void showScreen(JDesktopPane dp,JInternalFrame jif){
            jif.setVisible(true);
            dp.add(jif);
            try {
                jif.setSelected(true);
            } catch (PropertyVetoException ex) {
            }
    }
}
