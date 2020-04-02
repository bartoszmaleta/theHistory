package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        // Does not work!
//        for (int i = 0; i < wordsArrayList.size(); i++) {
//            if (wordToBeRemoved.equals(wordsArrayList.get(i))) {
//                wordsArrayList.remove(wordsArrayList.get(i));
//            }
//        }

        // ConcurrentModificationException
//        for (String word : wordsArrayList) {
//            if (wordToBeRemoved.equals(word)) {
//                wordsArrayList.remove(word);
//            }
//        }

        wordsArrayList.removeIf(wordToBeRemoved::equals);

    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {

        // Faster
        Collections.replaceAll(wordsArrayList, from, to);

//        ListIterator<String> itr = wordsArrayList.listIterator();
//
//        while (itr.hasNext()) {
//            if (itr.next().equals(from)) {
//                itr.set(to);
//            }
//        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        // FIRST OPTION
//        StringBuilder fromWordsStringBuilder = new StringBuilder();
//        for (int i = 0; i < fromWords.length; i++) {
//            fromWordsStringBuilder.append(fromWords[i] + " ");
//        }
//        String fromWordsString = fromWordsStringBuilder.toString();
//
//        StringBuilder toWordsStringBuilder = new StringBuilder();
//        for (int i = 0; i < toWords.length; i++) {
//            toWordsStringBuilder.append(toWords[i]+ " ");
//        }
//        String toWordsString = toWordsStringBuilder.toString();
//
//        StringBuilder wordsArrayListStringBuilder = new StringBuilder();
//        for (int i = 0; i < wordsArrayList.size(); i++) {
//            wordsArrayListStringBuilder.append(wordsArrayList.get(i) + " ");
//        }
//        String wordsString = wordsArrayListStringBuilder.toString();
//
//        wordsString = wordsString.replaceAll(fromWordsString, toWordsString);
//
//        wordsArrayList = new ArrayList<String>(Arrays.asList(wordsString.split("\\s+")));
//

        // SECOND OPTION
        for (int i = 0; i < wordsArrayList.size(); i++) {

            if (i + fromWords.length > wordsArrayList.size()) {
                break;
            }

            List<String> sublist = wordsArrayList.subList(i, i + fromWords.length);

            if (sublist.equals(Arrays.asList(fromWords))) {

                int elements = i + fromWords.length;

                for (int j = i; j < elements; j++) {
                    wordsArrayList.remove(i);
                }

                wordsArrayList.addAll(i, Arrays.asList(toWords));
                i += toWords.length - 1;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
