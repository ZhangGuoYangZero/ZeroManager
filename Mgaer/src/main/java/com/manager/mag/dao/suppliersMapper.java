package com.manager.mag.dao;

import com.manager.mag.base.BaseMapper;
import com.manager.mag.base.BaseQuery;
import com.manager.mag.vo.suppliers;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface suppliersMapper extends BaseMapper<suppliers, Integer> {
    //继承了父类的接口，里面有SQL接口

    @Override
    Integer insertSelective(suppliers entity) throws DataAccessException;

    @Override
    suppliers selectByPrimaryKey(@Param("iD") Integer iD) throws DataAccessException;

    @Override
    List<suppliers> selectByParams(BaseQuery baseQuery) throws DataAccessException;

    //只能修改数量和设备名字
    @Override
    Integer updateByPrimaryKeySelective(suppliers entity) throws DataAccessException;
    //批量删除
    @Override
    Integer deleteBatch(Integer[] integers) throws DataAccessException;


}