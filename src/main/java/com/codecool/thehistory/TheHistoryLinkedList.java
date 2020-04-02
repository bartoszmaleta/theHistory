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
//        Faster
        //        Collections.replaceAll(wordsLinkedList, from, to);

        ListIterator<String> itr = wordsLinkedList.listIterator();

        while (itr.hasNext()) {
            if (itr.next().equals(from)) {
                itr.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsLinkedList.size(); i++) {

            if (i + fromWords.length > wordsLinkedList.size()) {
                break;
            }

            List<String> sublist = wordsLinkedList.subList(i, i + fromWords.length);

            if (sublist.equals(Arrays.asList(fromWords))) {

                int elements = i + fromWords.length;

                for (int j = i; j < elements; j++) {
                    wordsLinkedList.remove(i);
                }

                wordsLinkedList.addAll(i, Arrays.asList(toWords));
                i += toWords.length - 1;
            }
        }
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
