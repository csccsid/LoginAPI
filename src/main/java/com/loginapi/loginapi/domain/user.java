package com.loginapi.loginapi.domain;

public class user
{
    private int id;
    private String account;
    private String password;

    public int getId()
    {
        return id;
    }
    public String getAccount()
    {
        return account;
    }
    public String getPassword()
    {
        return password;
    }

    public void setAccount( String account)
    {
        this.account=account;
    }
    public void setPassword( String password)
    {
        this.password=password;
    }
}
