package DAO;

import DAO.model.Title;

/**
 * Created by btaylor5 on 12/23/14.
 */
public interface TitleDAO {
    public void insert(Title title);
    public Title lookUpTitle(int titleID);
    public int lookUpID(String title);
    public int lookUpOrInsert(String p_title);
}
