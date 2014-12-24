package DAO.model;

/**
 * Created by btaylor5 on 12/23/14.
 */
public class Title {
    private int titleID;
    private String title; //Title as in Mr, Ms, Mrs., Dr.

    public Title(String title) {
        this.title = title;
    }

    public int getTitleID() {
        return titleID;
    }

    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
