package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.TruckInfo;
import utility.ErrorHandling;

public class TruckInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(TruckInfo record) {
        try {
            String query = "insert into truckinfo ";
            query += " (truckno,chassisno,capacity,weight) ";
            query += " values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getTruckno());
            stmt.setString(2, record.getChassisno());
            stmt.setFloat(3, record.getCapacity());
            stmt.setFloat(4, record.getWeight());
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

    public boolean updateRecord(TruckInfo record) {
        try {
            String query = "update truckinfo ";
            query += " set chassisno=?,capacity=?,weight=? ";
            query += " where truckno = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getChassisno());
            stmt.setFloat(2, record.getCapacity());
            stmt.setFloat(3, record.getWeight());
            stmt.setString(4, record.getTruckno());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(String truckno) {
        try {
            String query = "delete from truckinfo ";
            query += " where truckno = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, truckno);
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

    public TruckInfo getRecord(String truckno) {
        try {
            String query = "select truckno , chassisno , capacity , weight ";
            query += " from truckinfo ";
            query += " where truckno = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, truckno);
            TruckInfo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TruckInfo();
                result.setTruckno(rs.getString("truckno"));
                result.setChassisno(rs.getString("chassisno"));
                result.setCapacity(rs.getFloat("capacity"));
                result.setWeight(rs.getFloat("weight"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<TruckInfo> getAllRecord() {
        try {
            String query = "select truckno , chassisno , capacity , weight ";
            query += " from truckinfo ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<TruckInfo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TruckInfo res = new TruckInfo();
                    res.setTruckno(rs.getString("truckno"));
                    res.setChassisno(rs.getString("chassisno"));
                    res.setCapacity(rs.getFloat("capacity"));
                    res.setWeight(rs.getFloat("weight"));
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

    public List<TruckInfo> getAllRecord(Date journeydate) {
        try {
            String query = "select truckno , chassisno , capacity , weight ";
            query += " from truckinfo ";
            query += " where truckno not in ( select truckno from (\n"
                    + "select truckno , tourdate , adddate( tourdate, interval noofdays day ) as EndDate\n"
                    + "from tourschedule ) t\n"
                    + "where ? between tourdate and enddate)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setDate(1, journeydate);
            List<TruckInfo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TruckInfo res = new TruckInfo();
                    res.setTruckno(rs.getString("truckno"));
                    res.setChassisno(rs.getString("chassisno"));
                    res.setCapacity(rs.getFloat("capacity"));
                    res.setWeight(rs.getFloat("weight"));
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
