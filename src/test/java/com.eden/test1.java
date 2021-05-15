package com.eden;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/4/9
 * @Version V1.0
 **/
public class test1 {

    public static void main(String[] args) {
        BigDecimal ss=new BigDecimal("4.5");
        BigDecimal bigDecimal = ss.setScale(6, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
    }
}
