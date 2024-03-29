package com.eden.explore.datastructure.queueandstack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description: 队列和广度优先搜索
 * @Author gexx
 * @Date 2020/1/16
 * @Version V1.0
 **/
public class QueueAndBFS {
    /**
     * 判断是否是岛屿，然后统计岛屿数量
     *
     * @param isLand 未知海域数组
     * @return 返回岛屿数量
     */
    public static Integer isLand(int[][] isLand) {

        if (isLand.length == 0) {
            return 0;
        }

        // 岛屿数量
        int count = 0;

        // 循环未知海域的二维数组
        for (int i = 0; i < isLand.length; i++) {
            for (int j = 0; j < isLand[i].length; j++) {

                // isLand 拥有的值有：1 未探索的岛屿，0 海域，-1 已探索的岛屿
                // isLand 为 1 表示这个是未探索岛屿（根节点），你也可以看作最初的登陆点
                // 至于已探索岛屿肯定是与之前岛屿相连，无需重复探索
                if (isLand[i][j] == 1) {
                    count++;
                    System.out.println("岛屿登陆点（根节点），这是发现的第" + count + "座岛屿");
                }
                // 开始 BFS 广度优先算法探索岛屿
                visitLand(isLand, i, j);
            }
        }
        return count;
    }

    /**
     * BFS 广度优先算法岛屿探索，从岛屿的根节点开始
     * 把与这个岛屿相连的岛屿全部在 isLand 中状态变为 -1，防止重复探索
     *
     * @param isLand
     * @param i
     * @param j
     */
    public static void visitLand(int[][] isLand, int i, int j) {

        // 声明队列
        Queue<Integer> queue = new LinkedList<>();

        // 在后面 while 的循环中，如果是岛屿，也会陆续把这个岛屿周围的点的定位添加到队列中
        // 所有点都以 先 i，后 j，的顺序添加，因此队列以 i，j 交错的形式存在
        // i 与后一个 j 组成一个需要探索的位置，也可以理解成一个需要探索点的坐标
        // 而探索的顺序就是从根节点开始，第一层的点全部探索完后，之后探索第二层的所有点，以此类推
        // 不太理解的需要好好理解下
        // 把 i 放入队列
        queue.offer(i);

        // 把 j  放入队列
        queue.offer(j);

        // 循环队列
        // 每次循环都取一对 i，j，以此锁定一个需要探索的海域
        while (!queue.isEmpty()) {

            // 队列的 poll 方法会把队列最前面的值返回后，把这个值删除
            i = queue.poll();

            j = queue.poll();

            // 如果这个点是海域或者已探索的岛屿都跳过
            if (isLand[i][j] != 1) {
                continue;
            }

            // 记录下这个点探索过了，把探索过的点状态变为 -1
            isLand[i][j] = -1;

            // 把这个点的上面点加入队列
            // 这里注意：i 是循环行， j 是循环列
            // 比如： i = 2，i - 1 就是从第 2 行向第 1 行去探索，是向上
            // 不理解的可以好好捋一捋
            if (i - 1 >= 0) {
                queue.offer(i - 1);
                queue.offer(j);
            }

            // 把这个点的下面点加入队列
            if (i + 1 < isLand.length) {
                queue.offer(i + 1);
                queue.offer(j);
            }

            // 把这个点的左面点加入队列
            if (j - 1 >= 0) {
                queue.offer(i);
                queue.offer(j - 1);
            }

            // 把这个点的右面点加入队列
            if (j + 1 < isLand[i].length) {
                queue.offer(i);
                queue.offer(j + 1);
            }
        }
    }

    /**
     * @Description: 打开转盘锁
     * @Param: [deadends, target]
     * @Return: int
     * @Author: gexx
     * @Date: 2020/1/16
     **/
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }

        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        queue.offer(null);

        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                depth++;
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (node.equals(target)) {
                return depth;
            } else if (!dead.contains(node)) {
                for (int i = 0; i < 4; ++i) {
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * @Description: 完全平方数
     * @Param: [n]
     * @Return: int
     * @Author: gexx
     * @Date: 2020/1/17
     **/
    public static int numSquares(int n) {
        //46340*46340=2,147,395,600
        //Integer.max=2,147,483,647
        //46341*46341=2,147,488,281

        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                temp = Math.min(temp, a[i - j * j]);
            }
            a[i] = temp + 1;
        }
        return a[n];

    }

    public static void main(String[] args) {
        String[] deadends = {"8888"};
        String target = "0009";
        openLock(deadends, target);
    }

}
