package DAO.impl;

import DAO.MajorDAO;
import DAO.model.Major;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by btaylor5 on 12/23/14.
 *
 */
public class JDBCMajorDAO implements MajorDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Major major) {
            String sql = "INSERT INTO Major " +
                    "(Major)" +
                    "VALUES" +
                    "(?)";

            Connection connection = null;

            try {
                connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, major.getMajor());
                ps.executeUpdate();
                ps.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ignore) {
                    }
                }
            }
        }

    public Major lookUpMajor(int majorID) {
        String sql = "SELECT * FROM Major WHERE MajorID = ?";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, majorID);
            Major major = null;
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                major = new Major(
                        result.getString("major")
                );
                result.close();
                ps.close();
                return major;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {}
            }
        }
        return null; //We will burn in hell if it gets here
    }
}
