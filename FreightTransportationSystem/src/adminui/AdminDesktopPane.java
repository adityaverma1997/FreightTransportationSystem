package adminui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class AdminDesktopPane extends JDesktopPane {

    private Image backimage;

    public AdminDesktopPane() {
        try {
            ImageIcon icon;
            icon=new ImageIcon(getClass().getResource("/adminui/tmm.jpg"));
            backimage=icon.getImage();
        } catch (Exception ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(backimage==null){
            super.paintComponent(g);
        }else{
            g.drawImage(backimage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
}
