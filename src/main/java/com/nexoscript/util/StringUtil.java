package com.nexoscript.util;

import java.util.List;

public class StringUtils {
    
    public static String getContentBetween(String input, String startChar, String endChar) {
        if (input == null || input.isEmpty()) {
            return ""; // Rückgabe eines leeren Strings bei ungültigem Input
        }

        int startIndex = input.indexOf(startChar);
        int endIndex = input.indexOf(endChar, startIndex + 1);

        if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
            return ""; // Rückgabe eines leeren Strings, wenn die Zeichen nicht gefunden werden
        }

        return input.substring(startIndex + 1, endIndex); // Extrahiert den Inhalt zwischen den Zeichen
    }

    public static String removeStrings(String original, List<String> stringsToRemove) {
        if (original == null || stringsToRemove == null) {
            return original; // Keine Verarbeitung, wenn Eingabe null ist
        }

        for (String toRemove : stringsToRemove) {
            original = original.replace(toRemove, ""); // Entfernt die Teilstrings
        }

        return original;
    }
}
