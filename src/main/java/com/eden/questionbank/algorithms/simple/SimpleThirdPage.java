package com.eden.questionbank.algorithms.simple;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

/**
 * @Description: 简单 page 3  size 100
 * @Author: gexx
 * @Date: 2020/12/16
 **/
public class SimpleThirdPage {
    /**
     * @Description: 比较含退格的字符串
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static boolean backspaceCompare(String S, String T) {
        int sL = S.length();
        int tL = T.length();
        boolean eq;
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < sL; i++) {
            if (S.charAt(i) == '#' && sbs.length() != 0) {
                sbs.deleteCharAt(sbs.length() - 1);
            } else {
                sbs.append(S.charAt(i));
            }
        }
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < tL; i++) {
            if (T.charAt(i) == '#' && sbl.length() != 0) {
                sbl.deleteCharAt(sbl.length() - 1);
            } else {
                sbl.append(T.charAt(i));
            }
        }
        eq = sbs.toString().replace("#", "").equals(sbl.toString().replace("#", ""));

        return eq;
    }

    /**
     * @Description: 山脉数组的峰顶索引
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static int peakIndexInMountainArray(int[] arr) {
        int top = -1;
        int topIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > top) {
                top = arr[i];
                topIndex = i;
            } else {
                return topIndex;
            }


        }
        return topIndex;
    }

    /**
     * @Description: 859. 亲密字符串
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c : count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }


    /**
     * @Description: 867. 转置矩阵
     * @Author: gexx
     * [1,2,3]     [1,4,7]
     * [4,5,6]     [2,5,8]
     * [7,8,9]     [3,6,9]
     * <p>
     * [1,2,3] [1,4]
     * [4,5,6] [2,5]
     * [3,6]
     * @Date: 2020/12/17
     **/
    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;

    }


    /**
     * @Description: 868. 二进制间距
     * @Author: gexx
     * @Date: 2020/12/17
     **/
    public static int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                list.add(i);
            }
        }
        if (list.size() <= 1) return 0;
        int max = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(list.get(i + 1) - list.get(i), max);
        }
        return max;

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @Description: 872. 叶子相似的树
     * @Author: gexx
     * @Date: 2020/12/17
     **/
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();


        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);


    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            dfs(node.left, list);
            dfs(node.right, list);

        }
    }

    /**
     * @Description: 874. 模拟行走机器人
     * @Author: gexx
     * @Date: 2020/12/18
     **/
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle : obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }

        return ans;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 876. 链表的中间结点
     * @Author: gexx
     * @Date: 2020/12/18
     **/
    public static ListNode middleNode(ListNode head) {
        List l = new ArrayList();
        dfsLiked(head, l);
        int num = 0;
        num = l.size() / 2;

        return dfsLikedNum(head, num);

    }

    private static ListNode dfsLikedNum(ListNode head, int num) {
        if (head != null && num != 0) {
            num--;
            return dfsLikedNum(head.next, num);
        }
        return head;
    }

    public static void dfsLiked(ListNode head, List l) {
        if (head != null) {
            l.add(head.val);
            dfsLiked(head.next, l);
        }
    }

    /**
     * @Description: 883. 三维形体投影面积
     * @Author: gexx
     * @Date: 2020/12/18
     **/
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }

        return ans;
    }

    /**
     * @Description: 884. 两句话中的不常见单词
     * @Author: gexx
     * @Date: 2020/12/21
     **/
    public static String[] uncommonFromSentences(String A, String B) {

        String[] aS = A.split(" ");
        String[] bS = B.split(" ");
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < aS.length; i++) {
            map.put(aS[i], map.getOrDefault(aS[i], 0) + 1);
        }
        for (int i = 0; i < bS.length; i++) {
            map.put(bS[i], map.getOrDefault(bS[i], 0) + 1);

        }
        List<String> list = new ArrayList();

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        int index = 0;
        String res[] = new String[list.size()];
        for (String str : list) {
            res[index] = str;
            index++;
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * @Description: 888. 公平的糖果交换
     * @Author: gexx
     * @Date: 2020/12/21
     **/
    public int[] fairCandySwap(int[] A, int[] B) {

        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x : A) sa += x;
        for (int x : B) sb += x;
        int delta = (sb - sa) / 2;

        Set<Integer> setB = new HashSet();
        for (int x : B) setB.add(x);

        for (int x : A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        return null;

    }

    /**
     * @Description: 892. 三维形体的表面积
     * @Author: gexx
     * @Date: 2020/12/21
     **/
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int N = grid.length;
        int ans = 0;

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                            nv = grid[nr][nc];
                        }

                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }
            }
        }

        return ans;

    }

    /**
     * @Description: 893. 特殊等价字符串组
     * @Author: gexx
     * @Date: 2020/12/22
     **/
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S : A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    /**
     * @Description: 896. 单调数列
     * @Author: gexx
     * @Date: 2020/12/22
     **/
    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] > A[i + 1]) return false;
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] < A[i + 1]) return false;
        return true;
    }

    /**
     * @Description: 897. 递增顺序查找树
     * @Author: gexx
     * @Date: 2020/12/25
     **/
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v : vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }


    /**
     * @Description: 905. 按奇偶排序数组
     * @Author: gexx
     * @Date: 2020/12/25
     **/
    public static int[] sortArrayByParity(int[] A) {

        int[] B = new int[A.length];
        for (int i = 0, k = 0, j = A.length - 1; i < A.length; i++) {

            if (A[i] % 2 == 0) {
                B[k] = A[i];
                k++;
            } else {
                B[j] = A[i];
                j--;
            }
        }
        return B;

    }

    /**
     * @Description: 908. 最小差值 I
     * @Author: gexx
     * @Date: 2020/12/28
     **/
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x : A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2 * K);

    }

    /**
     * @Description: 914. 卡牌分组
     * @Author: gexx
     * @Date: 2020/12/28
     **/
    public static boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        for (int X = 2; X <= N; ++X) {
            if (N % X == 0) {
                boolean flag = true;
                for (int v : values) {
                    if (v % X != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Description: 917. 仅仅反转字母
     * @Author: gexx
     * @Date: 2020/12/30
     **/
    public static String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c : S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();

    }

    /**
     * @Description: 922. 按奇偶排序数组 II
     * @Author: gexx
     * @Date: 2020/12/30
     **/
    public int[] sortArrayByParityII(int[] A) {
        Stack<Integer> evenStack = new Stack();
        Stack<Integer> oddStack = new Stack();
        int[] AC = new int[A.length];
        for (int a : A) {
            if (a % 2 == 0) {
                evenStack.add(a);
            } else {
                oddStack.add(a);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                AC[i] = evenStack.pop();
            } else {
                AC[i] = oddStack.pop();
            }
        }

        return AC;
    }

    /**
     * @Description: 925. 长按键入
     * @Author: gexx
     * @Date: 2020/12/30
     **/
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    /**
     * @Description: 929. 独特的电子邮件地址
     * @Author: gexx
     * @Date: 2021/1/4
     **/
    public static int numUniqueEmails(String[] emails) {
        HashSet set = new HashSet();
        for (String email : emails) {
            String[] split = email.split("@");
            String prefix = split[0].replace(".", "");
            if (prefix.contains("+")) {
                prefix = prefix.substring(0, prefix.indexOf("+"));
            }
            prefix = prefix + "@" + split[1];
            set.add(prefix);
        }
        return set.size();
    }

    class RecentCounter {
        Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList();
        }

        public int ping(int t) {
            q.add(t);
            while (q.peek() < t - 3000)
                q.poll();
            return q.size();
        }
    }

    /**
     * @Description: 937. 重新排列日志文件
     * @Author: gexx
     * @Date: 2021/1/4
     **/
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    /**
     * @Description: 938. 二叉搜索树的范围和
     * @Author: gexx
     * @Date: 2021/1/5
     **/
    static int sum = 0;

    public static int rangeSumBST(TreeNode root, int low, int high) {

        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum = sum + root.val;
            }
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }

    /**
     * @Description: 941. 有效的山脉数组
     * @Author: gexx
     * @Date: 2021/1/5
     **/
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        for (; i < arr.length - 1; ) {
            if (arr[i] < arr[i + 1]) {
                i++;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                break;
            }

        }
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        for (; i < arr.length - 1; ) {
            if (arr[i] > arr[i + 1]) {
                i++;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                break;
            }

        }
        if (i == arr.length - 1) {
            return true;
        }

        return false;
    }

    /**
     * @Description: 942. 增减字符串匹配
     * @Author: gexx
     * @Date: 2021/1/5
     **/
    public static int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }

    /**
     * @Description: 944. 删列造序
     * @Author: gexx
     * @Date: 2021/1/6
     **/
    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r + 1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }

    /**
     * @Description: 953. 验证外星语词典
     * @Author: gexx
     * @Date: 2021/1/6
     **/
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search:
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            if (word1.length() > word2.length())
                return false;
        }

        return true;

    }

    /**
     * @Description: 961. 重复 N 次的元素
     * @Author: gexx
     * @Date: 2021/1/6
     **/
    public static int repeatedNTimes(int[] A) {
        int N = A.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < N; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        Iterator<Integer> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            Integer key = keys.next();
            if (map.get(key) == N / 2) {
                return key;
            }
        }

        return 0;
    }

    /**
     * @Description: 965. 单值二叉树
     * @Author: gexx
     * @Date: 2021/1/7
     **/
    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;

    }

    /**
     * @Description: 970. 强整数
     * @Author: gexx
     * @Date: 2021/1/7
     **/
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        boolean over = false;
        int up_i = x == 1 ? 0 : (int) (Math.log(bound) / Math.log(x));
        int up_j = y == 1 ? 0 : (int) (Math.log(bound) / Math.log(y));
        for (int i = 0; i <= up_i; i++) {
            for (int j = 0; j <= up_j; j++) {
                int temp = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (temp <= bound) res.add(temp);
                else if (j > 0) break;
                else {
                    over = true;
                    break;
                }
            }
            if (over) break;
        }
        return new ArrayList<>(res);
    }

    /**
     * @Description: 976. 三角形的最大周长
     * @Author: gexx
     * @Date: 2021/1/7
     **/
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    /**
     * @Description: 977. 有序数组的平方
     * @Author: gexx
     * @Date: 2021/1/8
     **/
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * @Description: 985. 查询后的偶数和
     * @Author: gexx
     * @Date: 2021/1/8
     **/
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int S = 0;
        for (int x : A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;

    }

    /**
     * @Description: 989. 数组形式的整数加法
     * @Author: gexx
     * @Date: 2021/1/8
     **/
    public static List<Integer> addToArrayForm(int[] A, int K) {

        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;

    }

    /**
     * @Description 993. 二叉树的堂兄弟节点
     * @Author gexx
     * @Date 2021/1/9
     **/
    Map<Integer, Integer> depth = new HashMap<>();
    Map<Integer, TreeNode> father = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        isCousinsDfs(root, null);

        return depth.get(x) == depth.get(y) && father.get(x) != father.get(y);
    }

    private void isCousinsDfs(TreeNode root, TreeNode fa) {
        if (root != null) {
            depth.put(root.val, fa != null ? 1 + depth.get(fa.val) : 0);
            father.put(root.val, fa);
            isCousinsDfs(root.left, root);
            isCousinsDfs(root.right, root);
        }
    }


    /**
     * @Description 997. 找到小镇的法官
     * @Author gexx
     * @Date 2021/1/9
     **/
    public static int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1) {
            return 1;
        }
        Map<Integer, Integer> maybeJudge = new HashMap<>();//可能是法官的人选
        Set<Integer> trustOther = new HashSet();//相信別人的人
        for (int[] single : trust) {
            maybeJudge.put(single[1], maybeJudge.getOrDefault(single[1], 0) + 1);//记录每个人被多少人信任
            trustOther.add(single[0]);
        }
        for (Integer set : maybeJudge.keySet()) {
            if (maybeJudge.get(set).equals(N - 1) && trustOther.add(set)) {//法官需要N-1信任并且法官不信任任何人
                return set;
            }
        }


        return -1;
    }


    /**
     * @Description 999. 可以被一步捕获的棋子数
     * @Author gexx
     * @Date 2021/1/9
     **/
    public int numRookCaptures(char[][] board) {
        int cnt = 0, st = 0, ed = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    st = i;
                    ed = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int step = 0; ; ++step) {
                int tx = st + step * dx[i];
                int ty = ed + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;

    }

    /**
     * @Description 1002. 查找常用字符
     * @author gexx
     * @Date 2021/1/10
     **/
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;

    }

    /**
     * @Description 1005. K 次取反后最大化的数组和
     * @author gexx
     * @Date 2021/1/10
     **/
    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        //记录小于0的个数
        int lessThanZero = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                lessThanZero++;
            }
        }
        //如果K小于等于lessThanZero ，则从最小数开始依次取反A的值, 求和即可
        if (K <= lessThanZero) {
            for (int i = 0; i < K; i++) {
                A[i] = -A[i];
            }
            sum = getSum(A, sum);
            return sum;
        } else {
            //反之 先取反lessThanZero个A的小值   K-lessThanZero为剩下的K
            for (int i = 0; i < lessThanZero; i++) {
                A[i] = -A[i];
            }
            int levelK = K - lessThanZero;
            if (((levelK & 1) == 0)) { // 如果剩下的K是偶数则将所有数直接相加得到答案，
                sum = getSum(A, sum);
                return sum;
            } else {
                // 反之重新排序数组 相加之后减去最小值得2倍即可
                Arrays.sort(A);
                sum = getSum(A, sum);
                sum = sum - A[0] * 2;
                return sum;

            }


        }


    }

    private static int getSum(int[] A, int sum) {
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }


    /**
     * @Description 1009. 十进制整数的反码
     * @author gexx
     * @Date 2021/1/10
     **/
    public static int bitwiseComplement(int N) {
        String binaryStr = Integer.toBinaryString(N);
        String[] split = binaryStr.split("");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            Integer integer = Integer.valueOf(s);
            if (integer.equals(1)) {

                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        String ss = sb.toString();
        Integer s = Integer.parseInt(ss, 2);
        return s;
    }

    /**
     * @Description: 1013. 将数组分成和相等的三个部分
     * @Author: gexx
     * @Date: 2021/1/11
     **/
    public static boolean canThreePartsEqualSum(int[] arr) {
        if (arr.length < 3) return false;
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 3 != 0) return false;
        int avral = sum / 3;
        int target = 0, i = 0, l = arr.length;
        while (i < l) {
            target += arr[i];
            if (target != avral) {
                i++;
            } else {
                break;
            }
        }
        int j = i + 1;
        while (j < l - 1) {//最后一个非空
            target += arr[j];
            if (target != 2 * avral) {
                j++;
            } else {
                break;
            }
        }

        return target == 2 * avral;
    }

    /**
     * @Description: 1018. 可被 5 整除的二进制前缀
     * @Author: gexx
     * @Date: 2021/1/11
     **/
    public List<Boolean> prefixesDivBy5(int[] A) {
        int num = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int index = 0; index < A.length; index++) {
            num = (num * 2 + A[index]) % 5;
            if (num == 0) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }

    /**
     * @Description: 1021. 删除最外层的括号
     * @Author: gexx
     * @Date: 2021/1/11
     **/
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();

    }

    /**
     * @Description: 1022. 从根到叶的二进制数之和
     * @Author: gexx
     * @Date: 2021/1/12
     **/
    public static int sumRootToLeaf(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        leftDelver(root, sb);

        return sum;
    }

    private static void leftDelver(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString(), 2);
        }

        leftDelver(root.left, sb);
        leftDelver(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);

    }

    /**
     * @Description: 1025. 除数博弈
     * @Author: gexx
     * @Date: 2021/1/12
     **/
    public boolean divisorGame(int N) {

        return N % 2 == 0;
    }

    /**
     * @Description: 1030. 距离顺序排列矩阵单元格
     * @Author: gexx
     * @Date: 2021/1/12
     **/
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
            }
        });
        return ret;

    }

    /**
     * @Description: 1033. 移动石子直到连续
     * @Author: gexx
     * @Date: 2021/1/13
     **/
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a ^ b ^ c ^ x ^ z; // 位运算

        if (y - x == 1 && z - y == 1) { // 最小值为 0
            return new int[]{0, 0};
        } else if (y - x <= 2 || z - y <= 2) { // 最小值为 1
            return new int[]{1, z - x - 2}; //
        } else {
            return new int[]{2, z - x - 2}; // 最小值为 2
        }

    }

    /**
     * @Description: 1037. 有效的回旋镖
     * @Author: gexx
     * @Date: 2021/1/13
     **/
    public static boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);


    }

    /**
     * @Description: 1047. 删除字符串中的所有相邻重复项
     * @Author: gexx
     * @Date: 2021/1/13
     **/
    public static String removeDuplicates(String S) {

        HashSet<String> duplicates = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; ++i) {
            sb.setLength(0);
            sb.append(i);
            sb.append(i);
            duplicates.add(sb.toString());
        }

        int prevLength = -1;
        while (prevLength != S.length()) {
            prevLength = S.length();
            for (String d : duplicates) S = S.replace(d, "");
        }

        return S;
    }

    /**
     * @Description: 1051. 高度检查器
     * @Author: gexx
     * @Date: 2021/1/14
     **/
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }

        return count;
    }


    /**
     * @Description: 1071. 字符串的最大公因子
     * @Author: gexx
     * @Date: 2021/1/14
     **/
    public String gcdOfStrings(String str1, String str2) {

        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
            if (len1 % i == 0 && len2 % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    public boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }

    /**
     * @Description: 1078. Bigram 分词
     * @Author: gexx
     * @Date: 2021/1/14
     **/
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList();
        String[] str = text.split("");
        for (int i = 0; i < str.length - 2; i++) {
            if (str[i].equals(first) && str[i + 1].equals(second)) {
                list.add(str[i + 2]);
            }
        }
        String[] strings = new String[list.size()];
        list.toArray(strings);
        return strings;
    }

    /**
     * @Description: 1089. 复写零
     * @Author: gexx
     * @Date: 2021/1/15
     **/
    public static void duplicateZeros(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0, j = 0; j < arr.length; i++) {
            arr[j++] = copy[i];
            if (copy[i] == 0 && j < arr.length) {
                arr[j++] = 0;
            }
        }

    }

    /**
     * @Description: 1103. 分糖果 II
     * @Author: gexx
     * @Date: 2021/1/15
     **/
    public int[] distributeCandies(int candies, int num_people) {
        int[] candiesPerPeople = new int[num_people];
        int candie = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies <= 0) {
                    break;
                }
                if (candies >= candie) {
                    candiesPerPeople[i] = candiesPerPeople[i] + candie;
                    candies = candies - candie;
                    candie++;
                } else {
                    candiesPerPeople[i] = candiesPerPeople[i] + candies;
                    candies = 0;
                }
            }
        }

        return candiesPerPeople;
    }


    /**
     * @Description: 1108. IP 地址无效化
     * @Author: gexx
     * @Date: 2021/1/15
     **/
    public static String defangIPaddr(String address) {
        String replace = address.replace(".", "[.]");
        return replace;
    }

    /**
     * @Description: 1122. 数组的相对排序
     * @Author: gexx
     * @Date: 2021/1/19
     **/
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        Arrays.sort(arr1);
        List<Integer> l = new ArrayList();
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    result[index++] = arr1[j];
                }
            }

        }
        for (int i = 0; i < arr1.length; i++) {
            boolean inArr2 = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    inArr2 = true;
                }
            }
            if (!inArr2) {
                l.add(arr1[i]);
            }

        }

        for (int arr : l) {
            result[index++] = arr;
        }

        return result;
    }

    /**
     * @Description: 1128. 等价多米诺骨牌对的数量
     * @Author: gexx
     * @Date: 2021/1/27
     **/
    public static int numEquivDominoPairs(int[][] dominoes) {

        int[] freq = new int[100];

        int count = 0;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                int temp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = temp;
            }

            int num = dominoe[0] * 10 + dominoe[1];
            count += freq[num];
            freq[num]++;
        }
        return count;

    }

    /**
     * @Description: 1137. 第 N 个泰波那契数
     * @Author: gexx
     * @Date: 2021/1/28
     **/
    public static int tribonacci(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        for (int i = 3; i <= n; i++) {
            map.put(i, map.get(i - 3) + map.get(i - 2) + map.get(i - 1));
        }
        return map.get(n);
    }

    /**
     * @Description: 1154. 一年中的第几天
     * @Author: gexx
     * @Date: 2021/1/28
     **/
    public static int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7)) - 1;
        int day = Integer.valueOf(date.substring(8, 10));
        int days = 0;
        for (int i = 1; i <= month; i++) {

            if (i == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
                ) {
                    days += 29;
                } else {
                    days += 28;
                }

            } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                days += 31;
            } else {
                days += 30;
            }

        }

        days += day;
        return days;
    }

    /**
     * @Description: 1160. 拼写单词
     * @Author: gexx
     * @Date: 2021/1/29
     **/
    public static int countCharacters(String[] words, String chars) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String charsCopy = new String(chars);
            for (char wordz : word.toCharArray()) {
                int index = charsCopy.indexOf(wordz);
                if (index != -1) {
                    charsCopy = charsCopy.replaceFirst(String.valueOf(wordz), "");
                } else {
                    break;
                }
            }
            if (charsCopy.length() + word.length() == chars.length()) {
                sb.append(word);
            }

        }

        return sb.length();
    }

    /**
     * @Description: 1175. 质数排列
     * @Author: gexx
     * @Date: 2021/1/29
     **/
    public int numPrimeArrangements(int n) {
        int[] zhishu = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97
        };
        //计算质数个数
        int nzhishu = 0;
        for (int c : zhishu) {
            if (n >= c) {
                nzhishu++;
            }
        }
        //计算非质数的个数
        int nfeizhishu = n - nzhishu;
        long ans = 1;
        for (int i = nfeizhishu; i > 1; i--) {
            if (ans < 1000000007 / i) {
                ans *= i;
            } else {
                ans = ans * i % 1000000007;
            }
        }
        for (int i = nzhishu; i > 1; i--) {
            if (ans < 1000000007 / i) {
                ans *= i;
            } else {
                ans = ans * i % 1000000007;
            }
        }
        return (int) ans % 1000000007;
    }

    /**
     * @Description: 1184. 公交站间的距离
     * @Author: gexx
     * @Date: 2021/1/29
     **/
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int rdistance = 0;
        int ldistance = 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for (int i = start; i < destination; i++) {
            rdistance += distance[i];
        }

        for (int i = destination; i < distance.length; i++) {
            ldistance += distance[i];
        }
        for (int i = 0; i < start; i++) {
            ldistance += distance[i];
        }
        return Math.min(rdistance, ldistance);

    }

    /**
     * @Description: 1185. 一周中的第几天
     * @Author: gexx
     * 蔡勒公式
     * 1、W=[C/4]-2C+y+[y/4]+[26(m+1)/10]+d-1 （其中[ ]为取整符号）
     * 2、其中,W是所求日期的星期数.如果求得的数大于7,
     * 可以减去7的倍数,直到余数小于7为止.c是公元年份的前两位数字,y是已知公元年份的后两位数字;
     * m是月数,d是日数.方括[ ]表示只截取该数的整数部分
     * @Date: 2021/2/3
     **/
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] theWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        LocalDate localDate = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String weekStr = dayOfWeek.toString();

        return weekStr.substring(0, 1).concat(weekStr.substring(1, weekStr.length()).toLowerCase());
    }

    /**
     * @Description: 1189. “气球” 的最大数量
     * 木桶原理
     * @Author: gexx
     * @Date: 2021/2/3
     **/
    public int maxNumberOfBalloons(String text) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            if ("balloon".indexOf(aChar) > -1) {
                map.put(String.valueOf(aChar), map.getOrDefault(String.valueOf(aChar), 0) + 1);
            }
        }
        if (map.size() != 5) {
            return 0;
        }
        Iterator<String> iterator = map.keySet().iterator();
        int min = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer integer = map.get(key);
            if (key.equals("l") || key.equals("o")) {
                integer = integer / 2;
            }
            min = Math.min(integer, min);
        }

        return min;
    }

    /**
     * @Description: 1200. 最小绝对差
     * @Author: gexx
     * @Date: 2021/2/3
     **/
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> fa = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (minDiff == arr[i + 1] - arr[i]) {
                List son = new ArrayList<>();
                son.add(arr[i]);
                son.add(arr[i + 1]);
                fa.add(son);
            }
        }


        return fa;
    }

    /**
     * @Description: 1207. 独一无二的出现次数
     * @Author: gexx
     * @Date: 2021/2/4
     **/
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }
        Iterator<Integer> iterator = m.keySet().iterator();
        Set set = new HashSet();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value = m.get(key);
            if (!set.add(value)) {
                return false;
            }
        }


        return true;
    }

    /**
     * @Description: 1217. 玩筹码
     * @Author: gexx
     * @Date: 2021/2/4
     **/
    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                even++;
            } else if (chips[i] % 2 != 0) {
                odd++;
            }
        }
        return Math.min(even, odd);

    }

    /**
     * @Description: 1221. 分割平衡字符串
     * @Author: gexx
     * @Date: 2021/2/4
     **/
    public int balancedStringSplit(String s) {
        int count = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'R') count++;
            if (ch == 'L') count--;
            if (count == 0) ans++;
        }
        return ans;
    }

    /**
     * @Description: 1232. 缀点成线
     * @Author: gexx
     * @Date: 2021/2/5
     **/
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length - 1; i++) {
            // y2-y1 /x2-x1 =k1   y3-y2/x
            int y1 = coordinates[i][1] - coordinates[i - 1][1];
            int x1 = coordinates[i][0] - coordinates[i - 1][0];
            int y2 = coordinates[i + 1][1] - coordinates[i][1];
            int x2 = coordinates[i + 1][0] - coordinates[i][0];

            if (y1 * x2 != y2 * x1) {
                return false;
            }
        }

        return true;
    }

    /**
     * @Description: 1252. 奇数值单元格的数目
     * @Author: gexx
     * @Date: 2021/2/5
     **/
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int sum = 0;
        int rowNum = 0;
        for (int row : rows) {
            if (row % 2 == 1) {
                sum += m;
                rowNum++;
            }
        }
        for (int col : cols) {
            if (col % 2 == 1) {
                sum += n - 2 * rowNum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27});
        System.out.println(dayOfTheWeek(21, 8, 2019));
        distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0},
                7,
                2);

        dayOfYear("2003-03-01");

        tribonacci(25);
        relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        defangIPaddr("1.1.1.1");
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});

        removeDuplicates("abbaca");

        isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}});
        canThreePartsEqualSum(new int[]{
                0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
        bitwiseComplement(5);
        largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4
        }, 2);
        findJudge(2, new int[][]{{1, 2}});
        addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
                , 1);
        repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4});
        diStringMatch("IDID");

        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(0);
        TreeNode l2 = new TreeNode(0);
        TreeNode l3 = new TreeNode(1);

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(0);
        TreeNode r3 = new TreeNode(1);

        root.left = l1;
        l1.left = l2;
        l1.right = l3;
        root.right = r1;
        r1.left = r2;
        r1.right = r3;
        sumRootToLeaf(root);


        numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
        hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        sortArrayByParity(new int[]{
                3, 1, 2, 4});
        uncommonFromSentences("d b zu d t",
                "udb zu ap");
        binaryGap(22);
        peakIndexInMountainArray(new int[]{0, 1, 0});
        buddyStrings("ab", "ba");
    }
}