package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.TourItems;
import utility.ErrorHandling;

public class TourItemsDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(TourItems record) {
        try {
            String query = "insert into touritems ";
            query += " (sid,itemid,quantity) ";
            query += " values(?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getSID());
            stmt.setInt(2, record.getItemid());
            stmt.setInt(3, record.getQuantity());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(TourItems record) {
        try {
            String query = "update touritems ";
            query += " set sid=?,itemid=?,quantity=? ";
            query += " where tiid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getSID());
            stmt.setInt(2, record.getItemid());
            stmt.setInt(3, record.getQuantity());
            stmt.setInt(4, record.getTIID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int tiid) {
        try {
            String query = "delete from touritems ";
            query += " where tiid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, tiid);
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

    public TourItems getRecord(int tiid) {
        try {
            String query = "select tiid , sid , itemid , quantity ";
            query += " from touritems ";
            query += " where tiid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, tiid);
            TourItems result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TourItems();
                result.setTIID(rs.getInt("tiid"));
                result.setSID(rs.getInt("sid"));
                result.setItemid(rs.getInt("itemid"));
                result.setQuantity(rs.getInt("quantity"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<TourItems> getAllRecord() {
        try {
            String query = "select tiid,ti.sid,customername,\n"
                    + "ti.itemid,itemname,quantity\n"
                    + "from touritems ti\n"
                    + "join tourschedule ts\n"
                    + "on ti.sid=ts.sid\n"
                    + "join iteminfo ii\n"
                    + "on ti.itemid=ii.itemid;";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<TourItems> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TourItems res = new TourItems();
                    res.setTIID(rs.getInt("tiid"));
                    res.setSID(rs.getInt("sid"));
                    res.setItemid(rs.getInt("itemid"));
                    res.setQuantity(rs.getInt("quantity"));
                    res.setCustomername(rs.getString("customername"));
                    res.setItemname(rs.getString("itemname"));
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
