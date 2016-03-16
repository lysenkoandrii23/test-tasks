package com.lysenko.andrii.unknowncompany;

public class MaxNumber {
    private static int countOnesInBinary(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num /= 2;
        }
        return count;
    }

    public static int findMaxPrimeWithMaxOnes(int n) {
        int maxNum =0, maxCount = 0;
        outer:
        for(int i = 1; i <= n; i++) {
            if (((i > 2) && (i % 2 == 0)) || ((i > 5) && (i % 5 == 0))) {
                continue;
            }
            for(int j = 3; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            int count = countOnesInBinary(i);
            if (count >= maxCount) {
                maxCount = count;
                maxNum = i;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        /*int n = 1000;
        int findNumber =findMaxPrimeWithMaxOnes(n);
        System.out.println(findNumber + " or in binary " + Integer.toBinaryString(findNumber));*/
        short c =  Short.MAX_VALUE;
        short n = (short)(1 + c);
        String i = "hghj";
        String j = new String("hghj");
        j = j.intern();
        System.out.println(i==j);
    }
}
