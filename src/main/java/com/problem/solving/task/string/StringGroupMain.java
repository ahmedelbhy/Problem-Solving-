package com.problem.solving.task.string;

import com.problem.solving.task.numbers.NumbersGroups;

import java.util.*;

public class StringGroupMain {
    private static final StringGroup stringGroup = StringGroup.INSTANCE;

    public static int minLength(String S) {
        //this is default OUTPUT. You can change it.
        int minimunSpliteLength = 3;
        int result = -404;
        List<String> splitting = new ArrayList<>();

        Set<String> sampleSpace = new HashSet<>();
        char[] charArray = S.toCharArray();
        for (char value : charArray)
            sampleSpace.add(String.valueOf(value));

        for (int i = 0; i < S.length(); i += minimunSpliteLength)
            splitting.add(S.substring(i, i + minimunSpliteLength));

        Map<Character, Integer> specialLetter = new HashMap<>();
        for (String sub : splitting) {
            charArray = sub.toCharArray();
            for (char value : charArray) {
                specialLetter.computeIfPresent(value, (key, val) -> val + 1);
                specialLetter.put(value, 0);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //INPUT [uncomment & modify if required]
        int N = sc.nextInt();
        String S = sc.next();

        //*******************************************************************************
        System.out.println(minLength(S));
        //*******************************************************************************
        System.out.println(stringGroup.alphabeticFrequency(10, "ayuaturyii"));
        //*******************************************************************************
        System.out.println(stringGroup.getLongestSubstringWithoutRepeatingCharacters("ayuaturyii"));
        //*******************************************************************************
        System.out.println(stringGroup.getLongestPalindromicSubstring("babad"));
        System.out.println(stringGroup.getLongestPalindromicSubstring("cbbd"));
        //*******************************************************************************
        System.out.println(stringGroup.getZigZagConversion("PAYPALISHIRING", 3));
        // *******************************************************************************
        // *******************************************************************************
        sc.close();
    }
}