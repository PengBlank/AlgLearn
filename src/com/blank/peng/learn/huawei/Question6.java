package com.blank.peng.learn.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class Question6 {

    public static void main(String[] args) {//处理输入
        Scanner in = new Scanner(System.in);
        String content = in.nextLine();
        String word = in.nextLine();
        System.out.println(contin(content, word));
    }

    public static int contin(String content, String word) {

        HashMap<Character, Integer> contentMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> wordMap = new HashMap<Character, Integer>();
        //先统计出word中的字符组成
        for (int i = 0; i < word.toCharArray().length; i++)
            wordMap.put(word.toCharArray()[i], wordMap.getOrDefault(word.toCharArray()[i], 0) + 1);

        char[] contentArr = content.toCharArray();
        int wordCharKind = wordMap.size();
        int right = 0;
        int contentChildCharKind = 0;
        int result = 0;


        while (right < content.length()) {
            if (right >= word.length()) {
                int left = right - word.length();
                if (wordMap.containsKey(contentArr[left]) && wordMap.get(contentArr[left]) == contentMap.get(contentArr[left]))
                    contentChildCharKind -= 1;
                contentMap.put(contentArr[left], contentMap.getOrDefault(contentArr[left], 0) + 1);
            }
            contentMap.put(contentArr[right], contentMap.getOrDefault(contentArr[right], 0) + 1);
            if (wordMap.containsKey(contentArr[right]) && wordMap.get(contentArr[right]) == contentMap.get(contentArr[right])) {
                contentChildCharKind += 1;
            }
            right += 1;
            if (contentChildCharKind == wordCharKind) {
                result += 1;
            }

        }
        return result;
    }
}
