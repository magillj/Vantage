package DAO;

import DAO.model.Duty;

import java.util.ArrayList;

/**
 * Created by btaylor5 on 12/31/14.
 */
public interface DutyDAO {
    public void insert(Duty duty);
    public ArrayList<Duty> getActiveDuties();
}
