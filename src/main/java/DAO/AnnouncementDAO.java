package DAO;

import DAO.model.Announcement;

/**
 * Created by btaylor5 on 12/30/14.
 */
public interface AnnouncementDAO {

    public void insert(Announcement announcement);
    public Announcement lookUpByID(int announcementID);

}
