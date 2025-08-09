package com.eden.questionbank.algorithms.medium;

import java.util.*;

/**
 * @Description: 中等 page 1  size 100
 * @Author gexx
 * @Date 2021/3/19
 * @Version V1.0
 **/
public class MidumFirstPage {

    /**
     * @Description: 6. Z 字形变换
     * @Author: gexx
     * @Date: 2021/3/19
     **/
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * @Description: 12. 整数转罗马数字
     * @Author: gexx
     * @Date: 2021/3/19
     **/
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();

    }

    /**
     * @Description: 31. 下一个排列
     * @Author: gexx
     * @Date: 2021/3/19
     **/
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     * @Description: 39. 组合总和
     * @Author: gexx
     * @Date: 2021/3/22
     **/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    /**
     * @Description: 45. 跳跃游戏 II
     * @Author: gexx
     * @Date: 2021/3/30
     **/
    public static int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    boolean[] vis;

    /**
     * @Description: 47. 全排列 II
     * @Author: gexx
     * @Date: 2021/3/30
     **/
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    /**
     * @Description: 47. 全排列 II
     * @Author: gexx
     * @Date: 2021/3/30
     **/
    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    /**
     * 57. 插入区间
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    /**
     * @Description: 63. 不同路径 II
     * @Author: gexx
     * @Date: 2021/8/3
     **/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];

    }

    /**
     * @Description: 14  71. 简化路径
     * @Author: gexx
     * @Date: 2021/8/3
     **/
    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for (int i = 0; i < res.length; i++) {
            String s = res[i];
            if (s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    /**
     * @Description: 15  77. 组合
     * @Author: gexx
     * @Date: 2021/8/4
     **/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }

    /**
     * 313. 超级丑数
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {

        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }


    public static int nthSuperUglyNumber1(int[] primes) {
        int prime = primes[0];
        for (int i = 0; i < primes.length; i++) {
            prime = prime ^ primes[i];
        }
        return prime;
    }




    public  static String concatHex36(int n) {
        String[] chars = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int i = n*n*n;
        StringBuilder sb = new StringBuilder();
        while(i!=0){
            sb.append(chars[i%36]);
            i /= 36;
        }
        i = n*n;
        while(i!=0){
            sb.append(chars[i%16]);
            i/=16;
        }
        return sb.reverse().toString();
    }

    private static int pocss(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for  (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += pocss(arr, index + 1, rest - arr[index] * zhang);
        }
        return ways;
    }


    private static int pocssDP(int[] arr, int rest) {
        int n = arr.length;
        int[][] dp = new int[n + 1][rest + 1];
        dp[0][0] = 1; // Base case: 0 elements, sum 0 -> 1 way

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= rest; j++) {
                dp[i][j] = dp[i - 1][j]; // Not using arr[i-1] at all
                // Try using arr[i-1] k times (1 or more)
                if (j >= arr[i - 1]) {
                    dp[i][j] += dp[i][j - arr[i - 1]]; // Using arr[i-1] once (can be repeated)
                }
            }
        }

        return dp[n][rest];
    }
    private static int pocess(int[] weight, int[] values, int i, int alreadyWeight, int aavalue, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }

        if (i == weight.length) {
            return aavalue;
        }
        int no = pocess(weight, values, i + 1, alreadyWeight, aavalue, bag);
        int has = pocess(weight, values, i + 1, alreadyWeight + weight[i], aavalue + values[i], bag);
        return Math.max(no, has);

    }
    public  static  int numberOfChild(int n, int k) {
        boolean r = true;
        int i = 0;
        int j=0;
        while (j!=k) {
            if (r) {
                if (i != n - 1) {
                    i++;
                } else {
                    r = false;
                }
            } else {
                if (i != 0) {
                    i--;
                } else {
                    r = true;

                }
            }

            j++;
        }
        return i;
    }

    public static int findMiddleIndex(int[] nums) {
        int middleIndex = 0;
        int sumL = 0;
        int sumR = 0;
        for (int i = 1; i < nums.length; i++) {
            sumR += nums[i];

        }
        while (  middleIndex < nums.length) {

            if (middleIndex != 0) {
                sumR -= nums[middleIndex];
                sumL += nums[middleIndex - 1];
            }
            if(sumL != sumR){
                return middleIndex;
            }
            middleIndex++;
        }

        return -1;
    }

    public static String digitSum(String s, int k) {

        while (s.length() > k) {
            List<String> l = new ArrayList();
            while (s.length() >0) {

                l.add(s.substring(0,k>s.length()?s.length():k));

                s = s.substring(k>s.length()?s.length():k );


            }
            System.out.println(l);
            s="";
            for(String e:l){
                int sum=0;

                while(e.length()>0){
                    sum+=Integer.valueOf(e.substring(0,1));
                    e=e.substring(1,e.length());
                }

                s+=String.valueOf(sum);
            }
        }
        return s;
    }
    public static void main(String[] args) {
        digitSum("475730385258137",13);
    }

    }


