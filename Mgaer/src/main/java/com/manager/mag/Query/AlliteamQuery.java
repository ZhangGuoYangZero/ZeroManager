package com.manager.mag.Query;

import com.manager.mag.base.BaseQuery;

public class AlliteamQuery extends BaseQuery
{
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
