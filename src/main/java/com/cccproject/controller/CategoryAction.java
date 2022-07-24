package com.cccproject.controller;

import com.cccproject.pojo.ShoppingCategory;
import com.cccproject.service.CategoryService;
import com.cccproject.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shoppingCategory")
public class CategoryAction {

    public static final int PAGE_SIZE = 5;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("findCategory")
    public String findCategory(Model model, ShoppingCategory shoppingCategory){
        System.out.println("enter findCategory");
        int flag = 2;
        Pager<ShoppingCategory> pager;
        if(shoppingCategory.getPid() == null){
            flag = 1;
            shoppingCategory.setPid(0);
        }
        pager = categoryService.getCategory(shoppingCategory.getPid(), 1, PAGE_SIZE);
        System.out.println(pager.getDatas().size());
//        System.out.println(pager);
        model.addAttribute("pagers", pager);
        model.addAttribute("obj", shoppingCategory);
        if (flag == 1)
            return "/itemCategory/shoppingCategory";
        else
            return "/itemCategory/shoppingSecondCategory";
    }

    @RequestMapping("addCategory")
    public String addCategory(){
        System.out.println("enter addCategory");
        return "/itemCategory/addCategory";
    }

    @RequestMapping("addSecondCategory")
    public String addSecondCategory(int pid, Model model){
        System.out.println("enter addSecondCategory");
        model.addAttribute("pid", pid);
        return "/itemCategory/addSecondCategory";
    }

    @RequestMapping("executeAdd")
    public String executeAdd(ShoppingCategory category){
        int num = -1;
        try {
            num = categoryService.insertCategory(category);
//            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if( num > 0){
            System.out.println("insert success");
        }
        else {
            System.out.println("insert failed");
        }
        if(category.getPid() == null)
            return "redirect:/shoppingCategory/findCategory.action";
        else
            return "redirect:/shoppingCategory/findCategory.action?pid="+category.getPid();
    }

    @RequestMapping("update")
    public String update(ShoppingCategory item, Model model){
        ShoppingCategory category = categoryService.getCategoryById(item.getId());
        model.addAttribute("obj", category);
        if(item.getPid() == null)
            return "/itemCategory/update";
        else
            return "/itemCategory/updateSecond";
    }

    @RequestMapping("executeUpdate")
    public String executeUpdate(ShoppingCategory category){
        int num = -1;
        try {
            num = categoryService.updateByCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(num > 0){
            System.out.println("update success");
        }
        else {
            System.out.println("update failed");
        }
        if(category.getPid() == null)
            return "redirect:/shoppingCategory/findCategory.action";
        else
            return "redirect:/shoppingCategory/findCategory.action?pid="+category.getPid();
    }

    @RequestMapping("delete")
    public String delete(ShoppingCategory category){
        categoryService.deleteById(category.getId());
        if(category.getPid() == null)
            return "redirect:/shoppingCategory/findCategory.action";
        else
            return "redirect:/shoppingCategory/findCategory.action?pid="+category.getPid();
    }
}
