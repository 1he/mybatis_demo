package com.mybatisdemo.test;

import com.mybatisdemo.dao.IUserDao;

import com.mybatisdemo.domain.User;
import com.mybatisdemo.mybatis.io.Resources;
import com.mybatisdemo.mybatis.sqlsession.SqlSession;
import com.mybatisdemo.mybatis.sqlsession.SqlSessionFactory;
import com.mybatisdemo.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
//        读取配置文件
        InputStream rs = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(rs);

        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        rs.close();
    }
}
