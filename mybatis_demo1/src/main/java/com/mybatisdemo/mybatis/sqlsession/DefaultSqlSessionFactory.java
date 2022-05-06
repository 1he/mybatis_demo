package com.mybatisdemo.mybatis.sqlsession;

import com.mybatisdemo.mybatis.cfg.Configuration;
import com.mybatisdemo.mybatis.utils.DataSourceUtil;

import java.io.InputStream;
import java.sql.Connection;

public class DefaultSqlSessionFactory implements SqlSessionFactory{


    private Configuration config;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.config = cfg;

    }

    public SqlSession openSession() {
        return new DefaultSqlSession(config);
    }
}
