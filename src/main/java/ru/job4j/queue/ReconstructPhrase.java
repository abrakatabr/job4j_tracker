package ru.job4j.queue;

import java.util.Deque;
import java.lang.StringBuilder;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder firstString = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                firstString.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return firstString.toString();
    }

    private String getDescendingElements() {
        StringBuilder secondString = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            secondString.append(descendingElements.pollLast());
        }
        return secondString.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
