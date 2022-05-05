package com.manager.mag.controller;

import com.manager.mag.Query.ProcurementQuery;
import com.manager.mag.base.BaseController;
import com.manager.mag.base.ResultInfo;
import com.manager.mag.service.procurementService;
import com.manager.mag.vo.procurement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("procure")
public class procurementController extends BaseController {
    @Resource
    procurementService procurementservice =null;


    //缺货查询
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> querySupplyByParam(ProcurementQuery procurementQuery){
        return   procurementservice.queryProCurByNone(procurementQuery);
    }

    @RequestMapping("index")
    public String  procureSS(){
        return  "lackgoods/procure";
    }

    @RequestMapping("index1")
    public String  procureSSS(){
        return  "lackgoods/procure1";
    }





    @PostMapping("add")
    @ResponseBody
    public ResultInfo add(procurement procurement , HttpServletRequest httpServletRequest){

        this.procurementservice.addProcur(procurement);
        return  success("success");

    }

    @PostMapping("update")
    @ResponseBody
    public ResultInfo  update(procurement procurement){
        //记住，端口的property一定要和前台的name一致，不然过不来
        System.out.println(procurement);
        System.out.println("----------------------");
        this.procurementservice.updateProcur(procurement);
        return  success("success");
    }


    //进入添加按钮或者修改的内部页面
    @RequestMapping("addorDel")
    public String innerAdd(Integer iD,HttpServletRequest request){
        if(iD != null &&  iD != 0){
            procurement procurement =  this.procurementservice.selectByPrimaryKey(iD);
            request.setAttribute("procurement",procurement);
        }

        return "lackgoods/add_update1";
    }

    //确定带过去的数据是Interger[]
    @ResponseBody
    @RequestMapping("del")
    public  ResultInfo delPP(Integer[] ids){
        this.procurementservice.delProcur(ids);
        return  success("scuess");
    }

}
