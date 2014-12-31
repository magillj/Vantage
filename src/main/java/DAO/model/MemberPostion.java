package DAO.model;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class MemberPostion {
    private int memberPosID;
    private int positionID;
    private String startQtr;
    private String startYear;
    private String endQtr;
    private String endYear;
    private int memberID;


    public MemberPostion(int memberPosID, int positionID, String startQtr, String startYear, String endQtr, String endYear, int memberID) {
        this.memberPosID = memberPosID;
        this.positionID = positionID;
        this.startQtr = startQtr;
        this.startYear = startYear;
        this.endQtr = endQtr;
        this.endYear = endYear;
        this.memberID = memberID;
    }

    public int getMemberPosID() {
        return memberPosID;
    }

    public void setMemberPosID(int memberPosID) {
        this.memberPosID = memberPosID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getStartQtr() {
        return startQtr;
    }

    public void setStartQtr(String startQtr) {
        this.startQtr = startQtr;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndQtr() {
        return endQtr;
    }

    public void setEndQtr(String endQtr) {
        this.endQtr = endQtr;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

}
