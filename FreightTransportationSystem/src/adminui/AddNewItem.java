/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.util.List;
import javax.swing.JOptionPane;
import model.dao.CategoryInfoDAO;
import model.dao.ItemInfoDAO;
import model.dao.ManufacturerInfoDAO;
import model.to.CategoryInfo;
import model.to.ItemInfo;
import model.to.ManufacturerInfo;
import operations.Validations;
import sound.ProSound;
import utility.CommonOperations;

/**
 *
 * @author ADITYA
 */
public class AddNewItem extends javax.swing.JInternalFrame {

    private int itemid;

    public AddNewItem() {
        initComponents();
        jcbCategoryId.removeAllItems();
        jcbCategoryId.addItem("Choose Category ID");
        List<CategoryInfo> category = new CategoryInfoDAO().getAllRecord();
        for (CategoryInfo ct : category) {
            jcbCategoryId.addItem(ct);
        }
        jcbMid.removeAllItems();
        jcbMid.addItem("Choose MID");
        List<ManufacturerInfo> manufacturer = new ManufacturerInfoDAO().getAllRecord();
        for (ManufacturerInfo mn : manufacturer) {
            jcbMid.addItem(mn);
        }
    }

    public AddNewItem(ItemInfo record) {
        this();
        if (record != null) {
            this.itemid = record.getItemid();
            setTitle("Update Item Details");
            btnAdd.setText("Update Item Details");
            for (int i = 1; i < jcbCategoryId.getItemCount(); i++) {
                CategoryInfo cat = (CategoryInfo) jcbCategoryId.getItemAt(i);
                if (cat.getCategoryid().equals(record.getCategoryid())) {
                    jcbCategoryId.setSelectedIndex(i);
                    break;
                }
            }
            jtfItemName.setText(record.getItemname());
            jtfWeight.setText(String.valueOf(record.getWeight()));
            for (int i = 1; i < jcbMid.getItemCount(); i++) {
                ManufacturerInfo man = (ManufacturerInfo) jcbMid.getItemAt(i);
                if (man.getMID() == record.getMID()) {
                    jcbMid.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbMid = new javax.swing.JComboBox();
        jcbCategoryId = new javax.swing.JComboBox();
        jtfWeight = new javax.swing.JTextField();
        jtfItemName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add New Item Details");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Choose Category ID:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Enter Weight:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Choose MID:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Enter Item Name:");

        jcbMid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbCategoryId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtfWeight.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfWeightKeyTyped(evt);
            }
        });

        jtfItemName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfItemName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfItemNameKeyTyped(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAdd.setText("Add Item Details");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/itemweight.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/verifiedcid.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/mid.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbMid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jtfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5))))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ProSound ps = new ProSound();
        String message = "";
        boolean allvalid = true;
        String itemname = jtfItemName.getText().trim();
        String weight = jtfWeight.getText().trim();
        if (jcbCategoryId.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please choose any Course ID\n\n";
        }
        if (Validations.isEmpty(itemname)) {
            allvalid = false;
            message += "Please enter some value in Item Name box\n\n";
        } else if (!Validations.onlyCharacter(itemname)) {
            allvalid = false;
            message += "Please enter character value in Item Name box\n\n";
        }
        if (Validations.isEmpty(weight)) {
            allvalid = false;
            message += "Please enter some value in Weight box\n\n";
        } else if (!Validations.isFloat(weight)) {
            allvalid = false;
            message += "Please enter decimal value in Weight box\n\n";
        }
        if (jcbMid.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please choose any MID\n\n";
        }
        if (allvalid) {
            CategoryInfo ci = (CategoryInfo) jcbCategoryId.getSelectedItem();
            ManufacturerInfo mi = (ManufacturerInfo) jcbMid.getSelectedItem();
            ItemInfo record = new ItemInfo();
            record.setCategoryid(ci.getCategoryid());
            record.setItemname(itemname);
            record.setWeight(Float.parseFloat(weight));
            record.setMID(mi.getMID());
            ItemInfoDAO action = new ItemInfoDAO();
            if (btnAdd.getText().contains("Add")) {
                if (action.insertRecord(record)) {
                    ps.button();
                    message = "Item Details are added in the system";
                } else {
                    ps.computererror();
                    message = "Insertion Failure due to:" + action.getErrormessage();
                }
            } else if (btnAdd.getText().contains("Update")) {
                record.setItemid(itemid);
                if (action.updateRecord(record)) {
                    ps.button();
                    message = "Item Details are updated in the system";
                } else {
                    ps.computererror();
                    message = "Updation Failure due to:" + action.getErrormessage();
                }
                CommonOperations.showScreen(getDesktopPane(), new ViewItems());
                dispose();
            } else {
                ps.computererror();
                message = "No proper operation";
            }
        } else {
            ps.computererror();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jtfItemNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfItemNameKeyTyped
        if (!Character.isLetter(evt.getKeyChar())) {
            if (!Character.isWhitespace(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_jtfItemNameKeyTyped

    private void jtfWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfWeightKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfWeightKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox jcbCategoryId;
    private javax.swing.JComboBox jcbMid;
    private javax.swing.JTextField jtfItemName;
    private javax.swing.JTextField jtfWeight;
    // End of variables declaration//GEN-END:variables
}
