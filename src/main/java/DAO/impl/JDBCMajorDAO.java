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

    public int lookUp(String p_major) {
        String sql = "SELECT * FROM Major WHERE Major = ?";

        Connection connection = null;
        int majorID = 0;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p_major);
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                majorID = result.getInt("MajorID");
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
        return majorID;
    }


    public int lookUpOrInsert(String p_major) {
        String sql = "SELECT * FROM Major WHERE Major = ?";

        Connection connection = null;
        int majorID = 0;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p_major);
            Major major = null;
            ResultSet result = ps.executeQuery();
            if (!(result.next())) {
                major = new Major(p_major);
                insert(major);
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
        majorID = lookUp(p_major);
        return majorID;
    }
}
