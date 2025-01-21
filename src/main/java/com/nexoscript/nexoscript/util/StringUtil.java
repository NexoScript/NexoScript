package com.nexoscript.nexoscript.util;

import java.util.List;

public class StringUtil {

    public static String getContentBetween(String input, String startChar, String endChar) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int startIndex = input.indexOf(startChar);
        int endIndex = input.indexOf(endChar, startIndex + 1);

        if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
            return "";
        }

        return input.substring(startIndex + 1, endIndex);
    }

    public static String removeStrings(String original, List<String> stringsToRemove) {
        if (original == null || stringsToRemove == null) {
            return original;
        }

        for (String toRemove : stringsToRemove) {
            original = original.replace(toRemove, "");
        }

        return original;
    }
}
