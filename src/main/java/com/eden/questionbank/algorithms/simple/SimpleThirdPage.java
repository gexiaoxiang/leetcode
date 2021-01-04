package com.eden.questionbank.algorithms.simple;

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


    public class TreeNode {
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

    public static void main(String[] args) {
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