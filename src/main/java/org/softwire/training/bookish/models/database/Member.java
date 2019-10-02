package org.softwire.training.bookish.models.database;

public class Member {
    String UserId;
    String UserName;
    String Pass;
    String Named;
    int TransacId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getNamed() {
        return Named;
    }

    public void setNamed(String named) {
        Named = named;
    }

    public int getTransacId() {
        return TransacId;
    }

    public void setTransacId(int transacId) {
        TransacId = transacId;
    }


}
