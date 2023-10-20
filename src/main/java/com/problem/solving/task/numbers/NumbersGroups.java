package com.problem.solving.task.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum NumbersGroups {

    INSTANCE;

    public int maximumOnes(int N, String S) {
        //this is default OUTPUT. You can change it.
        int result = -404;
        if (N < 1 || N > 100)
            return result;
        if (N == 1 && S.toCharArray()[0] == '1')
            return 1;
        if (N == 1 && S.toCharArray()[0] == '0')
            return 0;

        char firstIndex = '0';
        int counter = 0;
        int maxCounter = 0;
        char[] charArray = S.toCharArray();
        firstIndex = charArray[0];
        for (char value : charArray) {
            if (firstIndex == '0') {
                firstIndex = value;
                continue;
            }
            if (value == '0')
                counter++;
            else {
                if (counter > maxCounter)
                    maxCounter = counter;
                counter = 0;
            }
        }
        result = maxCounter + 2;


        return result;
    }

    public double getMedianOfTwoSortedArrays(Integer[] num1, Integer[] num2) {
        List<Integer> arrays1 = Arrays.asList(num1);
        List<Integer> arrays2 = Arrays.asList(num2);
        List<Integer> arraysJoin = new ArrayList<>();
        arraysJoin.addAll(arrays1);
        arraysJoin.addAll(arrays2);
        Collections.sort(arraysJoin);
        if (arraysJoin.size() % 2 == 0)
            return ((double) (arraysJoin.get(arraysJoin.size() / 2) + arraysJoin.get((arraysJoin.size() / 2) - 1)) / 2);
        else
            return ((double) arraysJoin.get(arraysJoin.size() / 2));
    }




}
