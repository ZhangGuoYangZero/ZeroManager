package com.manager.mag.controller;

import com.manager.mag.base.BaseController;
import com.manager.mag.service.UserService;
import com.manager.mag.utils.CookieUtil;
import com.manager.mag.vo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


//继承通用控制器 --继承base包
@Controller
public class IndexController extends BaseController {
    @Resource
    private UserService userService = null;



    /**
     * 系统登录页
     * @param
     * @return String
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }


    /**
     * 系统界面欢迎页
     * @return String
     */
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 后端管理主页面
     * @param
     * @return String
     */
    @RequestMapping("main")
    public String main(HttpServletRequest request){

        //Session存真名
        //只有cookie 可以获取拿到的对象，从cookie拿到id,
        Integer ID = Integer.parseInt(CookieUtil.getCookieValue(request,"ID"));
        //用这个id去查询user实体
        User user = userService.selectByPrimaryKey(ID);
        request.getSession().setAttribute("user",user);

        //查询该用户所拥有的权限，并用session保存
        request.getSession().setAttribute("profile",this.userService.queryProfileByid(ID));

        return "main";
    }
}
