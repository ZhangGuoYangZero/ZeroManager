package com.manager.mag.controller;

import com.manager.mag.Query.EmployeeQuery;
import com.manager.mag.base.BaseController;
import com.manager.mag.base.ResultInfo;
import com.manager.mag.service.EmployeeService;
import com.manager.mag.vo.employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("emp")
@Controller
public class EmployeeController extends BaseController {

    @Resource
    EmployeeService employeeService = null;

    //全职工查询
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryEmpByNone(EmployeeQuery employeeQuery){
        return   employeeService.queryEmpByNone(employeeQuery);
    }

    @RequestMapping("index")
    public  String Eemp(){
        return  "emp/emppage";
    }



    @PostMapping("add")
    @ResponseBody
    public ResultInfo add(employee employeee){
        this.employeeService.addEmp(employeee);
        return  success("success");
    }

    //进入添加按钮或者修改的内部页面
    @RequestMapping("addorDel")
    public String innerAdd(String employeeNumber, HttpServletRequest request){
        if(employeeNumber != null &&  employeeNumber != ""){
            employee employeee =  this.employeeService.selectByPrimaryKey(employeeNumber);
            request.setAttribute("employeee",employeee);
        }

        return "emp/add_update1";
    }


    @PostMapping("update")
    @ResponseBody
    public ResultInfo  update(employee employeee){
        //记住，端口的property一定要和前台的name一致，不然过不来
        System.out.println(employeee);
        System.out.println("----------------------");
        this.employeeService.updataEmp(employeee);
        return  success("success");
    }
    //确定带过去的数据是Interger[] 名字同前端一致
    @ResponseBody
    @RequestMapping("del")
    public  ResultInfo delEmp(Integer[] employeeNumber){
        this.employeeService.delEmp(employeeNumber);
        return  success("scuess");
    }
}
