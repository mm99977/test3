package com.xr.test;

import com.xr.dao.Menumapper;
import com.xr.dao.Rolemapper;
import com.xr.model.Menu;
import com.xr.model.Role;
import com.xr.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RoleMenuTest {
    @Test
    public void test1() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Rolemapper mapper = sqlSession.getMapper(Rolemapper.class);
       //添加角色
        Role roles = new Role();
        roles.setRoleName("总经理");
        mapper.addRole(roles);
        System.out.println("id=" + roles.getRid());
        sqlSession.commit();
    }
    @Test
    public void test2() throws Exception{
        //添加权限
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Menumapper mapper = sqlSession.getMapper(Menumapper.class);
        Menu menu = new Menu();
        menu.setMenuName("订单管理");
        menu.setUrl("c");
        mapper.addMenu(menu);
        sqlSession.commit();
        System.out.println("id=" + menu.getMid());
    }

    @Test
    public void test8() throws Exception{
        //根据mid查询权限对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Menumapper mapper = sqlSession.getMapper(Menumapper.class);
        List<Menu> menus = mapper.queryMenuById(1);
        for (Menu m : menus) {
            System.out.println(m);
        }
        sqlSession.close();
    }
    @Test
    public void test9() throws Exception{
        //根据mid查询权限对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Menumapper mapper = sqlSession.getMapper(Menumapper.class);
        List<Menu> menus = mapper.queryMenuByIdTj("订单");
        for (Menu m : menus) {
            System.out.println(m);
        }
        sqlSession.close();
    }

    @Test
    public void test10() throws Exception{
        //根据mid查询权限对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Menumapper mapper = sqlSession.getMapper(Menumapper.class);
        List<Menu> menus = mapper.queryMenu();
        for (Menu m : menus) {
            System.out.println(m);
        }
        sqlSession.close();
    }
    @Test
    public void test11() throws Exception{
        //根据rid删除角色和权限
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Rolemapper mapper = sqlSession.getMapper(Rolemapper.class);
        Menumapper mapper1 = sqlSession.getMapper(Menumapper.class);
        int rid=4;
        //查询rid=4的关系表rid
        int count=mapper1.cha(rid);
        //查询出来的个数大于0，则先删关系表中的数据，再删角色表的数据，反之，直接删除角色表数据
        if(count>0){
            mapper1.deleteMenu(rid);
        }
        mapper.deleteRole(rid);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws Exception{
        //添加角色并赋予权限
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Rolemapper mapper = sqlSession.getMapper(Rolemapper.class);

        //1.先获取角色信息
        Role role = new Role();
        role.setRoleName("总经理");
        //4.将存有权限对象的集合赋给role对象中的List
        //role.setMenu(pres);
        //5.添加角色
        mapper.addRole(role);
        System.out.println(role.getRid());

        //返回了新添加的角色ID
        //2.假设勾选了两个权限（pid=1, pid=2）
        int[] pres = {2,3};
        //准备Map集合
        Map maps = new HashMap();
        maps.put("rid", role.getRid());
        maps.put("pres", pres);
        //写SQL向第三张表添加两条记录
        mapper.addRoleAndMenu(maps);

        sqlSession.commit();
    }

    @Test
    public void test4() throws Exception{
        //根据ID查询角色及对应的权限
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Rolemapper mapper = sqlSession.getMapper(Rolemapper.class);
        List<Map<String, Object>> maps = mapper.queryRoleAndMenuById(5);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        sqlSession.close();
    }

    @Test
    public void test5() throws Exception{
        //根据ID查询角色
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Rolemapper mapper = sqlSession.getMapper(Rolemapper.class);
        List<Role> roles = mapper.queryRoleById(5);
        for (Role map : roles) {
            System.out.println(map);
        }
        sqlSession.close();
    }

    @Test
    public void test6() throws Exception{
        //模糊查询角色
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Rolemapper mapper = sqlSession.getMapper(Rolemapper.class);
        List<Role> roles = mapper.queryRoleByTj("经理");
        for (Role map : roles) {
            System.out.println(map);
        }
        sqlSession.close();
    }

    @Test
    public void test7() throws Exception{
        //查询所有角色
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Rolemapper mapper = sqlSession.getMapper(Rolemapper.class);
        List<Role> roles = mapper.queryRole();
        for (Role map : roles) {
            System.out.println(map);
        }
        sqlSession.close();
    }

    @Test
    public void test12() throws Exception{
        //模糊查询角色
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Menumapper menumapper=sqlSession.getMapper(Menumapper.class);
        Menu menu1=new Menu();
/*        menu1.setMenuName("用户管理");
        menu1.setUrl("a");*/
        /* menu1.setMid(2);*/
      /*   menu1.setMenuName("菜单设置");
         menu1.setUrl("b");*/
         menu1.setParentId(0);
        List<Menu> menus=menumapper.selectTJSY(menu1);
        for (Menu m:menus) {
            System.out.println(m);
        }
    }
    @Test
    public void test13(){
        //模糊查询角色
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Menumapper menumapper=sqlSession.getMapper(Menumapper.class);
        List<Integer> integers=new ArrayList<>();
        integers.add(11);
        integers.add(12);
        integers.add(13);
        menumapper.deleteMid(integers);
        sqlSession.commit();
    }
    @Test
    public void test14(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Menumapper menumapper=sqlSession.getMapper(Menumapper.class);
        Menu menu1=new Menu();
        menu1.setUrl("queryCd.jsp");
        menu1.setMenuName("查询菜单");
        menu1.setMid(10);
        menumapper.updateMenu(menu1);
        sqlSession.commit();
    }
}