package DAO.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by btaylor5 on 12/31/14.
 */

public class Duty {
    private int dutyID;
    private String dutyName;
    private String dutyDesc;
    private boolean active;
    private int fineAmount;
    private String targetedClass;

    public Duty(String dutyName, String dutyDesc, Boolean active, int fineAmount, String targetedClass) {
        this.dutyName = dutyName;
        this.dutyDesc = dutyDesc;
        this.active = active;
        this.fineAmount = fineAmount;
        this.targetedClass = targetedClass;
    }

    public Duty(int dutyID, String dutyName, String dutyDesc, Boolean active, int fineAmount, String targetedClass) {
        this.dutyID = dutyID;
        this.dutyName = dutyName;
        this.dutyDesc = dutyDesc;
        this.active = active;
        this.fineAmount = fineAmount;
        this.targetedClass = targetedClass;
    }

    public int getDutyID() {
        return dutyID;
    }

    public void setDutyID(int dutyID) {
        this.dutyID = dutyID;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getDutyDesc() {
        return dutyDesc;
    }

    public void setDutyDesc(String dutyDesc) {
        this.dutyDesc = dutyDesc;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getFineAmount() {
        return fineAmount;
    }
    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getTargetedClass() {
        return targetedClass;
    }

    public void setTargetedClass(String targetedClass) {
        this.targetedClass = targetedClass;
    }
}
