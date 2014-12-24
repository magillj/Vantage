package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import DAO.MemberDAO;
import DAO.model.Member;


/**
 * Created by btaylor5 on 12/23/14.
 *
 * Reference : http://www.mkyong.com/spring/maven-spring-jdbc-example/
 */
public class JDBCMemberDAO implements MemberDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Member member) {
        String sql = "INSERT INTO Member " +
                "(" +
                "FirstName, " +
                "MiddleName, " +
                "LastName," +
                "Email, " +
                "PC, " +
                "InitationNumber, " +
                "CellNumber," +
                "HighSchool, " +
                "HomeAddress, " +
                "ParentID, " +
                "MajorID, " +
                "PasswordHash , " +
                "PasswordSalt" +
                ")" +
                "VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getMiddleName());
            ps.setString(3, member.getLastName());
            ps.setString(4, member.getEmail());
            ps.setInt(5, member.getPC());
            ps.setString(6, member.getInitationNumber());
            ps.setString(7, member.getCellNumber());
            ps.setString(8, member.getHighSchool());
            ps.setString(9, member.getHomeAddress());
            ps.setInt(10, member.getParentID());
            ps.setInt(11, member.getMajorID());
            ps.setBytes(12, member.getPasswordHash());
            ps.setBytes(13, member.getPasswordSalt());
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

    public Member lookUpMember(int memberID) {
        String sql = "SELECT * FROM Member WHERE MemberID = ?";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, memberID);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Member member = new Member(
                        result.getString("FirstName"),
                        result.getString("MiddleName"),
                        result.getString("LastName"),
                        result.getString("Email"),
                        result.getInt("PC"),
                        result.getString("InitiationNumber"),
                        result.getString("CellNumber"),
                        result.getString("HighSchool"),
                        result.getString("HomeAddress"),
                        result.getInt("ParentID"),
                        result.getInt("MajorID"),
                        result.getBytes("PasswordHash"),
                        result.getBytes("PasswordSalt")
                );
                result.close();
                ps.close();
                return member;
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
