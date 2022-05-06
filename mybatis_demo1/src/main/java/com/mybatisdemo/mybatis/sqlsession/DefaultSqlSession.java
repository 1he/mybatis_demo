package com.mybatisdemo.mybatis.sqlsession;

import com.mybatisdemo.mybatis.cfg.Configuration;
import com.mybatisdemo.mybatis.sqlsession.mapper.MapperProxy;
import com.mybatisdemo.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession{
    private Configuration config;
    private Connection conn;
    public DefaultSqlSession(Configuration config) {
        this.config = config;
        conn = DataSourceUtil.getConnection(config);
    }

    public <T> T getMapper(Class<T> cls) {
        return (T)Proxy.newProxyInstance(cls.getClassLoader(),new Class[]{cls},new MapperProxy(config.getMappers(),conn));
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
