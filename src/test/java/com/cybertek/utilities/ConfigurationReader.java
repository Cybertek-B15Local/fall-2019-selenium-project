package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            // reads file in java. we neeed to pass the path of the file
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");

            // initiliaze the object
            properties = new Properties();
            // load contents of the file the properties object.
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
