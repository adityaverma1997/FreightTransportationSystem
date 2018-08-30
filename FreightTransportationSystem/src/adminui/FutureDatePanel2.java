/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ADITYA
 */
public class FutureDatePanel2 extends javax.swing.JPanel {

    private GregorianCalendar gcal;

    public FutureDatePanel2() {
        initComponents();
        gcal = new GregorianCalendar();
        jcbYear.removeAllItems();
        jcbYear.addItem("Year");
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        int cyear = gcal.get(Calendar.YEAR);
        int range = cyear + 10;
        for (int year = cyear; year <= range; year++) {
            jcbYear.addItem(year);
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

        jcbDate = new javax.swing.JComboBox<>();
        jcbYear = new javax.swing.JComboBox<>();
        jcbMonth = new javax.swing.JComboBox<>();

        jcbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYearItemStateChanged(evt);
            }
        });

        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonthItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        int datevalue = 0;
        if (jcbDate.getSelectedIndex() > 0) {
            datevalue = Integer.parseInt(jcbDate.getSelectedItem().toString());
        }
        MonthList1 monthvalue = null;
        if (jcbMonth.getSelectedIndex() > 0) {
            monthvalue = (MonthList1) jcbMonth.getSelectedItem();
        }
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        if (jcbYear.getSelectedIndex() > 0) {
            int syear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int cyear = gcal.get(Calendar.YEAR);
            MonthList1[] months = MonthList1.values();
            int range = months.length - 1;
            int startrange = 0;
            if (syear == cyear) {
                startrange = gcal.get(Calendar.MONTH);
            }
            for (int i = startrange; i <= range; i++) {
                jcbMonth.addItem(months[i]);
            }
            if (monthvalue != null) {
                for (int i = 1; i < jcbMonth.getItemCount(); i++) {
                    MonthList1 mval = (MonthList1) jcbMonth.getItemAt(i);
                    if (mval.ordinal() == monthvalue.ordinal()) {
                        jcbMonth.setSelectedIndex(i);
                        break;
                    }
                }
                if (datevalue != 0) {
                    for (int i = 1; i < jcbDate.getItemCount(); i++) {
                        int val = Integer.parseInt(jcbDate.getItemAt(i).toString());
                        if (val == datevalue) {
                            jcbDate.setSelectedIndex(i);
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbYearItemStateChanged

    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        int datevalue = 0;
        if (jcbDate.getSelectedIndex() > 0) {
            datevalue = Integer.parseInt(jcbDate.getSelectedItem().toString());
        }
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if (jcbMonth.getSelectedIndex() > 0) {
            int syear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int cyear = gcal.get(Calendar.YEAR);
            MonthList1 smonth = (MonthList1) jcbMonth.getSelectedItem();
            int cmonth = gcal.get(Calendar.MONTH);
            int daterange = smonth.getTotaldays();
            int startrange = 1;
            if (smonth == MonthList1.February) {
                daterange = gcal.isLeapYear(syear) ? 29 : 28;
            }
            if (syear == cyear && smonth.ordinal() == cmonth) {
                startrange = gcal.get(Calendar.DATE);
            }
            for (int date = startrange; date <= daterange; date++) {
                jcbDate.addItem(date);
            }
            if (datevalue != 0) {
                for (int i = 1; i < jcbDate.getItemCount(); i++) {
                    int val = Integer.parseInt(jcbDate.getItemAt(i).toString());
                    if (val == datevalue) {
                        jcbDate.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbMonthItemStateChanged
    public Date getSelectedDate() {
        Date datevalue = null;
        try {
            if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0 && jcbDate.getSelectedIndex() > 0) {
                int year = Integer.parseInt(jcbYear.getSelectedItem().toString());
                MonthList1 mvalue = (MonthList1) jcbMonth.getSelectedItem();
                int month = mvalue.ordinal() + 1;
                int date = Integer.parseInt(jcbDate.getSelectedItem().toString());
                String dtvalue = year + "-" + month + "-" + date;
                datevalue = Date.valueOf(dtvalue);
            }
        } catch (Exception ex) {
        }
        return datevalue;
    }

    public void setDate(Date datevalue) {
        try {
            String[] values = datevalue.toString().split("-");
            int year = Integer.parseInt(values[0]);
            int month = Integer.parseInt(values[1]);
            int date = Integer.parseInt(values[2]);
            for (int i = 1; i < jcbYear.getItemCount(); i++) {
                int syear = Integer.parseInt(jcbYear.getItemAt(i).toString());
                if (syear == year) {
                    jcbYear.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbMonth.getItemCount(); i++) {
                MonthList1 mval = (MonthList1) jcbMonth.getItemAt(i);
                if (mval.ordinal() == month - 1) {
                    jcbMonth.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbDate.getItemCount(); i++) {
                int val = Integer.parseInt(jcbDate.getItemAt(i).toString());
                if (val == date) {
                    jcbDate.setSelectedIndex(i);
                    break;
                }
            }
        } catch (Exception ex) {

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> jcbDate;
    private javax.swing.JComboBox<Object> jcbMonth;
    private javax.swing.JComboBox<Object> jcbYear;
    // End of variables declaration//GEN-END:variables
}
