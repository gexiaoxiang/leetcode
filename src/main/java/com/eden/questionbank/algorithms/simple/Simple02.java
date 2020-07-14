package com.eden.questionbank.algorithms.simple;

import java.util.*;

/**
 * @Description: 简单2  page2 size 100
 * @Author: gexx
 * @Date: 2020/7/6
 **/
public class Simple02 {

    /**
     * @Description: 数字转换为十六进制数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static String toHex(int num) {
        StringBuffer buffer = new StringBuffer();
        char[] arr = "0123456789abcdef".toCharArray();
        if (num == 0) return "0";
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
        for (char c : s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
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
        if (carry == 1) res.append(1);
        return res.reverse().toString();

    }

    /**
     * @Description: 字符串中的单词数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
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
    public static String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        S = S.toUpperCase();
        int stLen = S.length() % K == 0 ? K : S.length() - S.length() / K * K;
        StringBuffer str = new StringBuffer(S);
        for (int i = stLen; i < str.length(); i = i + K + 1) {
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
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
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
        if (num % 2 != 0) return false;
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
        if (root == null)
            return;
        // 中序遍历
        pre(root.left);
        // 判空，寻找最小差值
        if (pre1 != null)
            min = Math.min(min, root.val - pre1.val);
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
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
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

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
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
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    /**
     * @Description: 学生出勤记录 I
     * @Author: gexx
     * @Date: 2020/7/14
     **/
    public boolean checkRecord(String s) {
        String L = s.replaceAll("L", "");
        String LP = L.replaceAll("P", "");
        if (LP.contains("AA")) return false;
        if (s.contains("LLL"))
            return false;

        return true;
    }

    public static void main(String[] args) {

        System.out.println(reverseStr("abcdefg", 2));
        detectCapitalUse("azAZ");
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
        System.out.println(convertToBase7(-7));
        System.out.println(addStrings("1234", "1234"));
        System.out.println(toHex(26));
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(thirdMax(new int[]{1, 1, 2}));
        System.out.println(countSegments(""));
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(repeatedSubstringPattern("ababab"));
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(grid));
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findComplement(5));
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
        System.out.println(Arrays.toString(constructRectangle(5)));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        convertBST(root);
    }
}
