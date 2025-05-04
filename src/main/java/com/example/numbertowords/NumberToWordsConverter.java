package com.example.numbertowords;

public class NumberToWordsConverter {

    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty",
        "sixty", "seventy", "eighty", "ninety"
    };

    public static String convert(int number) {
        if (number == 0) return "zero";
        if (number < 0) return "minus " + convert(-number);

        return convertHelper(number).trim();
    }

    private static String convertHelper(int number) {
        if (number < 20) {
            return units[number];
        } else if (number < 100) {
            return tens[number / 10] + (number % 10 != 0 ? "-" + units[number % 10] : "");
        } else if (number < 1000) {
            return units[number / 100] + " hundred" + (number % 100 != 0 ? " " + convertHelper(number % 100) : "");
        } else if (number < 1_000_000) {
            return convertHelper(number / 1000) + " thousand" + (number % 1000 != 0 ? " " + convertHelper(number % 1000) : "");
        } else if (number < 1_000_000_000) {
            return convertHelper(number / 1000000) + " million" + (number % 1000000 != 0 ? " " + convertHelper(number % 1000000) : "");
        } else {
            return "number too large";
        }
    }
}
