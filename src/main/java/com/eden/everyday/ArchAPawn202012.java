package com.eden.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 每日一题
 * @Author: gexx
 * @Date: 2020/12/10
 **/
public class ArchAPawn202012 {

    /**
     * @Description: 860. 柠檬水找零
     * @Author: gexx
     * @Date: 2020/12/10
     **/
    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();//钱包
        for (int i = 0; i < bills.length; i++) {
            //按顺序放进钱包
            map.put(bills[i], map.getOrDefault(bills[i], 0) + 1);
            if (bills[i] == 10) {//找零5元
                Integer m5 = map.get(5);//5元的数量
                if (m5 == null || m5 == 0) {
                    return false;
                }
                map.put(5, m5 - 1);

            } else if (bills[i] == 20) {//找零15
                Integer m5 = map.get(5);
                if (m5 == null || m5 == 0) {
                    return false;
                }
                map.put(5, m5 - 1);
                m5 = m5 - 1;

                Integer m10 = map.get(10);
                if (m10 != null && m10 > 0) {
                    map.put(10, m10 - 1);
                } else if (m5 >= 2) {
                    map.put(5, m5 - 2);
                } else {
                    return false;
                }


            }


        }


        return true;
    }


    public static void main(String[] args) {
        lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5});
    }
}
