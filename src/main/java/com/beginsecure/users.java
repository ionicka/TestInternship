package com.beginsecure;

import java.io.Serializable;

public class users implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    String FirstName;
    String LastName;
    String UserName;

    public int getCountTasck() {
        return CountTasck;
    }

    public void setCountTasck(int countTasck) {
        CountTasck = countTasck+1;
    }

    int CountTasck;

    public users(String firstName, String lastName, String userName,int CountTask) {
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        CountTasck = CountTask;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void write(){

    }
}
