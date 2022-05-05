package com.manager.mag.base;


import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
/*
负责NEW 一个新的返回
* */

    @ModelAttribute
    public void preHandler(HttpServletRequest request) {
//       这里是项目的地址getContenxtPath 被COMMONT文件包含，并被INDEX文件引用
        request.setAttribute("ctx", request.getContextPath());
    }


    public ResultInfo success() {
        return new ResultInfo();
    }

    public ResultInfo success(String msg) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(msg);
        return resultInfo;
    }

    public ResultInfo success(String msg, Object result) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(msg);
        resultInfo.setResult(result);
        return resultInfo;
    }

}
