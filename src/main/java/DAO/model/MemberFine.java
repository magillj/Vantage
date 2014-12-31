package DAO.model;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class MemberFine {

    private int memberFineID;
    private int fineTypeID;
    private int memberID;

    public int getMemberFineID() {
        return memberFineID;
    }

    public void setMemberFineID(int memberFineID) {
        this.memberFineID = memberFineID;
    }

    public int getFineTypeID() {
        return fineTypeID;
    }

    public void setFineTypeID(int fineTypeID) {
        this.fineTypeID = fineTypeID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public MemberFine(int memberFineID, int fineTypeID, int memberID) {

        this.memberFineID = memberFineID;
        this.fineTypeID = fineTypeID;
        this.memberID = memberID;
    }
}
