package com.cccproject.mapper;

import com.cccproject.pojo.ShoppingCategory;
import com.cccproject.pojo.ShoppingCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCategoryMapper {
    int countByExample(ShoppingCategoryExample example);

    int deleteByExample(ShoppingCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCategory record);

    int insertSelective(ShoppingCategory record);

    List<ShoppingCategory> selectByExample(ShoppingCategoryExample example);

    ShoppingCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShoppingCategory record, @Param("example") ShoppingCategoryExample example);

    int updateByExample(@Param("record") ShoppingCategory record, @Param("example") ShoppingCategoryExample example);

    int updateByPrimaryKeySelective(ShoppingCategory record);

    int updateByPrimaryKey(ShoppingCategory record);
}