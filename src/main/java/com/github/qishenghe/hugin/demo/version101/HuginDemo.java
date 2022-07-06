package com.github.qishenghe.hugin.demo.version101;

import com.github.qishenghe.hugin.demo.version101.config.HuginConfig;
import com.github.qishenghe.hugin.demo.version101.entity.Person;
import com.qishenghe.hugin.session.HuginSession;

import java.util.ArrayList;
import java.util.List;

/**
 * hugin demo
 *
 * @author qishenghe
 * @date 7/6/22 10:39 AM
 * @change 7/6/22 10:39 AM by shenghe.qi@relxtech.com for init
 */
public class HuginDemo {

    public static void main(String[] args) {

        // hugin session
        HuginSession huginSession = HuginConfig.createHuginSession();

        List<Person> dataList = createDataList();

        System.out.println("==================转换前==================");
        for (Person single : dataList) {
            System.out.println(single.toString());
        }

        huginSession.getHuginTransUtil().trans(dataList);

        System.out.println("==================转换后==================");

        for (Person single : dataList) {
            System.out.println(single.toString());
        }

    }

    /**
     * 创建数据集
     * 
     * @return resultList
     * @since 1.0.0
     * @author qishenghe
     * @date 7/6/22 11:11 AM
     * @change 7/6/22 11:11 AM by shenghe.qi@relxtech.com for init
     */
    private static List<Person> createDataList () {

        List<Person> list = new ArrayList<>();

        Person p1 = new Person();
        p1.setCid("230102199301011234");
        p1.setName("齐老二");
        p1.setPhone(18645113456L);
        p1.setAge(18);

        Person p2 = new Person();
        p2.setCid("230102199301013456");
        p2.setName("范老三");
        p2.setPhone(18645115678L);
        p2.setAge(17);

        Person p3 = new Person();
        p3.setCid("230102199301015678");
        p3.setName("赵四");
        p3.setPhone(123L);
        p3.setAge(17);

        Person p4 = new Person();
        p4.setCid(null);
        p4.setName(null);
        p4.setPhone(null);
        p4.setAge(null);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        return list;
    }

}
