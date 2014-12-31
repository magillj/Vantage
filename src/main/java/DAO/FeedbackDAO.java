package DAO;

import DAO.model.Feedback;

import java.util.ArrayList;

/**
 * Created by btaylor5 on 12/30/14.
 */
public interface FeedbackDAO {
    public void insert(Feedback feedback);
    public ArrayList<Feedback> getFeedback(int announcementID);
}
