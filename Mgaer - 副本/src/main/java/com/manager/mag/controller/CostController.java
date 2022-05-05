package com.manager.mag.controller;

import com.manager.mag.Query.CostQuery;
import com.manager.mag.base.BaseController;
import com.manager.mag.service.CostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("cost")
public class CostController extends BaseController {
    @Resource
    CostService costService = null;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryEmpByNone(CostQuery costQuery){
        return  costService.queryEmpByNone(costQuery);
    }

    @RequestMapping("index")
    public  String index(){
        return  "cost/cost";
    }
}
