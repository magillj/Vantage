package DAO.model;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class FineType {
    private int fineTypeID;
    private String fineName;
    private String fineDesc;
    private int amount;

    public FineType(int fineTypeID, String fineName, String fineDesc, int amount) {
        this.fineTypeID = fineTypeID;
        this.fineName = fineName;
        this.fineDesc = fineDesc;
        this.amount = amount;
    }

    public int getFineTypeID() {
        return fineTypeID;
    }

    public void setFineTypeID(int fineTypeID) {
        this.fineTypeID = fineTypeID;
    }

    public String getFineName() {
        return fineName;
    }

    public void setFineName(String fineName) {
        this.fineName = fineName;
    }

    public String getFineDesc() {
        return fineDesc;
    }

    public void setFineDesc(String fineDesc) {
        this.fineDesc = fineDesc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
