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

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, memberID);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Parent parent = new Parent(
                        result.getInt("TitleID"),
                        result.getString("ParentFname"),
                        result.getString("ParentLname"),
                        result.getString("ParentEmail")
                );
                result.close();
                ps.close();
                return parent;
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
        return null; //We will burn in hell if it gets here
    }

}
