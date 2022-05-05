package com.manager.mag.dao;

import com.manager.mag.base.BaseMapper;
import com.manager.mag.base.BaseQuery;
import com.manager.mag.vo.procurement;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface procurementMapper extends BaseMapper<procurement,Integer> {


    @Override
    Integer insertSelective(procurement entity) throws DataAccessException;

    @Override
    List<procurement> selectByParams(BaseQuery baseQuery) throws DataAccessException;

    @Override
    Integer updateByPrimaryKeySelective(procurement entity) throws DataAccessException;

    @Override
    Integer deleteBatch(Integer[] integers) throws DataAccessException;

    void   deleteALL() throws DataAccessException;

    void   InsertStat0() throws DataAccessException;

}