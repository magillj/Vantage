package DAO.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by btaylor5 on 12/23/14.
 *
 * NOTE: all getters and setters were auto-generated.
 */
public class Member {

    private int MemberID;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email;
    private int PC;
    private String InitationNumber;
    private String CellNumber;
    private String HighSchool;
    private String HomeAddress;
    private int ParentID;
    private int MajorID;
    private String unhashedPass;
    private byte[] PasswordHash;
    private byte[] PasswordSalt;
    private String MagicPhrase;

    public Member(String firstName, String middleName, String lastName, String email, int pc, String initiationNumber, String cellNumber, String highSchool, String homeAddress, int parentID, int majorID, byte[] passwordHash, byte[] passwordSalt) {
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Email = email;
        PC = pc;
        InitationNumber = initiationNumber;
        CellNumber = cellNumber;
        HighSchool = highSchool;
        HomeAddress = homeAddress;
        ParentID = parentID;
        MajorID = majorID;
        PasswordHash = passwordHash;
        PasswordSalt = passwordSalt;
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int memberID) {
        MemberID = memberID;
    }

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

    public String getInitationNumber() {
        return InitationNumber;
    }

    public void setInitationNumber(String initationNumber) {
        InitationNumber = initationNumber;
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

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int parentID) {
        ParentID = parentID;
    }

    public int getMajorID() {
        return MajorID;
    }

    public void setMajorID(int majorID) {
        MajorID = majorID;
    }

    public byte[] getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        PasswordHash = passwordHash;
    }

    public byte[] getPasswordSalt() {
        return PasswordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        PasswordSalt = passwordSalt;
    }

    public String getUnhashedPass() {
        return unhashedPass;
    }

    public void setUnhashedPass(String unhashedPass) {
        this.unhashedPass = unhashedPass;
    }

    public String getMagicPhrase() {
        return MagicPhrase;
    }

    public void setMagicPhrase(String magicPhrase) {
        MagicPhrase = magicPhrase;
    }

    /*
            @Param: String Password
            @return: byte[], a hashed value of the Password Argument

            Will hash the string passed into it using the SHA-256 Algorithm, returning the byte[] as UTF-8

            Proper use: Hash the password + salt!!!
                        * Create the salt with the generateSalt() method. You will also have to store the Salt in the database.
                        * The password stored in the database will be hashIt(password + salt)

         */
    public static byte[] hashIt(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            try {
                return digest.digest(password.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException b) {
                throw new RuntimeException(b);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] generateSalt() {
        final Random rand = new SecureRandom();
        byte[] salt = new byte[32];
        rand.nextBytes(salt);
        return salt;
    }

    // NOTE : I'm confusing myself as to to using objects that represent data in a database...
    // Code below may not make sense
    public boolean validateUser(String passwordAttempt) {
        return (getPasswordHash() == hashIt(passwordAttempt + getPasswordSalt()));
    }
}
