package com.eden.everyday.y2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 每日一题
 * @Author: gexx
 * @Date: 2021/1/4
 **/
public class ArchAPawn202101 {
    /**
     * @Description: 斐波那契数
     * @Author: gexx
     * @Date: 2021/1/4
     **/
    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * @Description: 189. 旋转数组
     * @Author: gexx
     * @Date: 2021/1/8
     **/
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);


    }

    /**
     * @Description 123. 买卖股票的最佳时机 III
     * @Author gexx
     * @Date 2021/1/9
     **/
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;

    }

    /**
     * @Description 228. 汇总区间
     * @author gexx
     * @Date 2021/1/10
     **/
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0] + "");
        }
        for (int i = 0; i < nums.length - 1; ) {
            int begin = i;
            while (nums[i] + 1 == nums[i + 1]) {
                if (i < nums.length - 2) {
                    i++;
                } else {
                    i = nums.length - 1;
                    break;
                }
            }
            if (i > begin) {
                result.add(nums[begin] + "->" + nums[i]);
            } else {
                result.add(nums[i] + "");
            }
            if (i == nums.length - 2) {
                result.add(nums[nums.length - 1] + "");
            }
            i++;
        }
        return result;
    }

    /**
     * 1202. 交换字符串中的元素
     *
     * @Author: gexx
     * @Date: 2021/1/11
     **/
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] cs = s.toCharArray();
        init(cs.length);//初始化并查集
        for (List<Integer> list : pairs)
            add(is, list.get(0), list.get(1));//设置根节点关联
        over();//结束并查集
        //相同根节点的进行排序，就是字典序最小的字符串
        //字符串已限制只有小写英文字母，可以使用桶排序，统计每个字符数量
        int[][] map = new int[cs.length][26];//统计根节点字符数量
        int[] ts = new int[cs.length];//记录每个根节点最小字符下标
        for (int i = 0; i < cs.length; i++)
            map[is[i]][cs[i] - 'a']++;//根据根节点，字符统计
        for (int i = 0; i < cs.length; i++) {
            for (int j = ts[is[i]]; j < 26; j++) {//根据记录的最小下标开始遍历
                if (map[is[i]][j] > 0) {//如果某字符不为空
                    map[is[i]][j]--;//记录的字符数量减一
                    cs[i] = (char) ('a' + j);
                    ts[is[i]] = j;//记录新的最小值记录
                    break;
                }
            }
        }
        return new String(cs);
    }

    int[] is;

    public void init(int len) {
        is = new int[len];
        for (int i = 0; i < is.length; i++)
            is[i] = i;
    }

    public void add(int[] is, int a, int b) {
        is[get(is, a)] = get(is, b);
    }

    public int get(int[] is, int a) {
        if (is[a] != a)
            is[a] = get(is, is[a]);
        return is[a];
    }

    public void over() {
        for (int i = 0; i < is.length; i++)
            get(is, i);
    }

    public static void main(String[] args) {
        maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(Arrays.toString("12.22".split("\\|")));
        rotate(new int[]{
                1, 2, 3, 4, 5, 6, 7
        }, 3);
    }
}
