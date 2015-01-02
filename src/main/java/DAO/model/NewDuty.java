package DAO.model;

/**
 * Created by btaylor5 on 1/1/15.
 */
public class NewDuty {
    private int DutyID;
    private String DutyName;
    private String DutyDesc;
    private boolean Active;
    private int FineAmount;
    private String TargetedClass;


    public int getDutyID() {
        return DutyID;
    }

    public void setDutyID(int dutyID) {
        DutyID = dutyID;
    }

    public String getDutyName() {
        return DutyName;
    }

    public void setDutyName(String dutyName) {
        DutyName = dutyName;
    }

    public String getDutyDesc() {
        return DutyDesc;
    }

    public void setDutyDesc(String dutyDesc) {
        DutyDesc = dutyDesc;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public int getFineAmount() {
        return FineAmount;
    }

    public void setFineAmount(int fineAmount) {
        FineAmount = fineAmount;
    }

    public String getTargetedClass() {
        return TargetedClass;
    }

    public void setTargetedClass(String targetedClass) {
        TargetedClass = targetedClass;
    }
}
