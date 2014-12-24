package DAO;

import DAO.model.Major;

/**
 * Created by btaylor5 on 12/23/14.
 */
public interface MajorDAO {
    public void insert(Major major);
    public Major lookUpMajor(int majorID);
}
