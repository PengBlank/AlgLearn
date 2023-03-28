package com.blank.peng.learn.huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        //输入任务数
        int taskNums = scan.nextInt();

        //输入关系组数
        int relationNums = scan.nextInt();

        int[][] relations = new int[relationNums][2];

        //输入关系组
        for (int i = 0; i < relationNums; i++) {
            relations[i][0] = scan.nextInt();
            relations[i][1] = scan.nextInt();
        }

        //存放出度的结构
        List<List<Integer>> down = new ArrayList<>(taskNums);
        //*** 需要注意必须初始化****
        for (int i = 0; i < taskNums; i++) {
            down.add(new ArrayList<>());
        }


        //存放入度的结构
        int[] up = new int[taskNums];

        //对每一个关系组，初始化入度、出度
        for (int[] relation : relations) {
            //初始化出度
            down.get(relation[0]).add(relation[1]);
            //初始化入度
            up[relation[1]] += 1;
        }


        //用来保存入度为0的队列
        LinkedList<int[]> queue = new LinkedList<>();
        int result = 1;

        //初始化队列，每一个入度为0的任务加入队列
        for (int i = 0; i < taskNums; i++) {
            if (up[i] == 0) {
                queue.add(new int[]{i, result});
            }
        }

        while (queue.size() > 0) {
            int[] currentTask = queue.removeFirst();
            int task = currentTask[0];
            int time = currentTask[1];

            //遍历入度为0元素的出度元素
            for (int down_task : down.get(task)) {
                if (--up[down_task] == 0) {
                    result = time + 1;
                    queue.add(new int[]{
                            down_task, result
                    });
                }
            }

        }

        System.out.println(result);
    }

}
