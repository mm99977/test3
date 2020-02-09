package com.xr.dao;

import com.xr.model.Menu;

import java.util.List;

public interface Menumapper {
    //写Menu的CRUD

    //查询1：根据pid查询权限对象
    public List<Menu> queryMenuById(Integer mid);

    //查询2：Menu的模糊查询
    public List<Menu> queryMenuByIdTj(String mname);

    //查询3：查询所有权限
    public List<Menu> queryMenu();

    //查询4：权限分页查询

    //添加权限信息
    public void addMenu(Menu menu);

    //删除权限
    public void deleteMenu(Integer rid);

    //查询个数
    public int cha(int rid);

    //ztree查询
    public List<Menu> queryMenuZtree();

    //多条件查询
    List<Menu> selectTJSY(Menu menu);

    //修改
    void  updateMenu(Menu menu);

    //删除权限
     void deleteMid(List<Integer> id);//假设LiST中存放了多个id
}
