package com.problem.solving.task.string;

import java.util.*;

public enum StringGroup {

    INSTANCE;

    public String getLongestPalindromicSubstring(String input) {
        StringBuilder palindromicSubstring = new StringBuilder();
        if (input == null || input.isEmpty())
            return palindromicSubstring.toString();

        char[] inputAsChars = input.toCharArray();
        int i = 0, l = 0;
        if (inputAsChars.length % 2 == 0) {
            i = (inputAsChars.length / 2) - 1;
            l = inputAsChars.length / 2;
        } else {
            i = inputAsChars.length / 2;
            l = i;
        }

        for (; i >= 0 && l <= inputAsChars.length - 1; i--, l++) {
            if (inputAsChars[i] != inputAsChars[l])
                break;
            if (i == l)
                palindromicSubstring.append(inputAsChars[i]);
            else
                palindromicSubstring = new StringBuilder(inputAsChars[i] + palindromicSubstring.toString() + inputAsChars[l]);

        }

        return palindromicSubstring.toString();
    }


    public String getZigZagConversion(String input, int n) {
        if (n == 1)
            return input;

        Map<Integer, StringBuilder> zigZag = new HashMap<>();
        for (int i = 1; i <= n; i++)
            zigZag.put(i, new StringBuilder());

        char[] inputAsChars = input.toCharArray();
        int zigZagIndex = 1;
        int downDirect = -1;
        for (char c : inputAsChars) {
            if (zigZagIndex == n + 1 || zigZagIndex == 0) {
                zigZagIndex = zigZagIndex * downDirect;
                zigZagIndex += 2;
            }

            zigZag.get(Math.abs(zigZagIndex)).append(c);
            zigZagIndex++;
        }
        StringBuilder output = new StringBuilder();
        for (Map.Entry<Integer, StringBuilder> str : zigZag.entrySet()) {
            output.append(str.getValue().toString());
        }

        return output.toString();
    }


    public int getLongestSubstringWithoutRepeatingCharacters(String input) {
        char[] charArray = input.toCharArray();
        int max = 0;
        int counter = 0;
        List<Character> charContainerList = new ArrayList<>();
        for (char character : charArray) {
            if (!charContainerList.contains(character)) {
                charContainerList.add(character);
                counter++;
            } else {
                if (counter > max)
                    max = counter;
                counter = 1;
                charContainerList.clear();
                charContainerList.add(character);
            }
        }
        return max;
    }


    public String alphabeticFrequency(int N, String S) {
        //this is default OUTPUT. You can change it.
        StringBuilder result = new StringBuilder();

        char[] charArray = S.toCharArray();
        Arrays.sort(charArray);
        Map<Character, Integer> specialLetter = new HashMap<>();
        for (char value : charArray) {
            if (specialLetter.containsKey(value))
                specialLetter.put(value, specialLetter.get(value) + 1);
            else
                specialLetter.put(value, 1);
        }
        for (Map.Entry<Character, Integer> c : specialLetter.entrySet()) {
            if (c.getValue() > 1)
                result.append(c.getKey());
        }

        return result.isEmpty() ? "'" : result.toString();
    }

    private final int INT_MIN = -2147483648;
    private final int INT_MAX = (int) Math.pow(2, 32);

    public Integer getStringToInteger(String input) {
        int ret = 0;
        String[] splitedStr = input.split(" ");
        for (String sample : splitedStr) {
            sample = sample.trim();
            try {
                ret = Integer.parseInt(sample);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        ret = Math.min(ret, INT_MAX);
        ret = Math.max(ret, INT_MIN);
        return ret;
    }
}
