package com.manager.mag.dao;

import com.manager.mag.Query.AlliteamQuery;
import com.manager.mag.base.BaseMapper;
import com.manager.mag.vo.Alliteam;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface AlliteamMapper extends BaseMapper<Alliteam,Integer> {

    List<Alliteam> selectByPrimaryKeyAll(AlliteamQuery alliteamQuery) throws DataAccessException;


    @Override
    Integer insertSelective(Alliteam entity) throws DataAccessException;

    @Override
    Integer deleteBatch(Integer[] integers) throws DataAccessException;

    Integer updataIteam(Alliteam alliteam);
}