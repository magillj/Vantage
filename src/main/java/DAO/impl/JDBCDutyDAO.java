package DAO.impl;

import DAO.DutyDAO;
import DAO.model.Duty;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by btaylor5 on 12/31/14.
 */
public class JDBCDutyDAO implements DutyDAO {

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Duty duty) {
        String sql = "INSERT INTO Duty " +
                "(" +
                "DutyName, " +
                "DutyDesc, " +
                "Active," +
                "FineAmount," +
                "TargetedClass" +
                ")" +
                "VALUES" +
                "(?, ?, ?, ?, ?)";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, duty.getDutyName());
            ps.setString(2, duty.getDutyDesc());
            ps.setBoolean(3, duty.isActive());
            ps.setInt(4, duty.getFineAmount());
            ps.setString(5, duty.getTargetedClass());
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

    public ArrayList<Duty> getActiveDuties() {

        ArrayList<Duty> dutyResult = new ArrayList<Duty>();

        String sql = "SELECT * FROM Duty Where Active = TRUE ";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                dutyResult.add(new Duty(
                        result.getInt("DutyID"),
                        result.getString("DutyName"),
                        result.getString("DutyDesc"),
                        result.getBoolean("Active"),
                        result.getInt("FineAmount"),
                        result.getString("TargetedClass")
                ));
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
        return dutyResult;
    }

    public void updateDuty() {

    }
}
