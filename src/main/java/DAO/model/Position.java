package DAO.model;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class Position {
    private int postitionID;
    private String positionName;
    private int housePoints;

    public Position(int postitionID, String positionName, int housePoints) {
        this.postitionID = postitionID;
        this.positionName = positionName;
        this.housePoints = housePoints;
    }

    public int getPostitionID() {
        return postitionID;
    }

    public void setPostitionID(int postitionID) {
        this.postitionID = postitionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getHousePoints() {
        return housePoints;
    }

    public void setHousePoints(int housePoints) {
        this.housePoints = housePoints;
    }
}
