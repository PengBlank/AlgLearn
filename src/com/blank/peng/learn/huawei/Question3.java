package com.blank.peng.learn.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] seats = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

//从左边遍历，或者空位左边连续的位数
        int leftResult = 0;
        List<Integer> left = new ArrayList<>();

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                left.add(leftResult);
                leftResult = 0;
            } else if (seats[i] == 1) {
                leftResult += 1;
            } else {
                leftResult = 0;
            }
        }


//从右边遍历，或者空位右边连续的位数
        int rightResult = 0;
        List<Integer> right = new ArrayList<>();

        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                right.add(rightResult);
                rightResult = 0;
            } else if (seats[i] == 1) {
                rightResult += 1;
            } else {
                rightResult = 0;
            }
        }

        //计算左右2边，合起来最大的连续值
        //****注意使用left中首个元素对应right最后一个元素
        int result = 0;
        for (int i = 0; i < left.size(); i++) {
            result = Math.max(result, left.get(i) + right.get(left.size() - 1 - i));
        }
        System.out.println(result);
    }


}
