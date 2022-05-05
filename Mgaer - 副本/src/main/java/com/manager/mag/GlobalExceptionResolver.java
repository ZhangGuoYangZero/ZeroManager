package com.manager.mag;

import com.alibaba.fastjson.JSON;
import com.manager.mag.base.ResultInfo;
import com.manager.mag.exceptions.NoLoginException;
import com.manager.mag.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
  全局异常
* */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    /*全局异常处理
        视图
        数据json  responsebody
        用反射的方式看是否有responsebody注解
    */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object handle, Exception ex) {
        //是否登陆异常？ //重定向
        if (ex instanceof NoLoginException) {
            ModelAndView mv = new ModelAndView("redirect:/index");
            return mv;
        }


        /*
        ModelAndView 默认返回视图
        * */
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("code", 500);
        modelAndView.addObject("msg", "默认异常");

        //准备了默认异常，判断传进来的异常是什么异常

        if (handle instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handle;
            //取得这个resonposebody注解
            ResponseBody responseBody = handlerMethod.getMethod().getDeclaredAnnotation(ResponseBody.class);

            if (responseBody == null) {

                if (ex instanceof ParamsException) {
                    ParamsException p = (ParamsException) ex;
                    // 设置异常信息
                    modelAndView.addObject("code", p.getCode());
                    modelAndView.addObject("msg", p.getMsg());

                }
                return modelAndView;
            } else {

                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setCode(500);
                resultInfo.setMsg("异常！特别的异常");

                if (ex instanceof ParamsException) {
                    ParamsException paramsException = (ParamsException) ex;
                    resultInfo.setCode(paramsException.getCode());
                    resultInfo.setMsg(paramsException.getMsg());
                }
                //传输数据用流，一定会乱码
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                //得到标准字符输出流
                PrintWriter out = null;
                try {
                    out = httpServletResponse.getWriter();
                    //如果有数据，将对象转换成json字符流转换走
                    String json = JSON.toJSONString(resultInfo);
                    //溜走数据
                    out.write(json);

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (out != null)
                        out.close();
                }
                //数据已经返回走了
                return null;
            }
        }
        return modelAndView;
    }
}