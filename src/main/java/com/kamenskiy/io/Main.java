package com.kamenskiy.io;

public class Main {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayMergeSort arr = new ArrayMergeSort(100);
        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(31);
        arr.insert(22);
        arr.display(); // вывод в консоль массива до сортировки слияние
        arr.mergeSort();
        arr.display(); // вывод в консоль массива уже после сортировки слияние
    }
}