package com.manager.mag.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mag.Query.EmployeeQuery;
import com.manager.mag.base.BaseService;
import com.manager.mag.dao.employeeMapper;
import com.manager.mag.utils.AssertUtil;
import com.manager.mag.vo.employee;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService extends BaseService<employee, Integer> {

    @Resource
    employeeMapper employeeMapper = null;


    public Map<String, Object> queryEmpByNone(EmployeeQuery employeeQuery) {
        Map<String, Object> map = new HashMap<>();
        //返回的数据要符合layerui的显示格式
        //开启分页
        PageHelper.startPage(employeeQuery.getPage(), employeeQuery.getLimit());
        //得到对应的分页对象(数据源
        PageInfo<employee> pageInfo = new PageInfo<>(employeeMapper.selectByParams(employeeQuery));
        //设置MAP对象

        map.put("code", 0);
        map.put("msg", "sussecc");
        map.put("count", pageInfo.getTotal());
        //加入数据
        map.put("data", pageInfo.getList());
        return map;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmp(employee employeee) {
        //后端数据校验
        checkTruePara(employeee.getEmployeeNumber(), employeee.getEmployeeName(), employeee.getEmployeePosition());
        if (employeee.getEmployeeDepartment() == "" || employeee.getEmployeeDepartment() == null)
            employeee.setEmployeeDepartment("5");//默认员工
        AssertUtil.isTrue(this.employeeMapper.insertSelective(employeee) < 1, "添加失败！");
    }


    private void checkTruePara(String EmpNum, String employeeName, String employeePosition) {

        AssertUtil.isTrue(StringUtils.isBlank(EmpNum), "编号为空");
        AssertUtil.isTrue(StringUtils.isBlank(employeeName), "姓名为空");
        AssertUtil.isTrue(StringUtils.isBlank(employeePosition), "职位为空");
    }

    public employee selectByPrimaryKey(String Enum) {
        return this.employeeMapper.selectByPrimaryKey(Enum);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updataEmp(employee employeee) {
        checkTruePara(employeee.getEmployeeNumber(), employeee.getEmployeeName(), employeee.getEmployeePosition());
        //getEmployeeNumber显示
        if (employeee.getEmployeeDepartment() == "" || employeee.getEmployeeDepartment() == null)
            employeee.setEmployeeDepartment("5");//默认员工
        System.out.println("----------------");
        AssertUtil.isTrue(this.employeeMapper.updateByPrimaryKeySelective(employeee) < 1, "更新失败！");
    }

    //同前端名字一致
    @Transactional(propagation = Propagation.REQUIRED)
    public void delEmp(Integer[] employeeNumber) {
        if (employeeNumber == null || employeeNumber.length < 1)
            AssertUtil.isTrue(true, "iD数组为空，删除失败");
        AssertUtil.isTrue(this.employeeMapper.deleteBatch(employeeNumber)!= employeeNumber.length,"删除失败");

    }
}
