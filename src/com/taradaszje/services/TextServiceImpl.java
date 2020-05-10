package com.taradaszje.services;

import com.taradaszje.model.WordStatistic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TextServiceImpl implements TextService {

    @Override
    public void doService(final String filePath) {
        Map<String, WordStatistic> words = new TreeMap<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int lineNumber = 1;
            String nextLine;
            while (scanner.hasNext()) {
                nextLine = scanner.nextLine();
                populateMap(words, nextLine, lineNumber);
                lineNumber++;
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found at " + exception.getMessage());
        }
        displayWords(words);
    }

    private void populateMap(final Map<String, WordStatistic> words,final String line, int lineNumber) {
        WordStatistic temp;
        final StringTokenizer stringTokenizer = new StringTokenizer(prepareString(line));
        while (stringTokenizer.hasMoreTokens()) {
            final String nextToken = stringTokenizer.nextToken();
            temp = words.putIfAbsent(nextToken.toLowerCase(), new WordStatistic(lineNumber)); // in my opinion
            if (temp != null) {                                           //Koronawirus and koronawirus should go to the
                words.computeIfPresent(nextToken, (key, value) -> {         // the same basket.
                    value.setQuantity(value.getQuantity() + 1);
                    value.addLineNumber(lineNumber);
                    return value;
                });
            }
        }
    }

    private void displayWords(final Map<String, WordStatistic> words) {
        words.forEach((key, value) -> System.out.println(key + value));
    }

    private String prepareString(String text) {
        text = text.replaceAll("[!„”.:\"()%'@?]|, |–|-", " ");
        return text;
    }
}
