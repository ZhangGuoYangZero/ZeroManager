package com.manager.mag.Query;

import com.manager.mag.base.BaseQuery;
import com.manager.mag.dao.suppliersMapper;

public class suppliersQuery extends BaseQuery {

    //分页参数

    //查询参数
    private  String  Supply;//提供商
    private  String  Model;
    private  Integer isSelected;


    public String getSupply() {
        return Supply;
    }

    public void setSupply(String supply) {
        Supply = supply;
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
