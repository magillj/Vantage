package DAO;

import DAO.model.Parent;

/**
 * Created by btaylor5 on 12/23/14.
 */
public interface ParentDAO {
    public void insert(Parent parent);
    public Parent lookUpParent(int parentID);
}
