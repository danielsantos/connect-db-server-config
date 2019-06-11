package com.danielrocha;

import java.lang.reflect.Method;
import java.sql.Connection;

public class Util {

    public static Connection createConnection(Object obj) {
        try {
            Class clazz = obj.getClass();
            //if ( clazz.isAnnotationPresent(GetFromConfig.class) ) {
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent(GetConnection.class)){
                    return (Connection) m.invoke(obj);
                }
            }
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
