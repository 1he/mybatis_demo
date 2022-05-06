package com.mybatisdemo.mybatis.sqlsession;

public interface SqlSession {
    <T> T getMapper(Class<T> cls);
    void close();
}
