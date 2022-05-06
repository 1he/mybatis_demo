package com.mybatisdemo.mybatis.io;

import java.io.InputStream;
import java.net.URL;

public class Resources {

    public static InputStream getResourceAsStream(String cfgFilePath){

        return Resources.class.getClassLoader().getResourceAsStream(cfgFilePath);
    }
}
