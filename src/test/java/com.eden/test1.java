package com.eden;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/4/9
 * @Version V1.0
 **/
public class test1 {

    public static void main(String[] args) {
        try {
            Number n = Integer.valueOf("444dff");
        } catch (NumberFormatException e) {
            System.out.println(1);
        } catch (IllegalArgumentException e) {
            System.out.println(2);
        } catch (Exception e) {
            System.out.println(3);
        }
    }
}
