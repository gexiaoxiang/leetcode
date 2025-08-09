package com.eden.questionbank.algorithms.medium;

import java.io.*;
import java.util.*;

public class ExternalSort {
    // 每块的最大行数(根据可用内存调整)
    private static final int MAX_TEMP_FILES = 1024;
    private static final long BLOCK_SIZE = 1024 * 1024 * 100; // 100MB每块
    
    public static void sort(String inputFile, String outputFile) throws IOException {
        // 阶段1: 分块排序
        List<File> sortedTempFiles = sortInBlocks(inputFile);
        
        // 阶段2: 归并排序
        mergeSortedFiles(sortedTempFiles, outputFile);
        
        // 清理临时文件
        for (File f : sortedTempFiles) {
            f.delete();
        }
    }
    
    private static List<File> sortInBlocks(String inputFile) throws IOException {
        List<File> sortedFiles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        
        try {
            List<Integer> tempList = new ArrayList<>();
            String line;
            long currentBlockSize = 0;
            
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                tempList.add(num);
                currentBlockSize += line.length();
                
                // 当块达到大小限制时，排序并写入临时文件
                if (currentBlockSize >= BLOCK_SIZE) {
                    Collections.sort(tempList);
                    File tempFile = File.createTempFile("sortInBatch", ".tmp");
                    writeToFile(tempList, tempFile);
                    sortedFiles.add(tempFile);
                    
                    tempList.clear();
                    currentBlockSize = 0;
                }
            }
            
            // 处理剩余数据
            if (!tempList.isEmpty()) {
                Collections.sort(tempList);
                File tempFile = File.createTempFile("sortInBatch", ".tmp");
                writeToFile(tempList, tempFile);
                sortedFiles.add(tempFile);
            }
        } finally {
            reader.close();
        }
        
        return sortedFiles;
    }
    
    private static void writeToFile(List<Integer> list, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        try {
            for (Integer num : list) {
                writer.write(num.toString());
                writer.newLine();
            }
        } finally {
            writer.close();
        }
    }
    
    private static void mergeSortedFiles(List<File> files, String outputFile) throws IOException {
        PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<>();
        
        // 初始化优先队列
        for (File f : files) {
            BinaryFileBuffer bfb = new BinaryFileBuffer(f);
            pq.add(bfb);
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        
        try {
            while (!pq.isEmpty()) {
                BinaryFileBuffer bfb = pq.poll();
                String line = bfb.pop();
                writer.write(line);
                writer.newLine();
                
                if (bfb.empty()) {
                    bfb.close();
                } else {
                    pq.add(bfb);
                }
            }
        } finally {
            writer.close();
            for (BinaryFileBuffer bfb : pq) {
                bfb.close();
            }
        }
    }
    
    // 辅助类用于归并阶段
    private static class BinaryFileBuffer implements Comparable<BinaryFileBuffer> {
        private BufferedReader reader;
        private String cache;
        
        public BinaryFileBuffer(File file) throws IOException {
            reader = new BufferedReader(new FileReader(file));
            reload();
        }
        
        public boolean empty() {
            return cache == null;
        }
        
        public String pop() throws IOException {
            String answer = cache;
            reload();
            return answer;
        }
        
        private void reload() throws IOException {
            cache = reader.readLine();
        }
        
        public void close() throws IOException {
            reader.close();
        }
        
        @Override
        public int compareTo(BinaryFileBuffer other) {
            return cache.compareTo(other.cache);
        }
    }
    
    public static void main(String[] args) throws IOException {

        
        long startTime = System.currentTimeMillis();
        sort("C:\\Users\\gexx\\Desktop\\2", "C:\\Users\\gexx\\Desktop\\3");
        long endTime = System.currentTimeMillis();
        
        System.out.println("Sorting completed in " + (endTime - startTime) + " ms");
    }
}
