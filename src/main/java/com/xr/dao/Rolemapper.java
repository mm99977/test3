package com.xr.dao;

import com.xr.model.Menu;
import com.xr.model.Role;

import java.util.List;
import java.util.Map;

public interface Rolemapper<list> {
    //写Role的CRUD

    //查询1：根据rid查询角色对象
    public List<Role> queryRoleById(Integer rid);

    //查询2：role的模糊查询
    public List<Role> queryRoleByTj(String rname);

    //查询3：查询所有角色
    public List<Role> queryRole();

    //查询4：角色分页查询


    //需求1：根据角色ID查询角色信息及该角色所有的权限
    public List<Map<String, Object>> queryRoleAndMenuById(Integer rid);

    //需求2：添加角色并给角色授权

    //添加角色信息1（不授权）
    public int addRole(Role role);

    //添加角色并授权2
    public int addRoleAndMenu(Map map);

    //删除角色
    public int deleteRole(Integer rid);


}
