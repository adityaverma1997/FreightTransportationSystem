package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.ItemInfo;
import utility.ErrorHandling;

public class ItemInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(ItemInfo record) {
        try {
            String query = "insert into iteminfo ";
            query += " (categoryid,itemname,weight,mid) ";
            query += " values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryid());
            stmt.setString(2, record.getItemname());
            stmt.setFloat(3, record.getWeight());
            stmt.setInt(4, record.getMID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(ItemInfo record) {
        try {
            String query = "update iteminfo ";
            query += " set categoryid=?,itemname=?,weight=?,mid=? ";
            query += " where itemid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryid());
            stmt.setString(2, record.getItemname());
            stmt.setFloat(3, record.getWeight());
            stmt.setInt(4, record.getMID());
            stmt.setInt(5, record.getItemid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int itemid) {
        try {
            String query = "delete from iteminfo ";
            query += " where itemid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, itemid);
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

    public ItemInfo getRecord(int itemid) {
        try {
            String query = "select itemid , categoryid , itemname , weight , mid ";
            query += " from iteminfo ";
            query += " where itemid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, itemid);
            ItemInfo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ItemInfo();
                result.setItemid(rs.getInt("itemid"));
                result.setCategoryid(rs.getString("categoryid"));
                result.setItemname(rs.getString("itemname"));
                result.setWeight(rs.getFloat("weight"));
                result.setMID(rs.getInt("mid"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<ItemInfo> getAllRecord() {
        try {
            String query = "select itemid,ii.categoryid,categoryname,\n"
                    + "itemname,weight,ii.mid,name\n"
                    + "from iteminfo ii\n"
                    + "join manufacturerinfo mi\n"
                    + "on ii.mid=mi.mid\n"
                    + "join categoryinfo ci\n"
                    + "on ii.categoryid=ci.categoryid;";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<ItemInfo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ItemInfo res = new ItemInfo();
                    res.setItemid(rs.getInt("itemid"));
                    res.setCategoryid(rs.getString("categoryid"));
                    res.setItemname(rs.getString("itemname"));
                    res.setWeight(rs.getFloat("weight"));
                    res.setMID(rs.getInt("mid"));
                    res.setName(rs.getString("name"));
                    res.setCategoryname(rs.getString("categoryname"));
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
