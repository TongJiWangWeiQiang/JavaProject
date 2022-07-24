package com.cccproject.service;

import com.cccproject.pojo.ShoppingCategory;
import com.cccproject.utils.Pager;

public interface CategoryService {
    Pager<ShoppingCategory> getCategory(int id, int startPage, int pageSize);

    public int insertCategory(ShoppingCategory category);

    public ShoppingCategory getCategoryById(Integer id);

    public int updateByCategory(ShoppingCategory category);

    public int deleteById(Integer id);
}
