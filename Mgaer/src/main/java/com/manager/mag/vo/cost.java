package com.manager.mag.vo;

public class cost {
    private Integer id;

    private String deviceName;

    private String model;

    private Integer price;

    private Integer total;

    private Integer numberOfDevice;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNumberOfDevice() {
        return numberOfDevice;
    }

    public void setNumberOfDevice(Integer numberOfDevice) {
        this.numberOfDevice = numberOfDevice;
    }
}