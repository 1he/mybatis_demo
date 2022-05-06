package com.mybatisdemo.mybatis.sqlsession.mapper;

import com.mybatisdemo.mybatis.cfg.Mapper;
import com.mybatisdemo.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String , Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className+"."+methodName;
        System.out.println(key);
        Mapper mapper = mappers.get(key);
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }

       //6.调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
