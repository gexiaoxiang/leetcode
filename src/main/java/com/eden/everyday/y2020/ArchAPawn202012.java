package com.eden.everyday.y2020;

import java.util.*;

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

    /**
     * @Description: 649. Dota2 参议院
     * @Author: gexx
     * @Date: 2020/12/11
     **/
    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }


    /**
     * @Description: 714. 买卖股票的最佳时机含手续费
     * @Author: gexx
     * @Date: 2020/12/17
     **/
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];

    }

    /**
     * @Description: 1046. 最后一块石头的重量
     * @Author: gexx
     * @Date: 2020/12/30
     **/
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();


    }

    public static void main(String[] args) {
        predictPartyVictory("RRDDRDDRDR");
        lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5});
    }
}
