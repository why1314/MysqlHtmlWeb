package com.itheima;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-18-20:28
 */
public class Demo {
    public static void main(String[] args) throws Exception {
//        创建核心解析对象
        SAXReader reader = new SAXReader();
//        读取students.xml获得流文件
        InputStream is = Demo.class.getClassLoader().getResourceAsStream("students.xml");
//        读取流文件获得dom对象
        Document document = reader.read(is);
//        获得根节点对象
        Element rootEle = document.getRootElement();
        List<Element> stuList = rootEle.elements("student");

        List<Student> list = new ArrayList<>();
        for (Element element : stuList) {
            Student stu = new Student();
            stu.setName(element.elementText("name"));
            stu.setSex(element.elementText("sex"));
            stu.setAge(Integer.parseInt(element.elementText("age")));
            list.add(stu);
        }

        for (Student student : list) {
            System.out.println(student.getName()+" : "+student.getSex()+" : "+student.getAge());
        }

    }
}
