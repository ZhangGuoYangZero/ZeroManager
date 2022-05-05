package com.manager.mag.service;
/*
    供应商的查询
* */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.manager.mag.Query.suppliersQuery;
import com.manager.mag.base.BaseService;
import com.manager.mag.dao.suppliersMapper;
import com.manager.mag.utils.AssertUtil;
import com.manager.mag.utils.StateStatus;
import com.manager.mag.vo.suppliers;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class suppliersService extends BaseService<suppliers, Integer> {

    //调用DAO层方法
    @Resource
    suppliersMapper suppliersMapper = null;


    public Map<String, Object> querySupplyByParam(suppliersQuery suppliersQuery) {
        Map<String, Object> map = new HashMap<>();
        //返回的数据要符合layerui的显示格式
        //开启分页
        PageHelper.startPage(suppliersQuery.getPage(), suppliersQuery.getLimit());
        //得到对应的分页对象(数据源
        PageInfo<suppliers> pageInfo = new PageInfo<>(suppliersMapper.selectByParams(suppliersQuery));
        //设置MAP对象

        map.put("code", 0);
        map.put("msg", "sussecc");
        map.put("count", pageInfo.getTotal());
        //加入数据
        map.put("data", pageInfo.getList());
        return map;
    }

    //全部数据非空除了状态
    @Transactional(propagation = Propagation.REQUIRED)
    public void addsuppliers(suppliers supplierss) {
        //后端数据校验
        checkTruePara(supplierss.getSupply(), supplierss.getDeviceName(), supplierss.getModel(), supplierss.getNumberOfDevices());
        supplierss.setIsSelected(StateStatus.UNSTATE.getType());
        AssertUtil.isTrue(this.suppliersMapper.insertSelective(supplierss) < 1, "添加失败！");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updatesuppliers(suppliers supplierss) {
        checkTruePara(supplierss.getSupply(), supplierss.getDeviceName(), supplierss.getModel(), supplierss.getNumberOfDevices());
        //提供商 设备号  状态 都是隐藏的方式带回来
        AssertUtil.isTrue(this.suppliersMapper.updateByPrimaryKeySelective(supplierss) < 1, "更新失败！");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delsuppliers(Integer[] iD) {
        if (iD == null || iD.length < 1)
            AssertUtil.isTrue(true, "iD数组为空，删除失败");
        AssertUtil.isTrue(this.suppliersMapper.deleteBatch(iD)!= iD.length,"删除失败");

    }


    private void checkTruePara(String supply, String deviceName, String model, Integer numberOfDevices) {

        AssertUtil.isTrue(StringUtils.isBlank(supply), "提供商为空");
        AssertUtil.isTrue(StringUtils.isBlank(deviceName), "设备名为空");
        AssertUtil.isTrue((numberOfDevices == null || numberOfDevices == 0), "数量为空");
    }


}
