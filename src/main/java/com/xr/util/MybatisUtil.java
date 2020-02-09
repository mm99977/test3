package com.xr.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis工具类（连数据库）
 */
public class MybatisUtil {

    //1.私有化构造方法，不能被实例化
    private MybatisUtil(){ }

    private static SqlSessionFactory sqlSessionFactory;
    //2.编写static方法，加载mybatis-config.xml
    static{
        try {
            //获得sqlSessionFactory和sqlSession对象
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3.得到sqlsession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


    //4.关闭sqlsession
    public static void closeSqlSessoin(SqlSession sqlSessoin){
        sqlSessoin.close();
    }

}
