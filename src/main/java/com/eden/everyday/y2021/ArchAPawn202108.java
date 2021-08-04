package com.eden.everyday.y2021;


import java.util.Arrays;

/**
 * @Description: 八月
 * @Author gexx
 * @Date 2021/6/5
 * @Version V1.0
 **/
public class ArchAPawn202108 {
    /**
     * 611. 有效三角形的个数
     *
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length - 2; k++) {

                    if (nums[i] + nums[j] > nums[k]) {
                        count++;
                    }
                }
            }
        }


        return count;
    }

}
