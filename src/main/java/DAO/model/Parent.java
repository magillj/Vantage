package DAO.model;

/**
 * Created by btaylor5 on 12/23/14.
 *
 */
public class Parent {
    private int parentID;
    private int titleID;
    private String parentFname;
    private String parentLname;
    private String parentEmail;

    public Parent(int titleID, String parentFname, String parentLname, String parentEmail) {
        this.titleID = titleID;
        this.parentFname = parentFname;
        this.parentLname = parentLname;
        this.parentEmail = parentEmail;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public int getTitleID() {
        return titleID;
    }

    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }

    public String getParentFname() {
        return parentFname;
    }

    public void setParentFname(String parentFname) {
        this.parentFname = parentFname;
    }

    public String getParentLname() {
        return parentLname;
    }

    public void setParentLname(String parentLname) {
        this.parentLname = parentLname;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }
}
