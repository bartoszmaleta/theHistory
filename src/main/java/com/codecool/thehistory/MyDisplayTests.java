package com.codecool.thehistory;

import java.util.ArrayList;

public class MyDisplayTests {

    public static void main(String[] args) {

        ArrayList wordsArrayList = new ArrayList();
        wordsArrayList.add("one");
        wordsArrayList.add("two");
        wordsArrayList.add("three");
        wordsArrayList.add("one");
        wordsArrayList.add("one");



        StringBuilder wordsArrayListStringBuilder = new StringBuilder();
        for (int i = 0; i < wordsArrayList.size(); i++) {
            wordsArrayListStringBuilder.append(wordsArrayList.get(i) + " ");
        }
        String wordsString = wordsArrayListStringBuilder.toString();


        System.out.println("String arrayList = " + wordsString);

        String wordsWithReplacedWords = wordsString.replaceAll("one two", "four");
        System.out.println(wordsString);
        System.out.println(wordsWithReplacedWords);

        wordsString = wordsWithReplacedWords;
        System.out.println("wordsString again = " + wordsString);

    }
}
