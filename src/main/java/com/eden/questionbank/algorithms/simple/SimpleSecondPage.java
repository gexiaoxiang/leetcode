package com.eden.questionbank.algorithms.simple;

import com.eden.CollectionUtils;

import java.util.*;

/**
 * @Description: 简单2  page2 size 100
 * @Author: gexx
 * @Date: 2020/7/6
 **/
public class SimpleSecondPage {

    /**
     * @Description: 数字转换为十六进制数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static String toHex(int num) {
        StringBuffer buffer = new StringBuffer();
        char[] arr = "0123456789abcdef".toCharArray();
        if (num == 0) {
            return "0";
        }
        while (num != 0) {
            int tmp = num & 15;
            buffer.append(arr[tmp]);
            num = num >>> 4;
        }

        return buffer.reverse().toString();


    }

    /**
     * @Description: 最长回文串
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * @Description: 第三大的数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        List list = new ArrayList<>();
        list.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] != nums[i]) {
                list.add(nums[i]);
            }
        }
        if (list.size() < 3) {
            return (int) list.get(0);
        }

        return (int) list.get(2);
    }

    /**
     * @Description: 字符串相加
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();

    }

    /**
     * @Description: 字符串中的单词数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int countSegments(String s) {
        String trimmed = s.trim();
        if ("".equals(trimmed)) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @Description: 路径总和 III
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>(4);
        map.put(0, 1);
        return helper(root, map, sum, 0);
    }

    public int helper(TreeNode node, Map<Integer, Integer> map, int sum, int pathSum) {
        if (node == null) {
            return 0;
        }
        int curSum = pathSum + node.val;
        int res = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += helper(node.left, map, sum, curSum);
        res += helper(node.right, map, sum, curSum);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }

    /**
     * @Description: 排列硬币
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public int arrangeCoins(int n) {

        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    /**
     * @Description: 压缩字符串
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    /**
     * @Description: 找到所有数组中消失的数字
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * @Description: 最小移动次数使数组元素相等
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }

        return count;
    }

    /**
     * @Description: 分发饼干
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;

    }

    /**
     * @Description: 重复的子字符串
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    /**
     * @Description: 岛屿的周长
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public static int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    static int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    /**
     * @Description: 供暖器
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int right = 0;
        for (int i = 0; i < houses.length; i++) {
            // 找到恰好比当前房屋大的加热器
            while (right + 1 < heaters.length && heaters[right] < houses[i]) {
                right++;
            }
            // 特判， 否则会出现越界
            if (right == 0) {
                res = Math.max(res, Math.abs(heaters[right] - houses[i]));
            } else {
                res = Math.max(res, Math.min(Math.abs(heaters[right] - houses[i]), Math.abs(houses[i] - heaters[right - 1])));
            }
        }
        return res;


    }

    /**
     * @Description: 数字的补数
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public static int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder binaryReverse = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                binaryReverse.append('1');
            } else {
                binaryReverse.append('0');
            }
        }
        return Integer.parseInt(binaryReverse.toString(), 2);
    }

    /**
     * @Description: 密钥格式化
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public static String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "");
        s = s.toUpperCase();
        int stLen = s.length() % k == 0 ? k : s.length() - s.length() / k * k;
        StringBuffer str = new StringBuffer(s);
        for (int i = stLen; i < str.length(); i = i + k + 1) {
            str = str.insert(i, "-");
        }
        return str.toString();

    }

    /**
     * @Description: 构造矩形
     * @Author: gexx
     * @Date: 2020/7/7
     **/
    public static int[] constructRectangle(int area) {
//长度 L 和宽度 W 之间的差距应当尽可能小 正方形就最小
        int[] re = new int[2];
        double sqrt = Math.sqrt(area);
        if (((int) sqrt - sqrt == 0)) {
            re[0] = (int) sqrt;
            re[1] = (int) sqrt;
        } else {
            re[0] = (int) sqrt + 1;
            double w = (double) area / (double) re[0];
            while ((int) w - w != 0) {
                re[0] = re[0] + 1;
                w = (double) area / (double) re[0];
            }
            re[1] = (int) w;
        }


        return re;
    }

