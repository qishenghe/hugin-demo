package com.github.qishenghe.hugin.demo.version101.config;

import com.qishenghe.hugin.core.api.HuginFunction;
import com.qishenghe.hugin.core.pack.HuginRulePack;
import com.qishenghe.hugin.core.rule.Rule;
import com.qishenghe.hugin.session.HuginSession;

/**
 *
 *
 * @author qishenghe
 * @date 7/6/22 10:53 AM
 * @change 7/6/22 10:53 AM by shenghe.qi@relxtech.com for init
 */
public class HuginConfig {

    /**
     * 创建 hugin session
     * 
     * @return hugin session
     * @since 1.0.0
     * @author qishenghe
     * @date 7/6/22 10:56 AM
     * @change 7/6/22 10:56 AM by shenghe.qi@relxtech.com for init
     */
    public static HuginSession createHuginSession () {

        return HuginSession.builder()
                // 增加自定义规则容器
                .setHuginRulePack(customHuginRulePack())
                .getOrCreate();
    }

    /**
     * 自定义规则容器
     * 
     * @return 自定义规则容器
     * @since 1.0.0
     * @author qishenghe
     * @date 7/6/22 11:37 AM
     * @change 7/6/22 11:37 AM by shenghe.qi@relxtech.com for init
     */
    private static HuginRulePack customHuginRulePack () {

        // 生成数字增加规则
        Rule rule1 = Rule.getInstance((HuginFunction<Integer, Integer>) (origin, params) -> {

            for (String singleParam : params) {
                origin += Integer.parseInt(singleParam);
            }

            return origin;
        });


        HuginRulePack huginRulePack = new HuginRulePack();
        // 添加规则：数字增加规则
        huginRulePack.addRule("numberAdd", rule1);

        return huginRulePack;
    }

}
