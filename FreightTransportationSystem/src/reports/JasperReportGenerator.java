package reports;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import model.dao.DataConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportGenerator {

    String designFilePath;

    public JasperReportGenerator(String designFilePath) {
        this.designFilePath = designFilePath;
    }

    public void generateReport() {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection con = DataConnection.getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.println("Exception in generating report,generateReport() of JasperReportGenerator.");
            //ErrorHandling.displayStackTrace(ex);
        }
    }

    public void generateReport(String value) {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection con = DataConnection.getConnection();
            Map parameters = new HashMap();
            parameters.put("value", value);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.println("Exception in generating report,generateReport() of JasperReportGenerator.");
        }
    }

    public void generateReport(int value) {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection con = DataConnection.getConnection();
            Map parameters = new HashMap();
            parameters.put("value", value);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.println("Exception in generating report,generateReport() of JasperReportGenerator.");
        }
    }
}
