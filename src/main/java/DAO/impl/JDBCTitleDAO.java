package DAO.impl;

import DAO.TitleDAO;
import DAO.model.Title;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by btaylor5 on 12/23/14.
 */
public class JDBCTitleDAO implements TitleDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Title title) {
        String sql = "INSERT INTO Title " +
                "(" +
                "Title" +
                ")" +
                "VALUES" +
                "(?)";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title.getTitle());
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

    public Title lookUpTitle(int titleID) {
        String sql = "SELECT * FROM Title WHERE TitleID = ?";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, titleID);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Title title = new Title(
                        result.getString("Title")
                );
                result.close();
                ps.close();
                return title;
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

    public int lookUpID(String title) {
        String sql = "SELECT * FROM Title WHERE Title = ?";

        Connection connection = null;
        int titleID = 0;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                titleID = result.getInt("TitleID");
            } else {
                return 0;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {}
            }
        }
        return titleID;
    }

    public int lookUpOrInsert(String p_title) {
        String sql = "SELECT * FROM Title WHERE Title = ?";

        Connection connection = null;
        int titleID = 0;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p_title);
            ResultSet result = ps.executeQuery();
            if (!result.next() ) { //resultSet is empty, so insert
                Title title = new Title(p_title);
                insert(title);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {}
            }
        }
        titleID = lookUpID(p_title);
        return titleID;
    }



}
