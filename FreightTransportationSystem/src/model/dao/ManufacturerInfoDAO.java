package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.ManufacturerInfo;
import utility.ErrorHandling;

public class ManufacturerInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(ManufacturerInfo record) {
        try {
            String query = "insert into manufacturerinfo ";
            query += " (name,address,contactno,emailid) ";
            query += " values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getName());
            stmt.setString(2, record.getAddress());
            stmt.setString(3, record.getContactno());
            stmt.setString(4, record.getEmailid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (!errormessage.contains("Duplicate entry")) {
                ErrorHandling.displayStackTrace(ex);
            }
            return false;
        }
    }

    public boolean updateRecord(ManufacturerInfo record) {
        try {
            String query = "update manufacturerinfo ";
            query += " set name=?,address=?,contactno=?,emailid=? ";
            query += " where mid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getName());
            stmt.setString(2, record.getAddress());
            stmt.setString(3, record.getContactno());
            stmt.setString(4, record.getEmailid());
            stmt.setInt(5, record.getMID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (!errormessage.contains("Duplicate entry")) {
                ErrorHandling.displayStackTrace(ex);
            }
            return false;
        }
    }

    public boolean deleteRecord(int mid) {
        try {
            String query = "delete from manufacturerinfo ";
            query += " where mid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, mid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (!errormessage.contains("foreign key constraint fails")) {
                ErrorHandling.displayStackTrace(ex);
            }
            return false;
        }
    }

    public ManufacturerInfo getRecord(int mid) {
        try {
            String query = "select mid , name , address , contactno , emailid ";
            query += " from manufacturerinfo ";
            query += " where mid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, mid);
            ManufacturerInfo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ManufacturerInfo();
                result.setMID(rs.getInt("mid"));
                result.setName(rs.getString("name"));
                result.setAddress(rs.getString("address"));
                result.setContactno(rs.getString("contactno"));
                result.setEmailid(rs.getString("emailid"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<ManufacturerInfo> getAllRecord() {
        try {
            String query = "select mid , name , address , contactno , emailid ";
            query += " from manufacturerinfo ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<ManufacturerInfo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ManufacturerInfo res = new ManufacturerInfo();
                    res.setMID(rs.getInt("mid"));
                    res.setName(rs.getString("name"));
                    res.setAddress(rs.getString("address"));
                    res.setContactno(rs.getString("contactno"));
                    res.setEmailid(rs.getString("emailid"));
                    result.add(res);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }
}
