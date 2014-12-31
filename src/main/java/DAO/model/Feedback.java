package DAO.model;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class Feedback {
    private int feedbackID;
    private int announcementID;
    private int memberID;
    private String feedback;

    public Feedback(int feedbackID, int announcementID, int memberID, String feedback) {
        this.feedbackID = feedbackID;
        this.announcementID = announcementID;
        this.memberID = memberID;
        this.feedback = feedback;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public int getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementID = announcementID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
