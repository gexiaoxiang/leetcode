package com.eden;

public class Competition {

    /**
     * @Descriptionv5661. 替换隐藏数字得到的最晚时间
     *
     * @author gexx
     * @Date 2021/1/24
     **/
    public static String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?' && arr[1] == '?') {
            arr[0] = '2';
            arr[1] = '3';
        } else if (arr[0] == '?') {
            if (arr[1] <= '3') {
                arr[0] = '2';
            } else {
                arr[0] = '1';
            }
        } else if (arr[1] == '?') {
            if (arr[0] <= '1') {
                arr[1] = '9';
            } else {
                arr[1] = '3';
            }
        }

        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);


    }


    public static void main(String[] args) {
        System.out.println(maximumTime("2?:?0"));
        ;
    }
}
