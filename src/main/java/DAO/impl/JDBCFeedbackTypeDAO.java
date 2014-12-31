package DAO.impl;

import DAO.model.FeedbackType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class JDBCFeedbackTypeDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public String getFeedbackType(int feedbackTypeID) {
        String sql = "SELECT FeedbackType FROM FeedbackType WHERE FeedbackTypeID = ?";

        String feedbackType = null;

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, feedbackTypeID);
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                feedbackType = result.getString("FeedbackType");
            }
            result.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {}
            }
        }
        return feedbackType;
    }
}
