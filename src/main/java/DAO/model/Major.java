package DAO.model;

/**
 * Created by btaylor5 on 12/23/14.
 */
public class Major {

    private int majorID;
    private String major;

    public Major (String major) {
        this.major = major;
    }
    public int getMajorID() {
        return majorID;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
