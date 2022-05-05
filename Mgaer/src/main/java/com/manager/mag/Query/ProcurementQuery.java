package com.manager.mag.Query;

import com.manager.mag.base.BaseQuery;

public class ProcurementQuery  extends BaseQuery {
    //分页参数
    //只是在查询的时候使用这个对象
    //查询参数
    private  String  DeviceName;
    private  String  Model;
    private  Integer isSelected;


    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }
}
