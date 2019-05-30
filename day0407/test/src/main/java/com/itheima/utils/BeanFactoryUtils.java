package com.itheima.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-21:05
 */
public class BeanFactoryUtils {
    private static ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle("bean");
    }

    public static Object getBean(String key) {
        try {
            String string = resourceBundle.getString(key);
            return Class.forName(string).getConstructor().newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
