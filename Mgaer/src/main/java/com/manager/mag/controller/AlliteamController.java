package com.manager.mag.controller;

import com.manager.mag.Query.AlliteamQuery;
import com.manager.mag.base.BaseController;
import com.manager.mag.base.ResultInfo;
import com.manager.mag.service.AlliteamService;
import com.manager.mag.vo.Alliteam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("all")
public class AlliteamController extends BaseController {

    @Resource
    AlliteamService alliteamService = null;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryALL(AlliteamQuery alliteamQuery){
        return  alliteamService.queryAll(alliteamQuery);
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultInfo add(Alliteam alliteam){
        this.alliteamService.addIteam(alliteam);
        return  success("success");
    }

    @RequestMapping("del")
    @ResponseBody
    public  ResultInfo del(Integer[] ids,HttpServletRequest request){
        this.alliteamService.delIteam(ids);
        return  success("scuess");
    }





    @RequestMapping("index")
    public  String  index(){
        return  "ALL/all";
    }


    //进入添加按钮或者修改的内部页面
    @RequestMapping("addorDel")
    public String innerAdd(Integer id, HttpServletRequest request){
        if(id != null &&  id != 0){
            Alliteam alliteam =  this.alliteamService.selectByPrimaryKey(id);
            request.setAttribute("alliteam",alliteam);
        }

        return "ALL/add_update";
    }



    @PostMapping("update")
    @ResponseBody
    public ResultInfo  update(Alliteam alliteam){
        //记住，端口的property一定要和前台的name一致，不然过不来
        this.alliteamService.updataIteam(alliteam);
        return  success("success");
    }
}
