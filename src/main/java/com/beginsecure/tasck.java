package com.beginsecure;

import java.io.Serializable;

public class tasck implements Serializable {
    String UserName;
    String Title;
    String Description;

    public tasck(String userName, String title, String description) {
        UserName = userName;
        Title = title;
        Description = description;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
