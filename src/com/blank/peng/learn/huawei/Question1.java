package com.blank.peng.learn.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    private static int min_num;
    private static int m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] nums = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .toArray(Integer[]::new);
        m = scan.nextInt();
        Arrays.sort(nums);
        min_num = nums[0];
        System.out.println(dfs(nums, 0, 0, 0));

    }

    private static int dfs(Integer[] nums, int index, int sum, int count) {
        //递归出口
        if (sum > m) {
            return count;
        }

        //边界条件
        if (sum <= m && sum > m - min_num) {
            return count + 1;
        }

        for (int i = index; i < nums.length; i++) {
            count = dfs(nums, i, sum + nums[i], count);
        }
        return count;

    }
}
