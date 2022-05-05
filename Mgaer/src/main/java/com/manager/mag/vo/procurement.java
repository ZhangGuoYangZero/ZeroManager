package com.manager.mag.vo;

public class procurement {
    private Integer id;

    private String deviceName;

    private String model;

    private Integer numberOfDevices;

    private Integer statu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getNumberOfDevices() {
        return numberOfDevices;
    }

    public void setNumberOfDevices(Integer numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }



    @Override
    public String toString() {
        return "procurement{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", model='" + model + '\'' +
                ", numberOfDevices=" + numberOfDevices +
                ", statu=" + statu +
                '}';
    }
}