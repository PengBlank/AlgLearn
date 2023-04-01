
package com.blank.peng.learn.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] area = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        //调研区域的长度
        int length = area[0];
        //调研区域的宽度
        int width = area[1];
        //电站长、宽
        int powerStation = area[2];
        //发电量要求
        int electricity = area[3];


        //初始化二维数组
        Integer[][] electricityArea = new Integer[2][5];

        for (int i = 0; i < length; i++) {
            Integer[] temp = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 0; j < width; j++) {
                electricityArea[i][j] = temp[j];
            }
        }

        System.out.println(getAreaCount(electricityArea, electricity, powerStation));

    }

    private static int getAreaCount(Integer[][] matrix, int threshold, int powerStation) {
        int m = matrix.length;
        int n = matrix[0].length;
        //前缀和矩阵
        int[][] sum = new int[m + 1][n + 1];

        //初始化前缀和矩阵*** 二维数组最后的值为i-1, j -1
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int answer = 0;
        for (int i = powerStation; i <= m; i++) {
            for (int j = powerStation; j <= n; j++) {
                //获取每平米发电量大于要求的区域
                if (sum[i][j] - sum[i - powerStation][j] - sum[i][j - powerStation] + sum[i - powerStation][j - powerStation] >= threshold) {
                    answer += 1;
                }
            }
        }

        return answer;

    }

}
