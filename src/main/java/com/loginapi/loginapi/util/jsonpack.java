package com.loginapi.loginapi.util;

//json的打包工具类
public class jsonpack<T>
{
    private Integer code;
    private String msg;
    private T data;

    public void setcode(Integer code)
    {
        this.code=code;
    }
    public Integer getcode()
    {
        return code;
    }

    public void setmsg(String msg)
    {
        this.msg=msg;
    }
    public String getmsg()
    {
        return msg;
    }

    public void setdata(T data)
    {
        this.data=data;
    }
    public T getdata()
    {
        return data;
    }
}
