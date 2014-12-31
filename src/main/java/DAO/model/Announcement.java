package DAO.model;

import java.sql.Date;

/**
 * Created by btaylor5 on 12/30/14.
 *
 * NOTE, could be a potential problem using Date object... not sure if Spring will work well with Object Types like Date
 *
 */
public class Announcement {
    private int announcementID;
    private int memberID;
    private String eventTitle;
    private String message;
    private Date startTime;
    private Date endTime;
    private Date expiration;
    private int feedbackTypeID;

    public Announcement(int announcementID, int memberID, String eventTitle, String message, Date startTime, Date endTime, Date expiration, int feedbackTypeID) {
        this.announcementID = announcementID;
        this.memberID = memberID;
        this.eventTitle = eventTitle;
        this.message = message;
        this.startTime = startTime;
        this.endTime = endTime;
        this.expiration = expiration;
        this.feedbackTypeID = feedbackTypeID;
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

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public int getFeedbackTypeID() {
        return feedbackTypeID;
    }

    public void setFeedbackTypeID(int feedbackTypeID) {
        this.feedbackTypeID = feedbackTypeID;
    }
}
