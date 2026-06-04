package com.testing.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static Properties getProperties() {

        try {

            FileInputStream file =
                    new FileInputStream(
                    "src/test/resources/config.properties");

            prop = new Properties();

            prop.load(file);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return prop;
    }
}