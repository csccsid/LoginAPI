package com.loginapi.loginapi.util;

import javax.lang.model.element.NestingKind;

//返回json的工具类
public class returnjson
{
    public static jsonpack result(Integer code, String msg)
    {
        jsonpack jsonpack = new jsonpack();
        jsonpack.setcode(code);
        jsonpack.setmsg(msg);
        return jsonpack;
    }

    public static<T> jsonpack tokenresult(Integer code, String msg, T data)
    {
        jsonpack jsonpack = new jsonpack();
        jsonpack.setcode(code);
        jsonpack.setmsg(msg);
        jsonpack.setdata(data);
        return jsonpack;
    }
}
