package com.manager.mag.controller;

import com.manager.mag.base.BaseController;
import com.manager.mag.base.ResultInfo;
import com.manager.mag.exceptions.ParamsException;
import com.manager.mag.service.UserService;
import com.manager.mag.utils.CookieUtil;
import com.manager.mag.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")//模块分层路径，URL 要添加
public class UseController extends BaseController {
    //controller->service->dao
    //注入 userservice
    @Resource
    private UserService userService;




    /*
     登陆模块
    * */

    @PostMapping("login")//页面地址会走这里
    @ResponseBody
    //    调用的结果如何，并且返回给AJAX
    public ResultInfo userlogin(String uname, String pwd) {
        ResultInfo resultInfo = new ResultInfo();

        //通过try cathch 捕获调用的service层抛出的异常
        try {
            //调用service 的方法 Login方法
            //成功用resulutinfo带走 失败用resultinfo 带回异常
            User user = userService.User_Login(uname, pwd);
            //object对象在内部保存这个user对象
            resultInfo.setResult(user);


        } catch (ParamsException paramsException) {
            //设置状态码
            resultInfo.setCode(paramsException.getCode());
            //状态信息
            resultInfo.setMsg(paramsException.getMsg());
            //父类方法 打印路径
        } catch (Exception e) {
            resultInfo.setCode(500);
            resultInfo.setMsg(e.getMessage());
            e.getStackTrace();
        }

        return resultInfo;
    }

    //修改密码
    @PostMapping("updatePwd")
    @ResponseBody
    public ResultInfo updatepwd(HttpServletRequest request, String oldPassword,
                                String newPassword, String entPassword) {
        ResultInfo resultInfo  = new ResultInfo();
        try {
            //通过requet 获取requet中的cookie中的id
            Integer id = Integer.parseInt(CookieUtil.getCookieValue(request,"ID"));
            //调用Service的修改密码
            this.userService.upPwd(id,oldPassword,newPassword,entPassword);
            //调用service方法获取user
            User user = this.userService.selectByPrimaryKey(id);
            //
            resultInfo.setResult(user);
        }catch (ParamsException paramsException){
            resultInfo.setCode(500);
            resultInfo.setMsg(paramsException.getMsg());
            paramsException.getStackTrace();
        }catch (Exception exception){
            resultInfo.setCode(900);
            resultInfo.setMsg(exception.getMessage());
            exception.getStackTrace();
        }
        return  resultInfo;
    }

    @RequestMapping("toPasswordPage")
    public String toPassWordPage(){
        return "user/password";
    }

}
