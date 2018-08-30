package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.CategoryInfo;
import utility.ErrorHandling;

public class CategoryInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(CategoryInfo record) {
        try {
            String query = "insert into categoryinfo ";
            query += " (categoryid,categoryname) ";
            query += " values(?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryid());
            stmt.setString(2, record.getCategoryname());
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

    public boolean updateRecord(CategoryInfo record) {
        try {
            String query = "update categoryinfo ";
            query += " set categoryname=? ";
            query += " where categoryid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryname());
            stmt.setString(2, record.getCategoryid());
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

    public boolean deleteRecord(String categoryid) {
        try {
            String query = "delete from categoryinfo ";
            query += " where categoryid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, categoryid);
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

    public CategoryInfo getRecord(String categoryid) {
        try {
            String query = "select categoryid , categoryname ";
            query += " from categoryinfo ";
            query += " where categoryid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, categoryid);
            CategoryInfo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new CategoryInfo();
                result.setCategoryid(rs.getString("categoryid"));
                result.setCategoryname(rs.getString("categoryname"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<CategoryInfo> getAllRecord() {
        try {
            String query = "select categoryid , categoryname ";
            query += " from categoryinfo ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<CategoryInfo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    CategoryInfo res = new CategoryInfo();
                    res.setCategoryid(rs.getString("categoryid"));
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
