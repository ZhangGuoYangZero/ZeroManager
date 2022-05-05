package com.manager.mag.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mag.Query.ProcurementQuery;
import com.manager.mag.base.BaseService;
import com.manager.mag.dao.procurementMapper;
import com.manager.mag.utils.AssertUtil;
import com.manager.mag.utils.StateStatus;
import com.manager.mag.vo.procurement;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class procurementService extends BaseService<procurement,Integer> {
    @Resource
    procurementMapper  procurementmapper= null;


    //查询 整张表

    public Map<String, Object> queryProCurByNone(ProcurementQuery procurementQuery) {
        Map<String, Object> map = new HashMap<>();
        //返回的数据要符合layerui的显示格式
        //开启分页
        PageHelper.startPage(procurementQuery.getPage(), procurementQuery.getLimit());
        //得到对应的分页对象(数据源
        //因为一个接口绑定一条SQL 需要用2个接口2跳SQL完成我要的目的
        procurementmapper.deleteALL();
        //在插入iteam表中的状态为0的字段
        procurementmapper.InsertStat0();
        //查询
        PageInfo<procurement> pageInfo = new PageInfo<>(procurementmapper.selectByParams(procurementQuery));
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
    public void addProcur(procurement procurement) {
        //后端数据校验
        checkTruePara(procurement.getDeviceName(), procurement.getModel(), procurement.getNumberOfDevices());
        if(procurement.getStatu() == 0 || procurement.getStatu() == null)
            procurement.setStatu(StateStatus.UNSTATE.getType());
        AssertUtil.isTrue(this.procurementmapper.insertSelective(procurement) < 1, "添加失败！");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateProcur(procurement procurement) {
        checkTruePara(procurement.getDeviceName(), procurement.getModel(),procurement.getNumberOfDevices());
        //id是隐藏的方式带回来
        System.out.println(procurement);
        if(procurement.getStatu() == null || procurement.getStatu()== 0)
            procurement.setStatu(StateStatus.UNSTATE.getType());
        System.out.println("----------------");
        AssertUtil.isTrue(this.procurementmapper.updateByPrimaryKeySelective(procurement) < 1, "更新失败！");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delProcur(Integer[] iD) {
        if (iD == null || iD.length < 1)
            AssertUtil.isTrue(true, "iD数组为空，删除失败");
        AssertUtil.isTrue(this.procurementmapper.deleteBatch(iD)!= iD.length,"删除失败");

    }


    private void checkTruePara(String deviceName, String model, Integer numberOfDevices) {

        AssertUtil.isTrue(StringUtils.isBlank(deviceName), "设备名为空");
        AssertUtil.isTrue(StringUtils.isBlank(model), "型号为空");
        AssertUtil.isTrue((numberOfDevices == null || numberOfDevices == 0), "数量为空");
    }

}
