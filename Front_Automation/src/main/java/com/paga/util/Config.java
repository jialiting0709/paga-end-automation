package com.paga.util;
/**
 * 读取properties配置文件
 * @author jialiting
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private Properties prop;
    public Config(String fileName) {
        prop = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getConfig(String key) {
        return prop.getProperty(key);
    }

}
