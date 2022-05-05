package com.manager.mag.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mag.Query.CostQuery;
import com.manager.mag.base.BaseService;
import com.manager.mag.dao.costMapper;
import com.manager.mag.vo.cost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CostService extends BaseService<cost,Integer> {
    @Resource
    costMapper costmapper = null;

    public Map<String, Object> queryEmpByNone(CostQuery costQuery) {
        Map<String, Object> map = new HashMap<>();
        //返回的数据要符合layerui的显示格式
        //开启分页
        PageHelper.startPage(costQuery.getPage(), costQuery.getLimit());
        //清空
        costmapper.delAll();
        //插入
        costmapper.InsertCOL3();
        costmapper.updatacolprince();
        costmapper.updatacolTotle();
        //得到对应的分页对象(数据源
        PageInfo<cost> pageInfo = new PageInfo<>(costmapper.selectByParams(costQuery));
        //设置MAP对象

        map.put("code", 0);
        map.put("msg", "sussecc");
        map.put("count", pageInfo.getTotal());
        //加入数据
        map.put("data", pageInfo.getList());
        return map;

    }
}
