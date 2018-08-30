/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import ui.LoginFrame;

/**
 *
 * @author ADITYA
 */
public class AdminMainScreen extends javax.swing.JFrame {

    /**
     * Creates new form AdminMainScreen
     */
    public AdminMainScreen() {
        try {
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/adminui/logoo.png"));
            setIconImage(icon.getImage());
        } catch (Exception ex) {
        }
        initComponents();
        setSize(1100, 700);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskpane = new javax.swing.JDesktopPane();
        adminDesktopPane3 = new adminui.AdminDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jmiAddManufacturer = new javax.swing.JMenuItem();
        jmiViewManufacturers = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiAddCategory = new javax.swing.JMenuItem();
        jmiViewCategory = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiAddItem = new javax.swing.JMenuItem();
        jmiViewItems = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jmiAddDriver = new javax.swing.JMenuItem();
        jmiViewDrivers = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmiAddTruck = new javax.swing.JMenuItem();
        jmiViewTrucks = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiAddTourSchedule = new javax.swing.JMenuItem();
        jmiViewTourSchedules = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jmiAddTourItems = new javax.swing.JMenuItem();
        jmiViewTourItems = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jmiViewWeeklySchedule = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jmiAddNewUser = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jmiLogout = new javax.swing.JMenuItem();
        jmExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deskpane.setLayer(adminDesktopPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout deskpaneLayout = new javax.swing.GroupLayout(deskpane);
        deskpane.setLayout(deskpaneLayout);
        deskpaneLayout.setHorizontalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminDesktopPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1207, Short.MAX_VALUE)
        );
        deskpaneLayout.setVerticalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminDesktopPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        getContentPane().add(deskpane, java.awt.BorderLayout.CENTER);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Manufacturer Operations  ");

