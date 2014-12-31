package DAO.model;

/**
 * Created by btaylor5 on 12/30/14.
 */
public class FeedbackType {
    private int feedbackTypeID;
    private String feedbackType;

    public FeedbackType(int feedbackTypeID, String feedbackType) {
        this.feedbackTypeID = feedbackTypeID;
        this.feedbackType = feedbackType;
    }

    public int getFeedbackTypeID() {
        return feedbackTypeID;
    }

    public void setFeedbackTypeID(int feedbackTypeID) {
        this.feedbackTypeID = feedbackTypeID;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

}
