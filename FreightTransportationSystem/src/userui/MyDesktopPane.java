package userui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class MyDesktopPane extends JDesktopPane {

    private Image backimage;

    public MyDesktopPane() {
        try {
            ImageIcon icon;
            icon=new ImageIcon(getClass().getResource("/userui/gps.jpg"));
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
