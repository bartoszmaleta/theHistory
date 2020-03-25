package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            wordsLinkedList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        Iterator itr = wordsLinkedList.iterator();

        //        int index = 0;
//        while (itr.hasNext()) {
//            if (wordsLinkedList.get(index).equals(wordToBeRemoved)) {
//                wordsLinkedList.remove(index);
//            }
//            index++;
//        }

        while (itr.hasNext()) {
            if (itr.next().equals(wordToBeRemoved)) {
                itr.remove();
            }
        }
    }

    @Override
    public int size() {
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsLinkedList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information


        StringBuilder fromWordsStringBuilder = new StringBuilder();
        for (int i = 0; i < fromWords.length; i++) {
            fromWordsStringBuilder.append(fromWords[i] + " ");
        }
        String fromWordsString = fromWordsStringBuilder.toString();

        StringBuilder toWordsStringBuilder = new StringBuilder();
        for (int i = 0; i < toWords.length; i++) {
            toWordsStringBuilder.append(toWords[i]+ " ");
        }
        String toWordsString = toWordsStringBuilder.toString();

        StringBuilder wordsArrayListStringBuilder = new StringBuilder();
        for (int i = 0; i < wordsLinkedList.size(); i++) {
            wordsArrayListStringBuilder.append(wordsLinkedList.get(i) + " ");
        }
        String wordsString = wordsArrayListStringBuilder.toString();

        String wordsWithReplaced = wordsString.replaceAll(fromWordsString, toWordsString);

        wordsString = wordsWithReplaced;

        wordsLinkedList = new LinkedList<>(Arrays.asList(wordsString.split("\\s+")));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
