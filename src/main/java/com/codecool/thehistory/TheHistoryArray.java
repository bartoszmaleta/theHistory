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
        StringBuilder wordsSB = new StringBuilder();

        for (int i = 0; i < wordsArray.length; i++) {
            if (!wordsArray[i].equals(wordToBeRemoved)) {
                wordsSB.append(wordsArray[i] + " ");
            }
        }

        wordsArray = wordsSB.toString().split(" ");
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
        StringBuilder wordsSB = new StringBuilder();

        for (int i = 0; i < wordsArray.length; i++) {
            wordsSB.append(wordsArray[i] + " ");
        }

        String fromWordsString = String.join(" ", fromWords);
        String toWordsString = String.join(" ", toWords);

        int i = 0;
        while (wordsSB.indexOf(fromWordsString, i) > -1) {
            int index = wordsSB.indexOf(fromWordsString, i);

            if (index > 0 && wordsSB.charAt(index - 1) != ' '
                    || wordsSB.charAt(index + fromWordsString.length()) != ' ') {
                i = index + 1;
//                i = index + toWordsString.length();
                continue;
            }

            wordsSB.replace(index, index + fromWordsString.length(), toWordsString);
            i = index + toWordsString.length();
        }

        wordsArray = wordsSB.toString().split(" ");
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
