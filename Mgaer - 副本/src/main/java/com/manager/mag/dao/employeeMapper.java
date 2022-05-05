package com.manager.mag.dao;

import com.manager.mag.base.BaseMapper;
import com.manager.mag.base.BaseQuery;
import com.manager.mag.vo.employee;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface employeeMapper extends BaseMapper<employee,Integer> {

    @Override
    Integer insertSelective(employee entity) throws DataAccessException;

    @Override
    List<employee> selectByParams(BaseQuery baseQuery) throws DataAccessException;

    @Override
    Integer updateByPrimaryKeySelective(employee entity) throws DataAccessException;

    employee selectByPrimaryKey(String Enum);

    Integer deleteBatch(Integer[] integers) throws DataAccessException;
}