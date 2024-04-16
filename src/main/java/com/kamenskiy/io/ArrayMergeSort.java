package com.kamenskiy.io;
/*
Псевдокод:
Функция сортирующая массив элементов A:
Sort(A,p,r)
1 if p < r
2    then           q := round_half_down((p+r)/2)
3                       Sort(A,p,q)
4                       Sort(A,q+1,r)
5                       Merge(A,p,q,r)

Пример массива:
A = (5,2,4,6,1,3,2,6)

Примера запуска:
Sort(A,1,length[A])

Необходимо:
Разработать алгоритм функции Merge(A,p,q,r) на любом удобном вам языке, с использованием дополнительной памяти или без нее, как вам будет быстрее или удобнее в реализации.
Если у вас получится - с радостью ждем вас для прохождения дополнительного тестирования.
 */
public class ArrayMergeSort {
    private long[] theArray; // ссылка на массив
    private int nElems; // количество элементов в массиве

    public ArrayMergeSort(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    /*
    Занесение элемента в массив
     */
    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    /*
    Вывод содержимого массива
     */
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    /*
    Метод вызывается из main.
     */
    public void mergeSort() {
        long[] array = new long[nElems];
        reMergeSort(array, 0, nElems - 1);
    }
    /*
    Вложенный метод сортировки слиянием - используется рекурсивный вызов метода reMergeSort() для деления массива
     на подмассивы и последующем слиянии полученных элементарных отсортированных подмассивов
     */
    private void reMergeSort(long[] array, int lowerInd, int upperInd) {
        if (lowerInd == upperInd) return;
        else {
            int mid = (lowerInd + upperInd) / 2;
            System.out.println("Получили подмассив: " + lowerInd + "-" + mid);
            reMergeSort(array, lowerInd, mid);
            reMergeSort(array, mid + 1, upperInd);
            System.out.println("Слияние");
            merge(array, lowerInd, mid + 1, upperInd);
        }
    }
    /*
    Метод слияния подмассивов
     */
    private void merge(long[] array, int lowPointer, int highPointer, int upperInd) {
        int j = 0; //Индекс в рабочей области
        int lowInd = lowPointer;
        int mid = highPointer - 1;
        int n = upperInd - lowInd + 1; // Количество элементов

        while (lowPointer <= mid && highPointer <= upperInd) {
            if (theArray[lowPointer] < theArray[highPointer])
                array[j++] = theArray[lowPointer++];
            else
                array[j++] = theArray[highPointer++];
        }
        while (lowPointer <= mid) array[j++] = theArray[lowPointer++];
        while (highPointer <= upperInd) array[j++] = theArray[highPointer++];
        for (j = 0; j < n; j++) {
            theArray[lowInd + j] = array[j];
        }
    }
}
