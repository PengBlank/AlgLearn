package com.blank.peng.learn.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = scan.nextInt();
        scan.nextLine();
        Integer[] files = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int left = 0;
        int right = 0;
        int windownMax = 0;
        int windownSum = 0;


        while (right < files.length) {
            int temp = windownSum + files[right];
            if (temp < capacity) {
                windownSum += files[right];
                windownMax = Math.max(windownMax, windownSum);
                right += 1;
            } else if (temp > capacity) {
                windownSum -= files[left];
                left += 1;
            } else {
                System.out.println(capacity);
                return;
            }
        }

        System.out.println(windownMax);

    }

}
