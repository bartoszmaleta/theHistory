package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
//        String[] words = text.split("\\s+");
        String[] words = text.split("\\s+");
        int newLength = words.length + wordsArray.length;
        String[] result = Arrays.copyOf(wordsArray, newLength);

        System.arraycopy(words, 0, result, wordsArray.length, words.length);

        wordsArray = result;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        // TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        StringBuilder str = new StringBuilder();
        for (String word : wordsArray) {
            if (!wordToBeRemoved.equals(word + ",")) {
                str.append(word);
            }
        }

        String[] result = str.toString().split(",");
        wordsArray = result;
    }

    @Override
    public int size() {
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        int count = 0;
        for (String word : wordsArray) {
            if (word.equals(from)) {
                wordsArray[count] = to;
            }
            count++;
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
