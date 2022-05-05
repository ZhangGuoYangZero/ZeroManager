package com.manager.mag.vo;

import com.manager.mag.base.BaseQuery;

public class suppliers {

    private String Supply;
    private String DeviceName;
    private String Model;
    private Integer NumberOfDevices;
    private Integer isSelected;
    private Integer iD;


    public String getSupply() {
        return Supply;
    }

    public void setSupply(String supply) {
        Supply = supply;
    }

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

    public Integer getNumberOfDevices() {
        return NumberOfDevices;
    }

    public void setNumberOfDevices(Integer numberOfDevices) {
        NumberOfDevices = numberOfDevices;
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }


    @Override
    public String toString() {
        return this.getModel() + this.getNumberOfDevices() + this.iD + this.getSupply();
    }
}