package com.mybatisdemo.mybatis.sqlsession;

import com.mybatisdemo.mybatis.cfg.Configuration;
import com.mybatisdemo.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {



    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
