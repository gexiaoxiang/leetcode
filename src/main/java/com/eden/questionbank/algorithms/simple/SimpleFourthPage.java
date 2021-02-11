package com.eden.questionbank.algorithms.simple;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author gexx
 * @Description 简单 page 4  size 100
 * @Date 2021/2/8
 **/
public class SimpleFourthPage {

    /**
     * @Description 1313. 解压缩编码列表
     * @Author gexx
     * @Date 2021/2/8
     **/
    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int i1 = 0; i1 < nums[i]; i1++) {
                list.add(nums[i + 1]);
            }
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * @Description 1317. 将整数转换为两个无零整数的和
     * @author gexx
     * @Date 2021/2/8
     **/
    public int[] getNoZeroIntegers(int n) {
        int[] rs = new int[2];
        for (int i = 1; i < n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                return new int[]{i, n - i};
            }
        }
        return rs;
    }


    /**
     * @Description 1323. 6 和 9 组成的最大数字
     * @author gexx
     * @Date 2021/2/8
     **/
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        String s1 = s.replaceFirst("6", "9");
        Integer integer = Integer.valueOf(s1);
        return integer;
    }

    /**
     * @Description: 1374. 生成每种字符都是奇数个的字符串
     * @Author: gexx
     * @Date: 2021/2/19
     **/
    public String generateTheString(int n) {

        StringBuffer ret = new StringBuffer();
        if (n % 2 == 0) {
            ret.append("a");
            for (int i = 0; i < n - 1; i++) {
                ret.append("b");
            }
        } else {
            for (int i = 0; i < n; i++) {
                ret.append("a");
            }
        }

        return ret.toString();
    }

    /**
     * @Description: 1380. 矩阵中的幸运数
     * @Author: gexx
     * @Date: 2021/2/19
     **/
    public List<Integer> luckyNumbers(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[] rMin = new int[r];
        Arrays.fill(rMin, Integer.MAX_VALUE);
        int[] cMax = new int[c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                rMin[i] = Math.min(rMin[i], matrix[i][j]);
                cMax[j] = Math.max(cMax[j], matrix[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == rMin[i] && matrix[i][j] == cMax[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }


    /**
     * @Description 1331. 数组序号转换
     * @author gexx
     * @Date 2021/2/9
     **/
    public int[] arrayRankTransform(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int[] count = new int[max - min + 1];
        for (int num : arr)
            count[num - min] = 1;

        int[] preSum = new int[count.length + 1];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + count[i - 1];

        int[] ans = new int[arr.length];
        int index = 0;
        for (int num : arr)
            ans[index++] = preSum[num - min] + 1;

        return ans;


    }

    /**
     * @Description 1332. 删除回文子序列
     * @author gexx
     * @Date 2021/2/9
     **/
    public int removePalindromeSub(String s) {
        if ("".equals(s)) return 0;
        if (s.equals(new StringBuilder(s).reverse().toString())) return 1;
        return 2;
    }


    /**
     * @Description 1337. 矩阵中战斗力最弱的 K 行
     * @Author gexx
     * @Date 2021/2/9
     **/
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] tmp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            tmp[i][0] = i;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) tmp[i][1] += 1;
            }
        }
        Arrays.sort(tmp, (o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = tmp[i][0];
        return res;

    }

    /**
     * @Description 1342. 将数字变成 0 的操作次数
     * @Author gexx
     * @Date 2021/2/10
     **/
    static int count = 0;

    public static int numberOfSteps(int num) {

        toZero(num);
        return count;
    }

    private static void toZero(int num) {
        if (num == 0) {
            return;
        }
        count++;
        if (num % 2 == 0) {
            toZero(num / 2);
        } else {

            toZero(num - 1);
        }
    }


    /**
     * @Description 1346. 检查整数及其两倍数是否存在
     * @Author gexx
     * @Date 2021/2/10
     **/
    public boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2)))
                return true;
            set.add(i);
        }
        return false;

    }


    /**
     * @Description 1351. 统计有序矩阵中的负数
     * @Author gexx
     * @Date 2021/2/10
     **/
    public int countNegatives(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if (grid[i][i1] >= 0) {
                    num++;
                } else {
                    continue;
                }
            }
        }
        return num;
    }

    /**
     * @Description 1356. 根据数字二进制下 1 的数目排序
     * @author gexx
     * @Date 2021/2/11
     **/
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;

    }

    /**
     * @Description
     * @author gexx
     * @Date 2021/2/11
     **/
    public int daysBetweenDates(String date1, String date2) {
        LocalDate startDate = LocalDate.parse(date1);

        LocalDate endDate = LocalDate.parse(date2);


        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        return Math.abs((int) daysDiff);
    }

    /**
     * @Description 1365. 有多少小于当前数字的数字
     * @author gexx
     * @Date 2021/2/11
     **/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            ret[i] = cnt;
        }
        return ret;
    }

    public static void main(String[] args) {
        numberOfSteps(8);
        decompressRLElist(new int[]{1, 2, 3, 4});
    }
}