        jmiAddManufacturer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addmanufacturer.png"))); // NOI18N
        jmiAddManufacturer.setText("Add New Manufacturer");
        jmiAddManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddManufacturerActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAddManufacturer);

        jmiViewManufacturers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewmanufacturer.png"))); // NOI18N
        jmiViewManufacturers.setText("View Manufacturer Details");
        jmiViewManufacturers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewManufacturersActionPerformed(evt);
            }
        });
        jMenu3.add(jmiViewManufacturers);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Category Operations  ");

        jmiAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addcategory.png"))); // NOI18N
        jmiAddCategory.setText("Add New Category");
        jmiAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddCategoryActionPerformed(evt);
            }
        });
        jMenu4.add(jmiAddCategory);

        jmiViewCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewcategory.png"))); // NOI18N
        jmiViewCategory.setText("View New Category");
        jmiViewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewCategoryActionPerformed(evt);
            }
        });
        jMenu4.add(jmiViewCategory);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Item Operations  ");

        jmiAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/additem.png"))); // NOI18N
        jmiAddItem.setText("Add New Item");
        jmiAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddItemActionPerformed(evt);
            }
        });
        jMenu6.add(jmiAddItem);

        jmiViewItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewitem.png"))); // NOI18N
        jmiViewItems.setText("View Item Details");
        jmiViewItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewItemsActionPerformed(evt);
            }
        });
        jMenu6.add(jmiViewItems);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Driver Operations  ");

        jmiAddDriver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/adddriver.png"))); // NOI18N
        jmiAddDriver.setText("Add New Driver");
        jmiAddDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddDriverActionPerformed(evt);
            }
        });
        jMenu7.add(jmiAddDriver);

        jmiViewDrivers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewdriver.png"))); // NOI18N
        jmiViewDrivers.setText("View Driver Details");
        jmiViewDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewDriversActionPerformed(evt);
            }
        });
        jMenu7.add(jmiViewDrivers);

        jMenuBar1.add(jMenu7);

        jMenu1.setText("Truck Operations  ");

        jmiAddTruck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addtruckk.png"))); // NOI18N
        jmiAddTruck.setText("Add New Truck");
        jmiAddTruck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTruckActionPerformed(evt);
            }
        });
        jMenu1.add(jmiAddTruck);

        jmiViewTrucks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewtruckk.png"))); // NOI18N
        jmiViewTrucks.setText("View Truck Details");
        jmiViewTrucks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTrucksActionPerformed(evt);
            }
        });
        jMenu1.add(jmiViewTrucks);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tour Schedule Operations  ");

        jmiAddTourSchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addtourschedule.png"))); // NOI18N
        jmiAddTourSchedule.setText("Add New Tour Schedule");
        jmiAddTourSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTourScheduleActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAddTourSchedule);

        jmiViewTourSchedules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewtourschedule.png"))); // NOI18N
        jmiViewTourSchedules.setText("View Tour Schedule Details");
        jmiViewTourSchedules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTourSchedulesActionPerformed(evt);
            }
        });
        jMenu2.add(jmiViewTourSchedules);

        jMenuBar1.add(jMenu2);

        jMenu8.setText("Tour Item Operations  ");

        jmiAddTourItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addtouritems.png"))); // NOI18N
        jmiAddTourItems.setText("Add New Tour Items");
        jmiAddTourItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTourItemsActionPerformed(evt);
            }
        });
        jMenu8.add(jmiAddTourItems);

        jmiViewTourItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewtouritems.png"))); // NOI18N
        jmiViewTourItems.setText("View Tour Item Details");
        jmiViewTourItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTourItemsActionPerformed(evt);
            }
        });
        jMenu8.add(jmiViewTourItems);

        jMenuBar1.add(jMenu8);

        jMenu10.setText("Weekly Schedule  ");

        jmiViewWeeklySchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/viewtourschedule.png"))); // NOI18N
        jmiViewWeeklySchedule.setText("View Weekly Schedule ");
        jmiViewWeeklySchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewWeeklyScheduleActionPerformed(evt);
            }
        });
        jMenu10.add(jmiViewWeeklySchedule);

        jMenuBar1.add(jMenu10);

        jMenu9.setText("Login Operations  ");

        jmiAddNewUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/adduser.png"))); // NOI18N
        jmiAddNewUser.setText("Add New User");
        jmiAddNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddNewUserActionPerformed(evt);
            }
        });
        jMenu9.add(jmiAddNewUser);

        jMenuBar1.add(jMenu9);

        jMenu11.setText("Profile");

        jmiLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/logout.png"))); // NOI18N
        jmiLogout.setText("Log Out");
        jmiLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogoutActionPerformed(evt);
            }
        });
        jMenu11.add(jmiLogout);

        jMenuBar1.add(jMenu11);

        jmExit.setText("    Exit");
        jmExit.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jmExitMenuSelected(evt);
            }
        });
        jMenuBar1.add(jmExit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAddManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddManufacturerActionPerformed
        showScreen(new AddNewManufacturer());
    }//GEN-LAST:event_jmiAddManufacturerActionPerformed

    private void jmiViewManufacturersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewManufacturersActionPerformed
        showScreen(new ViewManufacturers());
    }//GEN-LAST:event_jmiViewManufacturersActionPerformed

    private void jmiAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddCategoryActionPerformed
        showScreen(new AddNewCategory());
    }//GEN-LAST:event_jmiAddCategoryActionPerformed

    private void jmiViewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewCategoryActionPerformed
        showScreen(new ViewCategory());
    }//GEN-LAST:event_jmiViewCategoryActionPerformed

    private void jmiAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddItemActionPerformed
        showScreen(new AddNewItem());
    }//GEN-LAST:event_jmiAddItemActionPerformed

    private void jmiViewItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewItemsActionPerformed
        showScreen(new ViewItems());
    }//GEN-LAST:event_jmiViewItemsActionPerformed

    private void jmiAddDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddDriverActionPerformed
        showScreen(new AddNewDriver());
    }//GEN-LAST:event_jmiAddDriverActionPerformed

    private void jmiViewDriversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewDriversActionPerformed
        showScreen(new ViewDrivers());
    }//GEN-LAST:event_jmiViewDriversActionPerformed

    private void jmiAddTruckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTruckActionPerformed
        showScreen(new AddTruckInfo());
    }//GEN-LAST:event_jmiAddTruckActionPerformed

    private void jmiViewTrucksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTrucksActionPerformed
        showScreen(new ViewTrucks());
    }//GEN-LAST:event_jmiViewTrucksActionPerformed

    private void jmiAddTourScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTourScheduleActionPerformed
        showScreen(new AddTourSchedule());
    }//GEN-LAST:event_jmiAddTourScheduleActionPerformed

    private void jmiViewTourSchedulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTourSchedulesActionPerformed
        showScreen(new ViewTourSchedule());
    }//GEN-LAST:event_jmiViewTourSchedulesActionPerformed

    private void jmiAddTourItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTourItemsActionPerformed
        showScreen(new AddTourItems());
    }//GEN-LAST:event_jmiAddTourItemsActionPerformed

    private void jmiViewTourItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTourItemsActionPerformed
        showScreen(new ViewTourItems());
    }//GEN-LAST:event_jmiViewTourItemsActionPerformed

    private void jmiAddNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddNewUserActionPerformed
        showScreen(new AddNewUser());
    }//GEN-LAST:event_jmiAddNewUserActionPerformed

    private void jmiLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogoutActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Message from system", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jmiLogoutActionPerformed

    private void jmiViewWeeklyScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewWeeklyScheduleActionPerformed
        showScreen(new ViewWeeklySchedule());
    }//GEN-LAST:event_jmiViewWeeklyScheduleActionPerformed

    private void jmExitMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jmExitMenuSelected
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Message from system", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jmExitMenuSelected
    public void showScreen(JInternalFrame jif) {
        jif.setVisible(true);
        deskpane.add(jif);
        try {
            jif.setSelected(true);
        } catch (PropertyVetoException ex) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private adminui.AdminDesktopPane adminDesktopPane3;
    private javax.swing.JDesktopPane deskpane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmExit;
    private javax.swing.JMenuItem jmiAddCategory;
    private javax.swing.JMenuItem jmiAddDriver;
    private javax.swing.JMenuItem jmiAddItem;
    private javax.swing.JMenuItem jmiAddManufacturer;
    private javax.swing.JMenuItem jmiAddNewUser;
    private javax.swing.JMenuItem jmiAddTourItems;
    private javax.swing.JMenuItem jmiAddTourSchedule;
    private javax.swing.JMenuItem jmiAddTruck;
    private javax.swing.JMenuItem jmiLogout;
    private javax.swing.JMenuItem jmiViewCategory;
    private javax.swing.JMenuItem jmiViewDrivers;
    private javax.swing.JMenuItem jmiViewItems;
    private javax.swing.JMenuItem jmiViewManufacturers;
    private javax.swing.JMenuItem jmiViewTourItems;
    private javax.swing.JMenuItem jmiViewTourSchedules;
    private javax.swing.JMenuItem jmiViewTrucks;
    private javax.swing.JMenuItem jmiViewWeeklySchedule;
    // End of variables declaration//GEN-END:variables
}
