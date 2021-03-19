package com.eden.questionbank.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

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

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}

