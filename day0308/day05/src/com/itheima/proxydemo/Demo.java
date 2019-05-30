package com.itheima.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-08-14:56
 */
public class Demo {
    public static void main(String[] args) {

        Car o = (Car) Proxy.newProxyInstance(
                Demo.class.getClassLoader(),//类加载器
                QQ.class.getInterfaces(), //被代理对象的字节码文件的所有实现接口的数组
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        String name = method.getName();
//                        if ("run".equals(name)) {
//                            for (int i = 0; i < 10; i++) {
//                                System.out.println(i);
//                            }
//
//                            return null;
//                        }
//
//                        return method.invoke(new QQ(), args);
//                    }
//                }


                (Object proxy, Method method, Object[] arg) -> {
                    String name = method.getName();
                    if ("run".equals(name)) {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(i);
                        }

                        return null;
                    }

                    return method.invoke(new QQ(), arg);
                }

        );


        o.color();
        String s = o.jiaYou("97#");
        System.out.println(s);
        o.run();


    }
}
