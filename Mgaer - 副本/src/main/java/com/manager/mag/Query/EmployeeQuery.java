package com.manager.mag.Query;

import com.manager.mag.base.BaseQuery;

public class EmployeeQuery extends BaseQuery {

    private  String EmpNum;
    private  String Position;

    public String getEmpNum() {
        return EmpNum;
    }

    public void setEmpNum(String empNum) {
        EmpNum = empNum;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
}
