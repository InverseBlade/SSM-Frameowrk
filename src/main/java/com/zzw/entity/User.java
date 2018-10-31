package com.zzw.entity;

public class User {

    private Integer id;

    private String userName;

    private String passwd;

    private String nickName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return String.format(
                "Id: %d,\nUserName: %s,\nNickName: %s,\nPassword: %s",
                id, userName, nickName, passwd);
    }
}
