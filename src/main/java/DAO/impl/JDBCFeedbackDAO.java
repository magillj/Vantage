package DAO.impl;

import DAO.FeedbackDAO;
import DAO.model.Announcement;
import DAO.model.Feedback;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class JDBCFeedbackDAO implements FeedbackDAO{
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Feedback feedback) {
        String sql = "INSERT INTO Feedback " +
                "(" +
                "FeedbackID," +
                "AnnouncementID, " +
                "MemberID, " +
                "Feedback" +
                ")" +
                "VALUES" +
                "(?, ?, ?, ?)";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,feedback.getFeedbackID());
            ps.setInt(2, feedback.getAnnouncementID());
            ps.setInt(3, feedback.getMemberID());
            ps.setString(4, feedback.getFeedback());
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

    /*
        Pass in the AnnouncementID and it will return an arrayList of all the feedback
     */
    public ArrayList<Feedback> getFeedback(int announcementID) {
        String sql = "SELECT * FROM Feedback WHERE AnnouncementID = ?";

        ArrayList<Feedback> feedbackList = null;

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, announcementID);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                Feedback feedback = new Feedback(
                        result.getInt("FeedbackID"),
                        result.getInt("AnnouncementID"),
                        result.getInt("MemberID"),
                        result.getString("Feedback")
                );
                feedbackList.add(feedback);
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
        return feedbackList;
    }
}
