package DAO.impl;

import DAO.model.Announcement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class JDBCAnnouncementDAO  {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Announcement announcement) {
        String sql = "INSERT INTO Announcement " +
                "(" +
                "AnnouncementID," +
                "MemberID, " +
                "EventTitle, " +
                "Message," +
                "StartTime," +
                "EndTime," +
                "Expiration," +
                "FeedbackTypeID" +
                ")" +
                "VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, announcement.getAnnouncementID());
            ps.setInt(2, announcement.getMemberID());
            ps.setString(3, announcement.getEventTitle());
            ps.setString(4, announcement.getMessage());
            ps.setDate(5, announcement.getStartTime());
            ps.setDate(6, announcement.getEndTime());
            ps.setDate(7, announcement.getExpiration());
            ps.setInt(8, announcement.getFeedbackTypeID());
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

    public Announcement lookUpByID(int announcementID) {
        String sql = "SELECT AnnouncementID FROM Announcement WHERE AnnouncementID = ?";

        Announcement announcement = null;

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, announcementID);
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                announcement = new Announcement(
                        result.getInt("AnnouncementID"),
                        result.getInt("MemberID"),
                        result.getString("EventTitle"),
                        result.getString("Message"),
                        result.getDate("StartTime"),
                        result.getDate("EndTime"),
                        result.getDate("ExpirationDate"),
                        result.getInt("FeedbackTypeID")
                );
                result.close();
                ps.close();
            }
        } catch(SQLException e) {
            throw new RuntimeException();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException ignore) {}
            }
        }
        return announcement;
    }
}
