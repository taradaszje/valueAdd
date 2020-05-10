package com.taradaszje.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordStatistic {

    private int quantity;
    private List<Integer> lineNumbers;

    public WordStatistic(int lineNumber) {
        this.quantity = 1;
        lineNumbers = new ArrayList<>();
        lineNumbers.add(lineNumber);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Integer> getLineNumbers() {
        return Collections.unmodifiableList(lineNumbers);
    }

    public void addLineNumber(int lineNumber){
        this.lineNumbers.add(lineNumber);
    }
    @Override
    public String toString() {
        return " - " + quantity +
                " - pozycje -> " + lineNumbers;
    }
}
