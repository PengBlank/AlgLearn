package com.blank.peng.learn.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question4 {
    public static int newWords(String content, String word) {
        Set<String> result = new HashSet<>();
        int n = word.length();
        for (int i = 0; i < content.length() - n + 1; i++) {
            String substr = content.substring(i, i + n);
            String sortedSubstr = sortChars(substr);
            if (sortedSubstr.equals(sortChars(word))) {
                result.add(substr);
            }
        }
        return result.size();
    }

    private static String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        String word = scanner.nextLine();
        System.out.println(newWords(content, word));
    }

}
