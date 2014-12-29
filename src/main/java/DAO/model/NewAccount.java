package DAO.model;

/**
 * Created by btaylor5 on 12/28/14.
 *
 * Model to help bind data for a POST
 */
public class NewAccount {
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email;
    private int PC;
    private String InitiationNumber;
    private String CellNumber;
    private String HighSchool;
    private String HomeAddress;
    private String major;
    private String password;
    private String password_confirm;
    private String MagicPhrase;
    private String Title;
    private String ParentFname;
    private String ParentLname;
    private String ParentEmail;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public String getInitiationNumber() {
        return InitiationNumber;
    }

    public void setInitiationNumber(String initiationNumber) {
        InitiationNumber = initiationNumber;
    }

    public String getCellNumber() {
        return CellNumber;
    }

    public void setCellNumber(String cellNumber) {
        CellNumber = cellNumber;
    }

    public String getHighSchool() {
        return HighSchool;
    }

    public void setHighSchool(String highSchool) {
        HighSchool = highSchool;
    }

    public String getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        HomeAddress = homeAddress;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }


    public String getMagicPhrase() {
        return MagicPhrase;
    }

    public void setMagicPhrase(String magicPhrase) {
        MagicPhrase = magicPhrase;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getParentFname() {
        return ParentFname;
    }

    public void setParentFname(String parentFname) {
        ParentFname = parentFname;
    }

    public String getParentLname() {
        return ParentLname;
    }

    public void setParentLname(String parentLname) {
        ParentLname = parentLname;
    }

    public String getParentEmail() {
        return ParentEmail;
    }

    public void setParentEmail(String parentEmail) {
        ParentEmail = parentEmail;
    }
}
