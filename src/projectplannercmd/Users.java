/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectplannercmd;

/**
 *
 * @author aleks
 */
public class Users {
    private String userID;
    private String firstName;
    private String surName;
    private String password;
    private String email;
    private String jobTitel;
    private int userLevel;
    
    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the jobTitel
     */
    public String getJobTitel() {
        return jobTitel;
    }

    /**
     * @param jobTitel the jobTitel to set
     */
    public void setJobTitel(String jobTitel) {
        this.jobTitel = jobTitel;
    }

    /**
     * @return the userLevel
     */
    public int getUserLevel() {
        return userLevel;
    }

    /**
     * @param userLevel the userLevel to set
     */
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }
    
}
