package com.lab111;
public class StructureArray {
    public StructureArray() {
        strategySort = new Algorithm1();
    }

    private Sort strategySort;

    private int[] elements;

    public int getElement(int index) {
        return elements[index];
    }

    public void setElement(int index, int value) {
        elements[index] = value;
    }

    public void add(Integer newElement) {
    }

    public int compare(int i, int j) {
        int result = 0;
        if (i > j)
            result = 1;
        else if (i < j) {
            result = -1;
        }
        System.out.println("порівняння в StructureArray");
        return result;
    }

    public int length() {
        return elements.length;
    }

    public void swap(int i, int j) {
        int k = elements[i];
        elements[i] = elements[j];
        elements[j] = k;

    }

    public void setStrategy(Sort stategy) {
        strategySort = stategy;

    }

    public void sort(Compare compare) {
        strategySort.sort(this, compare);
    }

}
