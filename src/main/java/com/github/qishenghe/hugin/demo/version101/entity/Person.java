package com.github.qishenghe.hugin.demo.version101.entity;

import com.qishenghe.hugin.core.point.HuginPoint;
import com.qishenghe.hugin.core.preset.HuginPresetRule;
import lombok.Data;

import java.io.Serializable;

/**
 * person
 *
 * @author qishenghe
 * @date 7/6/22 10:56 AM
 * @change 7/6/22 10:56 AM by shenghe.qi@relxtech.com for init
 */
@Data
public class Person implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = -4292092602936344340L;

    /**
     * 身份证号
     * 说明：示例脱敏规则：自第 4 位起至第 6 位止，自第 10 位起至第 14 位止，两段进行脱敏处理
     * 例：230102199301013456 转换为 2301**1993****3456
     */
    @HuginPoint(ruleCode = HuginPresetRule.DESENSITIZE, param = {"4", "6", "10", "14"})
    private String cid;

    /**
     * 姓名
     * 说明：示例脱敏规则：自第 1 位起至第 字符串最大长度 位止，进行脱敏处理
     * 例：齐老二 转换为 齐**
     */
    @HuginPoint(ruleCode = HuginPresetRule.DESENSITIZE, param = {"1", "${length}"})
    private String name;

    /**
     * 手机号
     * 说明：示例脱敏规则：自第 3 位起至第 字符串最大长度减4 位止，进行脱敏处理，并将转换后的内容复制至overTransPhone字段
     * 例：18645113456 转换为 186****3456
     * （因脱敏后存在非数字型字符串，无法回写至Long型字段）
     */
    @HuginPoint(ruleCode = HuginPresetRule.DESENSITIZE, param = {"3", "${length} - 4"}, overTransCopyTo = "overTransPhone")
    private Long phone;

    /**
     * 脱敏后的手机号
     */
    private String overTransPhone;

    /**
     * 年龄
     */
    @HuginPoint(ruleCode = "numberAdd", param = {"1"})
    private Integer age;

}
