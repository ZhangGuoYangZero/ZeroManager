package com.manager.mag.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mag.Query.AlliteamQuery;
import com.manager.mag.base.BaseService;
import com.manager.mag.dao.AlliteamMapper;
import com.manager.mag.utils.AssertUtil;
import com.manager.mag.vo.Alliteam;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class AlliteamService extends BaseService<Alliteam, Integer> {
    @Resource
    AlliteamMapper alliteamMapper = null;

    public Map<String, Object> queryAll(AlliteamQuery alliteamQuery) {
        Map<String, Object> map = new HashMap<>();
        //返回的数据要符合layerui的显示格式
        //开启分页
        PageHelper.startPage(alliteamQuery.getPage(), alliteamQuery.getLimit());
        //得到对应的分页对象(数据源
        PageInfo<Alliteam> pageInfo = new PageInfo<>(alliteamMapper.selectByPrimaryKeyAll(alliteamQuery));

        //设置MAP对象

        map.put("code", 0);
        map.put("msg", "sussecc");
        map.put("count", pageInfo.getTotal());
        //加入数据
        map.put("data", pageInfo.getList());
        return map;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addIteam(Alliteam alliteam) {
        //后端数据校验
        checkTruePara(alliteam.getDeviceName(),alliteam.getModel(),alliteam.getNumberOfDevices(),alliteam.getStatu());
        AssertUtil.isTrue(this.alliteamMapper.insertSelective(alliteam) < 1, "添加失败！");
    }

    private void checkTruePara(String deviceName, String model, Integer numberOfDevices,Integer statu) {
        AssertUtil.isTrue(StringUtils.isBlank(deviceName), "设备名为空");
        AssertUtil.isTrue(StringUtils.isBlank(model), "型号为空");
        AssertUtil.isTrue(statu == null, "状态为空");
        AssertUtil.isTrue((numberOfDevices == 0 || numberOfDevices == null), "数量为空");
    }


    public void delIteam(Integer[] ids) {
        if (ids == null || ids.length < 1)
            AssertUtil.isTrue(true, "iD数组为空，删除失败");
        AssertUtil.isTrue(this.alliteamMapper.deleteBatch(ids)!= ids.length,"删除失败");

    }

    public void updataIteam(Alliteam alliteam) {
        checkTruePara(alliteam.getDeviceName(),alliteam.getModel(),alliteam.getNumberOfDevices(),alliteam.getStatu());
        AssertUtil.isTrue(this.alliteamMapper.updataIteam(alliteam) < 1, "添加失败！");
    }
}


