package com.loginapi.loginapi.API;

import com.loginapi.loginapi.domain.user;
import com.loginapi.loginapi.mapper.UserMapper;
import com.loginapi.loginapi.util.jsonpack;
import com.loginapi.loginapi.util.jwtutil;
import com.loginapi.loginapi.util.returnjson;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class userAPI
{
    @Autowired
    private UserMapper UserMapper;

    //注册
    @RequestMapping(value="register", method = RequestMethod.POST)
    public jsonpack register(@RequestBody user user)
    {
        //System.out.println(user.getAccount()+"    "+user.getPassword());
        try
        {
            UserMapper.Insert(user.getAccount(), user.getPassword());
        } catch (DuplicateKeyException e)
        {
            return returnjson.result(201, "该用户名已被注册");
        } catch (Exception e)
        {
            return returnjson.result(400, "未知异常");
        }
        return returnjson.result(200,"请求成功");
    }

    //登录
    @RequestMapping(value = "sign", method = RequestMethod.POST)
    //允许跨域
    @CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public jsonpack sign(@RequestBody user user, HttpSession session)
    {
        try
        {
            user userresult = UserMapper.select(user.getAccount());
            if(userresult ==null)
                return returnjson.result(202,"该用户不存在");
            else
            {
                if (user.getPassword().equals(userresult.getPassword()))
                {
                    //保存session
                    session.setAttribute("useraccount", user.getAccount());

                    //返回token
                    String jwttoken = jwtutil.createtoken(user.getId(), user.getAccount());
                    return returnjson.tokenresult(200,"登录成功", jwttoken);
                }
                else
                    return returnjson.result(203,"密码错误");
            }
        } catch (Exception e)
        {
            return returnjson.result(401,"登录失败");
        }
    }

    /*测试
    @RequestMapping(value = "/test")
    public String test()
    {
        return "成功";
    }
    */
}
