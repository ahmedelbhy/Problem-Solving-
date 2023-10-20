package com.problem.solving.task.numbers;

import com.problem.solving.task.string.StringGroup;

import java.util.*;

public class NumberGroupMain {
    private static final NumbersGroups numbersGroups = NumbersGroups.INSTANCE;

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
        Optional<Integer> minOptional = specialLetter.values().stream().min(Integer::compare);
        if (minOptional.isPresent())
            result = minOptional.get();

        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        System.out.println(numbersGroups.maximumOnes(1, "0"));
        //*******************************************************************************
        System.out.println(minLength(S));
        //*******************************************************************************
        //*******************************************************************************
        //*******************************************************************************
        System.out.println(numbersGroups.getMedianOfTwoSortedArrays(new Integer[]{1, 3}, new Integer[]{2, 4}));
        //*******************************************************************************
        //*******************************************************************************
        //*******************************************************************************
        //*******************************************************************************
        //sc.close();
    }
}