package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.DriverInfo;
import utility.ErrorHandling;

public class DriverInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(DriverInfo record) {
        try {
            String query = "insert into driverinfo ";
            query += " (drivername,licenceno,expirydate,contactno,address) ";
            query += " values(?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getDrivername());
            stmt.setString(2, record.getLicenceno());
            stmt.setDate(3, record.getExpirydate());
            stmt.setString(4, record.getContactno());
            stmt.setString(5, record.getAddress());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(DriverInfo record) {
        try {
            String query = "update driverinfo ";
            query += " set drivername=?,licenceno=?,expirydate=?,contactno=?,address=? ";
            query += " where driverid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getDrivername());
            stmt.setString(2, record.getLicenceno());
            stmt.setDate(3, record.getExpirydate());
            stmt.setString(4, record.getContactno());
            stmt.setString(5, record.getAddress());
            stmt.setInt(6, record.getDriverid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int driverid) {
        try {
            String query = "delete from driverinfo ";
            query += " where driverid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, driverid);
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

    public DriverInfo getRecord(int driverid) {
        try {
            String query = "select driverid , drivername , licenceno , expirydate , contactno , address ";
            query += " from driverinfo ";
            query += " where driverid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, driverid);
            DriverInfo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new DriverInfo();
                result.setDriverid(rs.getInt("driverid"));
                result.setDrivername(rs.getString("drivername"));
                result.setLicenceno(rs.getString("licenceno"));
                result.setExpirydate(rs.getDate("expirydate"));
                result.setContactno(rs.getString("contactno"));
                result.setAddress(rs.getString("address"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<DriverInfo> getAllRecord() {
        try {
            String query = "select driverid , drivername , licenceno , expirydate , contactno , address ";
            query += " from driverinfo ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<DriverInfo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    DriverInfo res = new DriverInfo();
                    res.setDriverid(rs.getInt("driverid"));
                    res.setDrivername(rs.getString("drivername"));
                    res.setLicenceno(rs.getString("licenceno"));
                    res.setExpirydate(rs.getDate("expirydate"));
                    res.setContactno(rs.getString("contactno"));
                    res.setAddress(rs.getString("address"));
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

    public List<DriverInfo> getAllRecord(Date journeydate) {
        try {
            String query = "select driverid , drivername , licenceno , expirydate , contactno , address ";
            query += " from driverinfo ";
            query += " where driverid not in ( select driverid from (\n"
                    + "select driverid , tourdate , adddate( tourdate, interval noofdays day ) as EndDate\n"
                    + "from tourschedule ) t\n"
                    + "where ? between tourdate and enddate )";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setDate(1, journeydate);
            List<DriverInfo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    DriverInfo res = new DriverInfo();
                    res.setDriverid(rs.getInt("driverid"));
                    res.setDrivername(rs.getString("drivername"));
                    res.setLicenceno(rs.getString("licenceno"));
                    res.setExpirydate(rs.getDate("expirydate"));
                    res.setContactno(rs.getString("contactno"));
                    res.setAddress(rs.getString("address"));
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
