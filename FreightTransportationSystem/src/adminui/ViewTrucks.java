/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.TruckInfoDAO;
import model.to.TruckInfo;
import reports.JasperReportGenerator;
import sound.ProSound;
import specificreports.SpecificTruck;
import utility.CommonOperations;

/**
 *
 * @author ADITYA
 */
public class ViewTrucks extends javax.swing.JInternalFrame {

    List<TruckInfo> trucks;
    private JPopupMenu popup;
    private int row;

    public ViewTrucks() {
        initComponents();
        bindTables();
        popup = new JPopupMenu();
        JMenuItem deleteitem = new JMenuItem("Delete this record");
        JMenuItem edititem = new JMenuItem("Edit this record");
        popup.add(deleteitem);
        popup.add(edititem);
        deleteitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleterecord();
            }
        });
        edititem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editrecord();
            }
        });
        row = -1;
        try {
            ImageIcon icon, icone;
            icon = new ImageIcon(getClass().getResource("/adminui/delete.png"));
            icone = new ImageIcon(getClass().getResource("/adminui/edit.png"));
            edititem.setIcon(icone);
            deleteitem.setIcon(icon);
        } catch (Exception ex) {
        }
    }

    public void editrecord() {
        if (row != -1 && trucks != null && row < trucks.size()) {
            TruckInfo record = trucks.get(row);
            CommonOperations.showScreen(getDesktopPane(), new AddTruckInfo(record));
            dispose();
        }
        row = -1;
    }

    public void deleterecord() {
        ProSound ps = new ProSound();
        if (row != -1 && trucks != null && row < trucks.size()) {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure to delete this record", "Message from system", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TruckInfo record = trucks.get(row);
                TruckInfoDAO action = new TruckInfoDAO();
                String message = "";
                if (action.deleteRecord(record.getTruckno())) {
                    ps.button();
                    message = "Record is removed from the database";
                    bindTables();
                } else {
                    ps.computererror();
                    if (action.getErrormessage().contains("foreign key constraint fails")) {
                        message = "This record could not be deleted as this is used as a foreign key for other tables.\nIn order to delete,first delete all its content from tables where it is used as a foreign key.";
                    } else {
                        message = "Deletion Failure due to:" + action.getErrormessage();
                    }
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        row = -1;

    }

    public void bindTables() {
        trucks = new TruckInfoDAO().getAllRecord();
        String[] colnames = {"TRUCK NO", "CHASSIS NO.", "CAPACITY", "WEIGHT"};
        Object[][] records = null;
        if (trucks != null && trucks.size() > 0) {
            records = new Object[trucks.size()][colnames.length];
            int i = 0;
            for (TruckInfo ti : trucks) {
                records[i] = new Object[]{ti.getTruckno(), ti.getChassisno(), ti.getCapacity(), ti.getWeight()};
                i++;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records", "No Records", "No Records", "No Records"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, colnames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableTruck.getTableHeader().setReorderingAllowed(false);
        tableTruck.setAutoCreateRowSorter(true);
        tableTruck.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableTruckDetails = new javax.swing.JScrollPane();
        tableTruck = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Truck Details");

        tableTruck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTruck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTruckMouseClicked(evt);
            }
        });
        tableTruckDetails.setViewportView(tableTruck);

        btnLoad.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLoad.setText("Load Again");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnReport.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnReport.setText("Generate Report");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableTruckDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableTruckDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        ProSound ps = new ProSound();
        ps.button();
        bindTables();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void tableTruckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTruckMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int rowpoint = tableTruck.rowAtPoint(evt.getPoint());
            tableTruck.getSelectionModel().setSelectionInterval(rowpoint, rowpoint);
            popup.show(tableTruck, evt.getX(), evt.getY());
            row = tableTruck.getSelectedRow();
        }
    }//GEN-LAST:event_tableTruckMouseClicked

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        ProSound ps = new ProSound();
        ps.button();
        int result = JOptionPane.showConfirmDialog(this, "Do you want to generate all records ?", "Message from system", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            String path = "E:/FreightTransportationSystem/build/classes/reports/viewtruck.jrxml";
            JasperReportGenerator jrg = new JasperReportGenerator(path);
            jrg.generateReport();
        } else {
            CommonOperations.showScreen(getDesktopPane(), new SpecificTruck());
        }    }//GEN-LAST:event_btnReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnReport;
    private javax.swing.JTable tableTruck;
    private javax.swing.JScrollPane tableTruckDetails;
    // End of variables declaration//GEN-END:variables
}