    /**
     * @Description: 下一个更大元素 I
     * @Author: gexx
     * @Date: 2020/7/9
     **/
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;

    }

    /**
     * @Description: 键盘行
     * @Author: gexx
     * @Date: 2020/7/9
     **/
    public static String[] findWords(String[] words) {
        String line1st = "qwertyuiop";
        String line2nd = "asdfghjkl";
        List list = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            for (int j = 0; j < words[i].length(); j++) {
                //逐个统计单词的每个字母来自哪一行
                if (line1st.contains(String.valueOf(words[i].charAt(j)).toLowerCase())) {
                    count1++;
                } else if (line2nd.contains(String.valueOf(words[i].charAt(j)).toLowerCase())) {
                    count2++;
                } else {
                    count3++;
                }
            }
            //如果单词的长度等于它的字符在三行中出现的最大次数，则说明该单词全来自该行。
            if (words[i].length() == Math.max(count3, Math.max(count1, count2))) {
                list.add(words[i]);
            }
        }
        String[] findWords = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            findWords[i] = list.get(i).toString();
        }

        return findWords;
    }

    int maxTimes = 0;
    int thisTimes = 0;
    List<Integer> res = new LinkedList<Integer>();
    TreeNode pre = null;

    /**
     * @Description: 二叉搜索树中的众数
     * @Author: gexx
     * @Date: 2020/7/9
     **/
    public int[] findMode(TreeNode root) {

        inOrder(root);
        int length = res.size();
        int[] rr = new int[length];
        for (int i = 0; i < length; i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null && pre.val == root.val) {
            thisTimes++;
        } else {
            thisTimes = 1;
        }
        if (thisTimes == maxTimes) {
            res.add(root.val);
        } else if (thisTimes > maxTimes) {
            maxTimes = thisTimes;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }

    /**
     * @Description: 七进制数
     * @Author: gexx
     * @Date: 2020/7/9
     **/
    public static String convertToBase7(int num) {

        return Integer.toString(num, 7);

    }

    /**
     * @Description: 相对名次
     * @Author: gexx
     * @Date: 2020/7/9
     **/
    public static String[] findRelativeRanks(int[] nums) {
        int[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);
        Map map = new HashMap();
        for (int i = 0; i < sortNums.length; i++) {
            if (i == sortNums.length - 1) {
                map.put(sortNums[i], "Gold Medal");
            } else if (i == sortNums.length - 2) {
                map.put(sortNums[i], "Silver Medal");
            } else if (i == sortNums.length - 3) {
                map.put(sortNums[i], "Bronze Medal");
            } else {
                map.put(sortNums[i], sortNums.length - i);
            }
        }
        String[] ranks = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ranks[i] = String.valueOf(map.get(nums[i]));
        }

        return ranks;
    }

    /**
     * @Description: 完美数
     * @Author: gexx
     * @Date: 2020/7/9
     **/
    public boolean checkPerfectNumber(int num) {
//奇数不是完美数
        if (num % 2 != 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum - num == num;

    }

    /**
     * @Description: 检测大写字母
     * @Author: gexx  a
     * @Date: 2020/7/9
     **/
    public static boolean detectCapitalUse(String word) {

        int lowerCount = 0;
        int upperCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a') {
                lowerCount++;
            } else {
                upperCount++;
            }
        }
        if (lowerCount == 0 || upperCount == 0) {
            return true;
        } else if (upperCount == 1 && word.charAt(0) < 'a') {
            return true;
        }

        return false;
    }

    /**
     * @Description: 二叉搜索树的最小绝对差
     * @Author: gexx
     * @Date: 2020/7/13
     **/
    // 初始化最小值
    int min = Integer.MAX_VALUE;
    // 前一个节点，初始化为null
    TreeNode pre1 = null;

    public int getMinimumDifference(TreeNode root) {
        pre(root);
        return min;
    }

    public void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历
        pre(root.left);
        // 判空，寻找最小差值
        if (pre1 != null) {
            min = Math.min(min, root.val - pre1.val);
        }
        // 将此节点设置为前一节点
        pre1 = root;
        pre(root.right);
    }

    /**
     * @Description: 数组中的K-diff数对
     * @Author: gexx
     * @Date: 2020/7/13
     **/

    public int findPairs(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - k > nums[i]) {
                    break;
                }
                if (nums[j] - k == nums[i]) {
                    count++;
                    break;
                }
            }
        }
        return count;

    }

    /**
     * @Description: 把二叉搜索树转换为累加树
     * @Author: gexx
     * @Date: 2020/7/13
     **/
    static int sum = 0;

    public static TreeNode convertbst(TreeNode root) {
        if (root != null) {
            convertbst(root.right);
            sum += root.val;
            root.val = sum;
            convertbst(root.left);
        }
        return root;
    }

    /**
     * @Description: 反转字符串 II
     * @Author: gexx
     * @Date: 2020/7/14
     **/
    static StringBuffer re = new StringBuffer();

    public static String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer(s);
        if (sb.length() < k) {
            sb.reverse();
            re.append(sb.toString());
        } else if (sb.length() > 2 * k) {
            StringBuffer sb2 = new StringBuffer(s.substring(0, k));
            re.append(sb2.reverse()).append(s.substring(k, 2 * k));
            reverseStr(s.substring(2 * k), k);
        } else {
            StringBuffer sb2 = new StringBuffer(s.substring(0, k));
            re.append(sb2.reverse()).append(s.substring(k, s.length()));
        }

        return re.toString();
    }

    int ans;

    /**
     * @Description: 二叉树的直径
     * @Author: gexx
     * @Date: 2020/7/14
     **/
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int l = depth(node.left); // 左儿子为根的子树的深度
        int r = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, l + r + 1); // 计算d_node即L+r+1 并更新ans
        return Math.max(l, r) + 1; // 返回该节点为根的子树的深度
    }

    /**
     * @Description: 学生出勤记录 I
     * @Author: gexx
     * @Date: 2020/7/14
     **/
    public boolean checkRecord(String s) {
        String l = s.replaceAll("L", "");
        String lp = l.replaceAll("P", "");
        if (lp.contains("AA")) {
            return false;
        }
        if (s.contains("LLL")) {
            return false;
        }

        return true;
    }

    /**
     * @Description: 二叉树的坡度
     * @Author: gexx
     * @Date: 2020/7/14
     **/
    int tilt = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }

    /**
     * @Description: 重塑矩阵
     * @Author: gexx
     * @Date: 2020/7/14
     **/
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int size = nums.length * nums[0].length;
        if (size != r * c) {
            return nums;
        }
        int[][] newnums = new int[r][c];
        int col = nums[0].length;
        for (int i = 0; i < r * c; i++) {
            newnums[i / c][i % c] = nums[i / col][i % col];
        }
        return newnums;
    }

    /**
     * @Description: 另一个树的子树
     * @Author: gexx
     * @Date: 2020/7/14
     **/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;   // t 为 null 一定都是 true
        }
        if (s == null) {
            return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    /**
     * @Description: 分糖果
     * @Author: gexx
     * @Date: 2020/7/15
     **/
    public int distributeCandies(int[] candies) {
        Set set = new HashSet();
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }

    /**
     * @Description: 最短无序连续子数组
     * @Author: gexx
     * @Date: 2020/7/15
     **/
    public static int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int start = 0;
        int end = 0;
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] != clone[x]) {
                start = x;
                break;
            }
        }
        for (int x = nums.length - 1; x > 0; x--) {
            if (nums[x] != clone[x]) {
                end = x;
                break;
            }
        }
        return start == end ? 0 : end - start + 1;
    }

    /**
     * @Description: 长和谐子序列
     * @Author: gexx
     * @Date: 2020/7/15
     **/
    public static int findlhs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>((int) (nums.length / 0.75F + 1.0F));
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                result = Math.max(countMap.get(key) + countMap.get(key + 1), result);
            }
        }
        return result;

    }

    /**
     * @Description: 范围求和 II
     * @Author: gexx
     * @Date: 2020/7/16
     **/
    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int x = 0; x < ops.length; x++) {
            minM = Math.min(minM, ops[x][0]);
            minN = Math.min(minN, ops[x][1]);
        }
        return minM * minN;

    }

    /**
     * @Description: 种花问题
     * @Author: gexx
     * @Date: 2020/7/16
     **/
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            //处理头部
            if (i == 0 && flowerbed[0] == 0 && flowerbed.length > 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                n--;
            }//处理尾部
            if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed.length > 2 && flowerbed[flowerbed.length - 2] == 0) {
                flowerbed[flowerbed.length - 1] = 1;
                n--;
            }
            //中间部分
            if (i > 0 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && i < flowerbed.length - 1 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }

        }
        return n <= 0;
    }

    /**
     * @Description: 根据二叉树创建字符串
     * @Author: gexx
     * @Date: 2020/7/17
     **/
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    /**
     * @Description: 合并二叉树
     * @Author: gexx
     * @Date: 2020/7/17
     **/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    /**
     * @Description: 三个数的最大乘积
     * @Author: gexx
     * @Date: 2020/7/17
     **/
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[nums.length - 1] * nums[0] * nums[1]);
    }


    /**
     * @Description 平方数之和
     * @Author gexx
     * @Date 2020/7/18
     **/
    public boolean judgeSquareSum(int c) {

        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 二叉树的层平均值
     * @Author: gexx
     * @Date: 2020/7/20
     **/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }

    public void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }

    /**
     * @Description: 子数组最大平均数 I
     * @Author: gexx
     * @Date: 2020/7/21
     **/

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }

        //记录第一个i  和  i+k   sum+nums[i+k-1]-nums[i-1];
        int temp = sum;
        for (int i = 1; i + k - 1 < nums.length; ++i) {
            temp = temp + nums[i + k - 1] - nums[i - 1];
            if (temp > sum) {
                sum = temp;
            }
        }

        return sum / (double) k;

    }

    /**
     * @Description: 错误的集合
     * @Author: gexx
     * @Date: 2020/7/21
     **/
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }
        return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : missing};

    }

    /**
     * @Description: 两数之和 IV - 输入 BST
     * @Author: gexx
     * @Date: 2020/7/21
     **/
    public boolean findTarget(TreeNode root, int k) {
        Set set = new HashSet();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set set) {
        if (null == root) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);

    }

    /**
     * @Description: 非递减数列
     * @Author: gexx
     * @Date: 2020/8/14
     **/
    public static boolean checkPossibility(int[] nums) {

        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                sum++;
                if (sum >= 2) {
                    return false;
                }
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return true;
    }

    /**
     * @Description: 修剪二叉搜索树
     * @Author: gexx
     * @Date: 2020/8/19
     **/
    public TreeNode trimbst(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (root.val > R) {
            return trimbst(root.left, L, R);
        }
        if (root.val < L) {
            return trimbst(root.right, L, R);
        }

        root.left = trimbst(root.left, L, R);
        root.right = trimbst(root.right, L, R);
        return root;
    }

    /**
     * @Description: 二叉树中第二小的节点
     * @Author: gexx
     * @Date: 2020/8/19
     **/
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return find(root, root.val);
    }


    private int find(TreeNode x, int rootValue) {
        if (x.val != rootValue) {
            return x.val;
        }

        if (x.left == null) {
            return -1;
        }
        int leftMin = find(x.left, rootValue);
        int rightMin = find(x.right, rootValue);
        if (leftMin == -1) {
            return rightMin;
        }
        if (rightMin == -1) {
            return leftMin;
        }
        return Math.min(leftMin, rightMin);
    }

    /**
     * @Description: 最长连续递增序列
     * @Author: gexx
     * @Date: 2020/9/23
     **/
    public static int findlengthoflcis(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxlength = 1;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                maxlength++;
            } else {
                max = Math.max(max, maxlength);
                maxlength = 1;
            }
        }
        return Math.max(max, maxlength);
    }

    /**
     * @Description: 验证回文字符串 Ⅱ
     * @Author: gexx
     * @Date: 2020/9/23
     **/
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    Integer calpointsdpeek = stack.peek();
                    stack.push(calpointsdpeek * 2);
                    break;
                case "+":
                    Integer calPointsAddPop = stack.pop();
                    Integer calPointsAddPeek = stack.peek();
                    stack.push(calPointsAddPop);
                    stack.push(calPointsAddPop + calPointsAddPeek);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }
        return stack.stream().reduce(Integer::sum).orElse(0);
    }

    /**
     * @Description: 最长同值路径
     * @Author: gexx
     * @Date: 2020/9/23
     **/
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> emap;

    /**
     * @Description: 员工的重要性
     * @Author: gexx
     * @Date: 2020/9/23
     **/
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e : employees) {
            emap.put(e.id, e);
        }
        return dfs(queryid);
    }

    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates) {
            ans += dfs(subid);
        }
        return ans;
    }

    /**
     * @Description: 交替位二进制数
     * @Author: gexx
     * @Date: 2020/9/23
     **/
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 计数二进制子串
     * @Author: gexx
     * @Date: 2020/9/23
     **/
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }

    /**
     * @Description: 数组的度
     * @Author: gexx
     * @Date: 2020/9/24
     **/
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) {
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }

    /**
     * @Description: 转换成小写字母
     * @Author: gexx
     * @Date: 2020/9/24
     **/
    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] += 32;
            }
        }
        return String.valueOf(ch);
    }

    /**
     * @Description: . 1比特与2比特字符
     * @Author: gexx
     * @Date: 2020/9/24
     **/
    public boolean isOneBitCharacter(int[] bits) {

        for (int i = 0; i <= bits.length - 1; ) {
            if (0 == bits[i]) {
                if (i == bits.length - 1) {
                    return true;
                }
                i++;
            } else {
                i += 2;
            }
        }

        return false;
    }

    /**
     * @Description: 词典中最长的单词
     * @Author: gexx
     * @Date: 2020/9/24
     **/
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word : words) {
            wordset.add(word);
        }
        for (String word : words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    /**
     * 自除数      * @Author: gexx
     *
     * @Date: 2020/9/24
     **/
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) {
                ans.add(n);
            }
        }
        return ans;
    }

    public boolean selfDividing(int n) {
        for (char c : String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 使用最小花费爬楼梯
     * @Author: gexx
     * @Date: 2020/9/25
     **/
    public static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);

    }

    /**
     * @Description: 最短完整词
     * @Author: gexx
     * @Date: 2020/9/25
     **/
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for (String word : words) {
            if ((word.length() < ans.length() || ans.length() == 0) &&
                    dominates(count(word.toLowerCase()), target)) {
                ans = word;
            }
        }
        return ans;
    }

    public boolean dominates(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i) {
            if (count1[i] < count2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] count(String word) {
        int[] ans = new int[26];
        for (char letter : word.toCharArray()) {
            int index = Character.toLowerCase(letter) - 'a';
            if (0 <= index && index < 26) {
                ans[index]++;
            }
        }
        return ans;
    }

    /**
     * @Description: 二进制表示中质数个计算置位
     * @Author: gexx
     * @Date: 2020/9/25
     **/
    public int countPrimeSetBits(int l, int r) {
        int ans = 0;
        for (int x = l; x <= r; ++x) {
            if (isSmallPrime(Integer.bitCount(x))) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }

    /**
     * @Description: 托普利茨矩阵
     * @Author: gexx
     * @Date: 2020/9/27
     **/
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r - c)) {
                    groups.put(r - c, matrix[r][c]);
                } else if (groups.get(r - c) != matrix[r][c]) {
                    return false;
                }
            }
        }

        return true;

    }

    /**
     * @Description: 旋转数字
     * @Author: gexx
     * @Date: 2020/9/27
     **/
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int a = 1; a <= n; ++a) {
            if (good(a, false)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean good(int n, boolean flag) {
        if (n == 0) {
            return flag;
        }

        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) {
            return false;
        }
        if (d == 0 || d == 1 || d == 8) {
            return good(n / 10, flag);
        }
        return good(n / 10, true);
    }


    /**
     * @Description: 旋转字符串
     * 给定两个字符串, a 和 B。
     * <p>
     * a 的旋转操作就是将 a 最左边的字符移动到最右边。 例如, 若 a = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，a 能变成B，那么返回True。
     * <p>
     * <p>
     * 注意：
     * <p>
     * a 和 B 长度不超过 100。
     * @Author: gexx
     * @Date: 2020/11/19
     **/
    public static boolean rotateString(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }


    /**
     * @Description: 唯一摩尔斯密码词
     * @Author: gexx
     * @Date: 2020/11/26
     **/
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet set = new HashSet();
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                word += morse[ch - 'a'];

            }
            set.add(word);

        }

        return set.size();
    }


    /**
     * @Description: 写字符串需要的行数
     * @Author: gexx
     * @Date: 2020/12/2
     **/
    public int[] numberOfLines(int[] widths, String s) {
        int lenth = 0;
        int row = 1;
        for (char c : s.toCharArray()) {
            if (100 > lenth + widths[c - 'a']) {
                lenth += widths[c - 'a'];
            } else if (100 < lenth + widths[c - 'a']) {
                row++;
                lenth = widths[c - 'a'];
            } else {
                row++;
                lenth = 0;
            }
        }

        return new int[]{row, lenth};
    }

    /**
     * @Description: 域名访问计数
     * @Author: gexx
     * @Date: 2020/12/2
     **/

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> ma = new HashMap();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] s = cpdomains[i].split(" ");
            int c = Integer.valueOf(s[0]);
            String s1 = s[1];
            ma.put(s1, Integer.valueOf(ma.getOrDefault(s1, 0).toString()) + c);
            if (s1.indexOf(".") > -1) {
                //二级域名
                String s2 = s1.substring(s1.indexOf(".") + 1);
                ma.put(s2, Integer.valueOf(ma.getOrDefault(s2, 0).toString()) + c);
                if (s2.indexOf(".") > -1) {
                    //二级域名
                    String s3 = s2.substring(s2.indexOf(".") + 1);
                    ma.put(s3, Integer.valueOf(ma.getOrDefault(s3, 0).toString()) + c);
                }

            }

        }
        List list = new ArrayList<>();
        for (String key : ma.keySet()) {
            Integer integer = ma.get(key);
            String re = String.valueOf(integer) + " " + key;
            list.add(re);
        }


        return list;
    }

    /**
     * @Description: 最大三角形面积
     * @Author: gexx
     * @Date: 2020/12/10
     **/
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    area = Math.max(area, area(points[i], points[j], points[k]));
                }
            }
        }


        return area;
    }

    private double area(int[] point, int[] point1, int[] point2) {
        double a = distance(point, point1);
        double b = distance(point1, point2);
        double c = distance(point2, point);
        if (a + b > c && a + c > b && b + c > a) {
            double p = 0.5 * (a + b + c);
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return 0;
    }

    //计算2点之间的距离
    public double distance(int[] a, int[] b) {
        double x = b[0] - a[0];
        double y = b[1] - a[1];
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * @Description: 819. 最常见的单词
     * @Author: gexx
     * @Date: 2020/12/10
     **/
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word : banned) {
            banset.add(word);
        }
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

    /**
     * @Description: 字符的最短距离
     * @Author: gexx
     * @Date: 2020/12/10
     **/
    public static int[] shortestToChar(String s, char c) {

        List<Integer> l = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                l.add(i);
            }
        }
        int[] re = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int minFar = chars.length;
            for (int j = 0; j < l.size(); j++) {
                if (minFar > Math.abs(i - l.get(j))) {
                    minFar = Math.abs(i - l.get(j));
                }
            }
            re[i] = minFar;
        }

        return re;
    }

    /**
     * @Description: 824. 山羊拉丁文
     * @Author: gexx
     * @Date: 2020/12/11
     **/
    public String toGoatLatin(String s) {

        Set<Character> vowel = new HashSet();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
            vowel.add(c);
        }

        int t = 1;
        StringBuilder ans = new StringBuilder();
        for (String word : s.split(" ")) {
            char first = word.charAt(0);
            if (vowel.contains(first)) {
                ans.append(word);
            } else {
                ans.append(word.substring(1));
                ans.append(word.substring(0, 1));
            }
            ans.append("ma");
            for (int i = 0; i < t; i++) {
                ans.append("a");
            }
            t++;
            ans.append(" ");
        }

        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    /**
     * @Description: 830. 较大分组的位置
     * @Author: gexx
     * @Date: 2020/12/11
     **/
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> biggerGroups = new ArrayList<>();
        String[] ss = s.split("");
        for (int i = 0; i < ss.length - 1; ) {

            int count = 0;
            List<Integer> biggerGroup = new ArrayList<>();
            for (int j = i + 1; j < ss.length; j++) {
                if (ss[i].equals(ss[j])) {
                    count++;
                    if (j == ss.length - 1) {
                        if (count >= 2) {
                            biggerGroup.add(i);
                            biggerGroup.add(j);
                            i = j;
                            break;
                        } else {
                            i++;
                        }
                    }
                } else if (count >= 2) {
                    biggerGroup.add(i);
                    biggerGroup.add(j - 1);
                    i = j;
                    break;
                } else {
                    i++;
                    break;
                }

            }
            if (!CollectionUtils.isEmpty(biggerGroup)) {
                biggerGroups.add(biggerGroup);
            }
        }
        return biggerGroups;
    }

    /**
     * @Description: 832. 翻转图像
     * @Author: gexx
     * @Date: 2020/12/11
     **/
    public int[][] flipAndInvertImage(int[][] a) {
        int c = a[0].length;
        for (int[] row : a) {
            for (int i = 0; i < (c + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[c - 1 - i] ^ 1;
                row[c - 1 - i] = tmp;
            }
        }

        return a;
    }

    /**
     * @Description: 836. 矩形重叠
     * @Author: gexx
     * @Date: 2020/12/11
     **/
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));


    }

    public static void main(String[] args) {

        largeGroupPositions("abbxxxxzzy");
        shortestToChar("loveleetcode", 'e');

        mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
        minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        toLowerCase("Hello");
        System.out.println(rotateString("abcde", "cdeab"));
    }
}
