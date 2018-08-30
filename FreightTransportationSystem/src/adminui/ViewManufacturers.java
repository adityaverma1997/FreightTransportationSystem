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
import model.dao.ManufacturerInfoDAO;
import model.to.ManufacturerInfo;
import reports.JasperReportGenerator;
import sound.ProSound;
import specificreports.SpecificManufacturers;
import utility.CommonOperations;

/**
 *
 * @author ADITYA
 */
public class ViewManufacturers extends javax.swing.JInternalFrame {

    List<ManufacturerInfo> manufacturers;
    private JPopupMenu popup;
    private int row;

    public ViewManufacturers() {
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
        if (row != -1 && manufacturers != null && row < manufacturers.size()) {
            ManufacturerInfo record = manufacturers.get(row);
            CommonOperations.showScreen(getDesktopPane(), new AddNewManufacturer(record));
            dispose();
        }
        row = -1;
    }

    public void deleterecord() {
        ProSound ps = new ProSound();
        if (row != -1 && manufacturers != null && row < manufacturers.size()) {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure to delete this record", "Message from system", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                ManufacturerInfo record = manufacturers.get(row);
                ManufacturerInfoDAO action = new ManufacturerInfoDAO();
                String message = "";
                if (action.deleteRecord(record.getMID())) {
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
        manufacturers = new ManufacturerInfoDAO().getAllRecord();
        String[] colnames = {"MID", "NAME", "ADDRESS", "CONTACT NO.", "EMAIL ID"};
        Object[][] records = null;
        if (manufacturers != null && manufacturers.size() > 0) {
            records = new Object[manufacturers.size()][colnames.length];
            int i = 0;
            for (ManufacturerInfo mn : manufacturers) {
                records[i] = new Object[]{mn.getMID(), mn.getName(), mn.getAddress(), mn.getContactno(), mn.getEmailid()};
                i++;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records", "No Records", "No Records"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, colnames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tableManufacturers.getTableHeader().setReorderingAllowed(false);
        tableManufacturers.setAutoCreateRowSorter(true);
        tableManufacturers.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableManufacturers = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Manufacturer Details");

        tableManufacturers.setModel(new javax.swing.table.DefaultTableModel(
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
        tableManufacturers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableManufacturersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableManufacturers);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        ProSound ps = new ProSound();
        ps.button();
        bindTables();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void tableManufacturersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableManufacturersMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int rowpoint = tableManufacturers.rowAtPoint(evt.getPoint());
            tableManufacturers.getSelectionModel().setSelectionInterval(rowpoint, rowpoint);
            popup.show(tableManufacturers, evt.getX(), evt.getY());
            row = tableManufacturers.getSelectedRow();
        }
    }//GEN-LAST:event_tableManufacturersMouseClicked

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        ProSound ps = new ProSound();
        ps.button();
        int result = JOptionPane.showConfirmDialog(this, "Do you want to generate all records ?", "Message from system", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            String path = "E:/FreightTransportationSystem/build/classes/reports/viewmanufacturers.jrxml";
            JasperReportGenerator jrg = new JasperReportGenerator(path);
            jrg.generateReport();
        } else {
            CommonOperations.showScreen(getDesktopPane(), new SpecificManufacturers());
        }    }//GEN-LAST:event_btnReportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnReport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableManufacturers;
    // End of variables declaration//GEN-END:variables
}
