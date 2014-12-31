package DAO.impl;

import DAO.ParentDAO;
import DAO.model.Parent;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by btaylor5 on 12/23/14.
 *
 */
public class JDBCParentDAO implements ParentDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Parent parent) {
        String sql = "INSERT INTO Parent " +
                "(" +
                "TitleID," +
                "ParentFname, " +
                "ParentLname, " +
                "ParentEmail" +
                ")" +
                "VALUES" +
                "(?, ?, ?, ?)";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,parent.getTitleID());
            ps.setString(2, parent.getParentFname());
            ps.setString(3, parent.getParentLname());
            ps.setString(4, parent.getParentEmail());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    public Parent lookUpParent(int memberID) {
        String sql = "SELECT * FROM Parent WHERE ParentID = ?";

        Parent parent = null;

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, memberID);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                parent = new Parent(
                        result.getInt("TitleID"),
                        result.getString("ParentFname"),
                        result.getString("ParentLname"),
                        result.getString("ParentEmail")
                );
                result.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {}
            }
        }
        return parent;
    }

    // will return 0 if not present
    public int lookUpIDByEmail(String p_email) {
        String sql = "SELECT * FROM Parent WHERE ParentEmail = ?";

        Connection connection = null;
        int parentID = 0;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p_email);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                parentID = result.getInt("TitleID");
                result.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {}
            }
        }
        return parentID;
    }
}
