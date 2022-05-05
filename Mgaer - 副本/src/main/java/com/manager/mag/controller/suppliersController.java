package com.manager.mag.controller;


import com.manager.mag.Query.suppliersQuery;
import com.manager.mag.base.BaseController;
import com.manager.mag.base.ResultInfo;
import com.manager.mag.service.suppliersService;
import com.manager.mag.utils.CookieUtil;
import com.manager.mag.vo.suppliers;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("suppliers")
public class suppliersController extends BaseController {

    @Resource
    suppliersService suppliersservice = null;

    /*
    供应商查询
    * */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> querySupplyByParam(suppliersQuery suppliersQuery){
        return   suppliersservice.querySupplyByParam(suppliersQuery);
    }

    //一但点击按钮 就会来请问这个index跟着他来，进入这个函数  得到HTML的URL
    //返回的不是数据
    @RequestMapping("index")
    public String  supplys(){
        return  "lackgoods/supply";
    }

    @PostMapping("add")
    @ResponseBody
    public ResultInfo addSupply(suppliers supplierss ,HttpServletRequest httpServletRequest){

        String  useName = CookieUtil.getCookieValue(httpServletRequest,"userName");
        supplierss.setSupply(useName);
        this.suppliersservice.addsuppliers(supplierss);
        return  success("success");

    }

    @PostMapping("update")
    @ResponseBody
    public ResultInfo  updateSupply(suppliers supplierss){
        //供应商，设备型号，状态 hindle带回来
        this.suppliersservice.updatesuppliers(supplierss);
        return  success("success");
    }


    //进入添加按钮或者修改的内部页面
    @RequestMapping("addorDel")
    public String innerAdd(Integer iD,HttpServletRequest request){
        if(iD != null &&  iD != 0){
           suppliers supplierss =  this.suppliersservice.selectByPrimaryKey(iD);
            System.out.println("---------------------");
            System.out.println(supplierss);
            System.out.println("---------------------");
           request.setAttribute("supplierss",supplierss);
        }
        return "lackgoods/add_update";
    }

    //确定带过去的数据是Interger[]
    @ResponseBody
    @RequestMapping("del")
    public  ResultInfo delSupply(Integer[] ids){
        this.suppliersservice.delsuppliers(ids);
        return  success("scuess");
    }

}
