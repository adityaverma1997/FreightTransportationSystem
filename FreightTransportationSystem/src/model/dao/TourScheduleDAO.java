package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import model.to.TourSchedule;
import utility.ErrorHandling;

public class TourScheduleDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(TourSchedule record) {
        try {
            String query = "insert into tourschedule ";
            query += " (truckno,customername,driverid,address,contactno,tourdate,charges,noofdays) ";
            query += " values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getTruckno());
            stmt.setString(2, record.getCustomername());
            stmt.setInt(3, record.getDriverid());
            stmt.setString(4, record.getAddress());
            stmt.setString(5, record.getContactno());
            stmt.setDate(6, record.getTourdate());
            stmt.setFloat(7, record.getCharges());
            stmt.setInt(8, record.getNoofdays());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(TourSchedule record) {
        try {
            String query = "update tourschedule ";
            query += " set truckno=?,customername=?,driverid=?,address=?,contactno=?,tourdate=?,charges=?,noofdays=? ";
            query += " where sid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getTruckno());
            stmt.setString(2, record.getCustomername());
            stmt.setInt(3, record.getDriverid());
            stmt.setString(4, record.getAddress());
            stmt.setString(5, record.getContactno());
            stmt.setDate(6, record.getTourdate());
            stmt.setFloat(7, record.getCharges());
            stmt.setInt(8, record.getNoofdays());
            stmt.setInt(9, record.getSID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int sid) {
        try {
            String query = "delete from tourschedule ";
            query += " where sid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, sid);
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

    public TourSchedule getRecord(int sid) {
        try {
            String query = "select sid , truckno , customername , driverid , address , contactno , tourdate , charges , noofdays ";
            query += " from tourschedule ";
            query += " where sid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, sid);
            TourSchedule result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TourSchedule();
                result.setSID(rs.getInt("sid"));
                result.setTruckno(rs.getString("truckno"));
                result.setCustomername(rs.getString("customername"));
                result.setDriverid(rs.getInt("driverid"));
                result.setAddress(rs.getString("address"));
                result.setContactno(rs.getString("contactno"));
                result.setTourdate(rs.getDate("tourdate"));
                result.setCharges(rs.getFloat("charges"));
                result.setNoofdays(rs.getInt("noofdays"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public TourSchedule getRecord(String truckno, int driverid, Date tourdate) {
        try {
            String query = "select sid , truckno , customername , driverid , address , contactno , tourdate , charges , noofdays ";
            query += " from tourschedule ";
            query += " where truckno = ? and driverid = ? and tourdate=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, truckno);
            stmt.setInt(2, driverid);
            stmt.setDate(3, tourdate);
            TourSchedule result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TourSchedule();
                result.setSID(rs.getInt("sid"));
                result.setTruckno(rs.getString("truckno"));
                result.setCustomername(rs.getString("customername"));
                result.setDriverid(rs.getInt("driverid"));
                result.setAddress(rs.getString("address"));
                result.setContactno(rs.getString("contactno"));
                result.setTourdate(rs.getDate("tourdate"));
                result.setCharges(rs.getFloat("charges"));
                result.setNoofdays(rs.getInt("noofdays"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<TourSchedule> getAllRecord() {
        try {
            String query = "select sid,truckno,customername,\n"
                    + "ts.driverid,drivername,ts.address,ts.contactno,tourdate,charges,noofdays\n"
                    + "from tourschedule ts\n"
                    + "join driverinfo di\n"
                    + "on ts.driverid=di.driverid";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<TourSchedule> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TourSchedule res = new TourSchedule();
                    res.setSID(rs.getInt("sid"));
                    res.setTruckno(rs.getString("truckno"));
                    res.setCustomername(rs.getString("customername"));
                    res.setDriverid(rs.getInt("driverid"));
                    res.setAddress(rs.getString("address"));
                    res.setContactno(rs.getString("contactno"));
                    res.setTourdate(rs.getDate("tourdate"));
                    res.setCharges(rs.getFloat("charges"));
                    res.setNoofdays(rs.getInt("noofdays"));
                    res.setDrivername(rs.getString("drivername"));
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

    public List<TourSchedule> getAllRecord(Date journeydate) {
        try {
            String query = "select truckno,\n"
                    + "ts.driverid,drivername,tourdate,noofdays\n"
                    + "from\n"
                    + "(select truckno , driverid , tourdate , noofdays , adddate( tourdate, interval noofdays day ) as EndDate , \n"
                    + "adddate( tourdate, interval -6 day ) as StartDate from tourschedule )ts join driverinfo di\n"
                    + "on ts.driverid=di.driverid where ? between startdate and enddate";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setDate(1, journeydate);
            List<TourSchedule> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TourSchedule res = new TourSchedule();
                    res.setTruckno(rs.getString("truckno"));
                    res.setDriverid(rs.getInt("driverid"));
                    res.setTourdate(rs.getDate("tourdate"));
                    res.setNoofdays(rs.getInt("noofdays"));
                    res.setDrivername(rs.getString("drivername"));
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
