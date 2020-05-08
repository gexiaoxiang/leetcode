package com.eden.explore.datastructure.prefixtree;

import java.util.*;

/**
 * @Description: 前缀树
 * @Author gexx
 * @Date 2020/4/30
 * @Version V1.0
 **/
public class Trie {
    private class Node {
        private int dumpli_num;////该字串的重复数目，  该属性统计重复次数的时候有用,取值为0、1、2、3、4、5……
        private int prefix_num;///以该字串为前缀的字串数， 应该包括该字串本身！！！！！
        private Node childs[];////此处用数组实现，当然也可以map或list实现以节省空间
        private boolean isLeaf;///是否为单词节点

        public Node() {
            dumpli_num = 0;
            prefix_num = 0;
            isLeaf = false;
            childs = new Node[26];
        }
    }


    private Node root;///树根

    public Trie() {
        ///初始化trie 树
        root = new Node();
    }


    /**
     * 插入字串，用循环代替迭代实现
     *
     * @param words
     */
    public void insert(String words) {
        insert(this.root, words);
    }

    /**
     * 插入字串，用循环代替迭代实现
     *
     * @param root
     * @param words
     */
    private void insert(Node root, String words) {
        words = words.toLowerCase();////转化为小写
        char[] chrs = words.toCharArray();

        for (int i = 0, length = chrs.length; i < length; i++) {
            ///用相对于a字母的值作为下标索引，也隐式地记录了该字母的值
            int index = chrs[i] - 'a';
            if (root.childs[index] != null) {
                ////已经存在了，该子节点prefix_num++
                root.childs[index].prefix_num++;
            } else {
                ///如果不存在
                root.childs[index] = new Node();
                root.childs[index].prefix_num++;
            }

            ///如果到了字串结尾，则做标记
            if (i == length - 1) {
                root.childs[index].isLeaf = true;
                root.childs[index].dumpli_num++;
            }
            ///root指向子节点，继续处理
            root = root.childs[index];
        }

    }


    public HashMap<String, Integer> getAllWords() {
        return preTraversal(this.root, "");
    }

    /**
     * 前序遍历。。。
     *
     * @param root    子树根节点
     * @param prefixs 查询到该节点前所遍历过的前缀
     * @return
     */
    private HashMap<String, Integer> preTraversal(Node root, String prefixs) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        if (root != null) {

            if (root.isLeaf == true) {
                ////当前即为一个单词
                map.put(prefixs, root.dumpli_num);
            }

            for (int i = 0, length = root.childs.length; i < length; i++) {
                if (root.childs[i] != null) {
                    char ch = (char) (i + 'a');
                    ////递归调用前序遍历
                    String tempStr = prefixs + ch;
                    map.putAll(preTraversal(root.childs[i], tempStr));
                }
            }
        }

        return map;
    }

    /**
     * 查询某字串是否在字典树中
     *
     * @param word
     * @return true if exists ,otherwise  false
     */
    public boolean search(String word) {
        char[] chs = word.toLowerCase().toCharArray();
        Node tmpRoot = root;
        for (int i = 0, length = chs.length; i < length; i++) {
            int index = chs[i] - 'a';
            if (tmpRoot.childs[index] == null) {
                ///如果不存在，则查找失败
                return false;
            }
            tmpRoot = tmpRoot.childs[index];
        }

        // 不能有孩子了
        return tmpRoot.isLeaf;
    }

    public boolean startsWith(String prefix) {
        char[] chrs = prefix.toLowerCase().toCharArray();
        Node tmpRoot = root;
        for (int i = 0, length = chrs.length; i < length; i++) {
            int index = chrs[i] - 'a';
            if (tmpRoot.childs[index] == null) {
                return false;
            }
            tmpRoot = tmpRoot.childs[index];
        }
        return true;
    }

    /**
     * 得到以某字串为前缀的字串集，包括字串本身！ 类似单词输入法的联想功能
     *
     * @param prefix 字串前缀
     * @return 字串集以及出现次数，如果不存在则返回null
     */
    public HashMap<String, Integer> getWordsForPrefix(String prefix) {
        return getWordsForPrefix(this.root, prefix);
    }

    /**
     * 得到以某字串为前缀的字串集，包括字串本身！
     *
     * @param root
     * @param prefix
     * @return 字串集以及出现次数
     */
    private HashMap<String, Integer> getWordsForPrefix(Node root, String prefix) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        char[] chrs = prefix.toLowerCase().toCharArray();
        ////
        for (int i = 0, length = chrs.length; i < length; i++) {

            int index = chrs[i] - 'a';
            if (root.childs[index] == null) {
                return null;
            }

            root = root.childs[index];

        }
        ///结果包括该前缀本身
        ///此处利用之前的前序搜索方法进行搜索
        return preTraversal(root, prefix);
    }

    /**
     * @Description: 单词替换
     * @Author: gexx
     * @Date: 2020/5/6
     **/

    public String replaceWords(List<String> dict, String sentence) {
        Set<String> rootset = new HashSet();
        for (String root : dict) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }


    public HashSet<String> result = new HashSet<>();//1,定义结果set,去掉重复结果集，

    /**
     * @Description: 单词搜索 II
     * @Author: gexx
     * @Date: 2020/5/6
     **/

    public List<String> findWords(char[][] board, String[] words) {
        //2,使用Tire，添加入trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        //分别获得board的一二维长度
        int m = board.length;//获得行的长度
        int n = board[0].length;//获得每一行中的个数，即列数
        //定义boolean数组，存储是否被访问过的数据
        boolean[][] visited = new boolean[m][n];
        //双重循环遍历board矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //DFS
                dfs(board, trie, visited, "", i, j);
            }
        }
        return new ArrayList<String>(result);
    }

    public void dfs(char[][] board, Trie trie, boolean[][] visited, String str, int x, int y) {
        //判断i，j是否越界
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;

        //判断之前是否被访问过，如果被访问过，就返回，无需再遍历
        if (visited[x][y])
            return;
        //把char字符加入字符串
        str += board[x][y];
        //如果前缀都不是，也直接返回
        if (!trie.startsWith(str))
            return;
        //在tried里面查询是否有str，如果有，则添加
        if (trie.search(str)) {
            result.add(str);
        }
        //把visited的状态改成true
        visited[x][y] = true;
        //DFS
        dfs(board, trie, visited, str, x - 1, y);//上
        dfs(board, trie, visited, str, x + 1, y);//下
        dfs(board, trie, visited, str, x, y - 1);//左
        dfs(board, trie, visited, str, x, y + 1);//右
        //回溯
        visited[x][y] = false;
    }
}

