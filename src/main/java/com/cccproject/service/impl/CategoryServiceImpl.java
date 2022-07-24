package com.cccproject.service.impl;

import com.cccproject.mapper.ShoppingCategoryMapper;
import com.cccproject.pojo.ShoppingCategory;
import com.cccproject.pojo.ShoppingCategoryExample;
import com.cccproject.service.CategoryService;
import com.cccproject.utils.Pager;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ShoppingCategoryMapper shoppingCategoryMapper;

    @Override
    public Pager<ShoppingCategory> getCategory(int id, int startPage, int pageSize) {
        ShoppingCategoryExample example = new ShoppingCategoryExample();
        example.createCriteria().andPidEqualTo(id);
        PageHelper.startPage(startPage, pageSize);
        List<ShoppingCategory> list = shoppingCategoryMapper.selectByExample(example);
        Pager<ShoppingCategory> pager = new Pager<>(list);
        return pager;
    }

    @Override
    public int insertCategory(ShoppingCategory category) {
        System.out.println("enter insertCategory");
        return shoppingCategoryMapper.insertSelective(category);
    }

    @Override
    public ShoppingCategory getCategoryById(Integer id) {
        return shoppingCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByCategory(ShoppingCategory category) {
        return shoppingCategoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public int deleteById(Integer id) {
        int num = -1;
        ShoppingCategoryExample example = new ShoppingCategoryExample();
        example.createCriteria().andPidEqualTo(id);
        List<ShoppingCategory> categories = shoppingCategoryMapper.selectByExample(example);
        if(categories.size() > 0){
            //存在二级分类，需要一并删除
            System.out.println("delete " + categories.size()+ " types");
            for(int i =0; i < categories.size(); ++i){
                shoppingCategoryMapper.deleteByPrimaryKey(categories.get(i).getId());
            }
        }
        shoppingCategoryMapper.deleteByPrimaryKey(id);
        return 0;
    }
}
