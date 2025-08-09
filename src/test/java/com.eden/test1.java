package com.eden;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/4/9
 * @Version V1.0
 **/


public class test1 {

    public static void main(String[] args) {
        List<Map<String, Object>> ll = new ArrayList<>();
        String uuid = UUID.randomUUID().toString();
        Advice advice = new Advice();
        advice.setS1(uuid);
        advice.setS2(uuid);
        advice.setS3(uuid);
        advice.setS4(uuid);
        advice.setS5(uuid);
        advice.setS6(uuid);
        advice.setS7(uuid);
        advice.setS8(uuid);
        advice.setS9(uuid);
        advice.setS10(uuid);
        advice.setS11(uuid);
        advice.setS12(uuid);
        advice.setS13(uuid);
        advice.setS14(uuid);
        advice.setS15(uuid);
        advice.setS16(uuid);
        advice.setS17(uuid);
        advice.setS18(uuid);
        advice.setS19(uuid);
        advice.setS20(uuid);
        advice.setS21(uuid);
        advice.setS22(uuid);
        advice.setS23(uuid);
        advice.setS24(uuid);
        advice.setS25(uuid);
        advice.setS26(uuid);
        advice.setS27(uuid);
        advice.setS28(uuid);
        advice.setS29(uuid);
        advice.setS30(uuid);
        advice.setS31(uuid);
        advice.setS32(uuid);
        advice.setS33(uuid);
        advice.setS34(uuid);
        advice.setS35(uuid);
        advice.setS36(uuid);
        advice.setS37(uuid);
        advice.setS38(uuid);
        advice.setS39(uuid);
        advice.setS40(uuid);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(advice));
        for (int i = 0; i < 600000; i++) {
            System.out.println(i);
            ll.add(jsonObject);
        }
    }

    @Data
    static
    class Advice {
        private String s1;
        private String s2;
        private String s3;
        private String s4;
        private String s5;
        private String s6;
        private String s7;
        private String s8;
        private String s9;
        private String s10;
        private String s11;
        private String s12;
        private String s13;
        private String s14;
        private String s15;
        private String s16;
        private String s17;
        private String s18;
        private String s19;
        private String s20;
        private String s21;
        private String s22;
        private String s23;
        private String s24;
        private String s25;
        private String s26;
        private String s27;
        private String s28;
        private String s29;
        private String s30;
        private String s31;
        private String s32;
        private String s33;
        private String s34;
        private String s35;
        private String s36;
        private String s37;
        private String s38;
        private String s39;
        private String s40;
    }

}
