package com.manager.mag.service;

import com.github.pagehelper.util.StringUtil;
import com.manager.mag.base.BaseService;
import com.manager.mag.dao.UserMapper;
import com.manager.mag.utils.AssertUtil;
import com.manager.mag.vo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends BaseService<User, Integer> {
    //controller->service->dao
    //注入dao
    @Resource
    UserMapper userMapper;

    /* 不知有没有返回值，但是用于登陆逻辑的判断
      1.参数判断
     用户姓名 非空判断
     用户密码 非空判断
             2.账号判断
     返回用户对象，0 或1
             密码判断
     用返回的用户对象的密码 比较 输入的密码
     如果密码正确就登陆成功，否则返回登陆失败*/
    public User User_Login(String uname, String password) {
        //用户姓名 非空判断 用户密码 非空判断
        checkIsnull(uname, password);
        //查询返回用户对象，0 或1
        User user = null;
        user = userMapper.queryUserByname(uname);
        //比较
        AssertUtil.isTrue(user == null, "不存在这个用户");
        //密码判断
        AssertUtil.isTrue(!user.getPassword().equals(password), "密码错误");
        //校验正确，准备对象返回 -- 由于没有额外单独的信息 就不用封装类
        return user;


    }


    private void checkIsnull(String uname, String password) {
        //controller调用，会抛给controller
        AssertUtil.isTrue(StringUtil.isEmpty(uname), "用户名不能为空");
        AssertUtil.isTrue(StringUtil.isEmpty(password), "密码不能为空");
    }


    //修改密码模块
    //开启事务(issue
    @Transactional(propagation = Propagation.REQUIRED)
    public void upPwd(Integer id, String oldPassword, String newPassword, String entPassword) {

        //2.通过ID查询用户记录，返回用户对象
        User user = userMapper.selectByPrimaryKey(id);
        AssertUtil.isTrue(user == null, "用户id不存在");
        //3检查密码
        checkParament(user, oldPassword, newPassword, entPassword);
        user.setPassword(newPassword);
        //4.更新密码
        AssertUtil.isTrue( this.userMapper.updateByPrimaryKeySelective(user) < 1, "密码更新失败");
       ;
    }

    public List<String> queryProfileByid(Integer id){
        return   this.userMapper.queryProfileById(id);
    }






    private void checkParament(User user, String oldPassword, String newPassword, String entPassword) {
         /* 3.参数校验
                    原始是否为空？
                    原始密码是否正确？
                    新密码是否为空?
                    新密码是否正确？
                     新密码是否跟确实密码一样
        * */

        AssertUtil.isTrue(StringUtil.isEmpty(oldPassword), "原始密码为空");
        AssertUtil.isTrue(!oldPassword.equals(user.getPassword()), "原始密码不正确");
        AssertUtil.isTrue(StringUtil.isEmpty(newPassword), "新密码为空");
        AssertUtil.isTrue(StringUtil.isEmpty(entPassword),"确认密码不能为空");
        AssertUtil.isTrue(newPassword.equals(user.getPassword()), "新密码跟原始密码一样");
        AssertUtil.isTrue(entPassword.equals(user.getPassword()), "新密码跟确认密码不一样");


    }
}
