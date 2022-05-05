package com.manager.mag.dao;

import com.manager.mag.base.BaseMapper;
import com.manager.mag.base.BaseQuery;
import com.manager.mag.vo.cost;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface costMapper extends BaseMapper<cost,Integer> {

    void  delAll()  throws DataAccessException;

    void InsertCOL3() throws DataAccessException;

    void updatacolprince() throws  DataAccessException;

    void updatacolTotle() throws DataAccessException;

    @Override
    List<cost> selectByParams(BaseQuery baseQuery) throws DataAccessException;
}