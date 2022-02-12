package com.eden.explore.datastructure.hashtables;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description 设计哈希表
 * @Author gexx
 * @Date 2020/2/27
 **/
public class hashdesign {
    class MyHashSet {
        private Bucket[] bucketArray;
        private int keyRange;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            this.keyRange = 769;
            this.bucketArray = new Bucket[this.keyRange];
            for (int i = 0; i < this.keyRange; ++i) {
                this.bucketArray[i] = new Bucket();
            }
        }

        protected int hash(int key) {
            return (key % this.keyRange);
        }

        public void add(int key) {
            int bucketIndex = this.hash(key);
            this.bucketArray[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this.hash(key);
            this.bucketArray[bucketIndex].delete(key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int bucketIndex = this.hash(key);
            return this.bucketArray[bucketIndex].exists(key);
        }
    }


    class Bucket {
        private LinkedList<Integer> container;

        public Bucket() {
            container = new LinkedList<Integer>();
        }

        public void insert(Integer key) {
            int index = this.container.indexOf(key);
            if (index == -1) {
                this.container.addFirst(key);
            }
        }

        public void delete(Integer key) {
            this.container.remove(key);
        }

        public boolean exists(Integer key) {
            int index = this.container.indexOf(key);
            return (index != -1);
        }
    }

    /**
     * @author gexx
     * @Description设计哈希映射
     * @Date 2020/2/28
     **/
    class MyHashMap {
        int[] table;

        public MyHashMap() {
            table = new int[1000000];
            Arrays.fill(table, -1);
        }

        public void put(int key, int value) {
            table[key] = value;
        }

        public int get(int key) {
            return table[key];
        }

        public void remove(int key) {
            table[key] = -1;
        }
    }

}
