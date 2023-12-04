package com.example.sorting;

public class SortingUtility {

    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
//         TODO implement Gnome Sort here
        int position = 0;

        while (position < data.length) {
            if (position == 0 || data[position].compareTo(data[position-1]) >= 0) {
                position += 1;
            }
            else {
                swap(data, position, position-1);
                position -= 1;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {

        // TODO implement Cocktail Shaker Sort here
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < data.length - 1; i++){
                if (data[i].compareTo(data[i+1]) > 0) {
                    swap(data, i, i+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int k = data.length - 2; k > 0; k--) { //must be data.length -2 to avoid the index out of bounds error
                if (data[k].compareTo(data[k+1]) > 0) {
                    swap(data, k, k+1);
                    swapped = true;
                }
            }
        } while(swapped);
    }


    public static <T extends Comparable<T>> void shellSort(T[] data) {

        // TODO implement Shell Sort here
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}; //created an Array (the gaps)

        for (int gap : gaps) {
            for (int i = gap; i < (data.length - 1); i +=1) {
                T temp = data[i];
                int j;
                for (j = i; (j >= gap) && data[j - gap].compareTo(temp) > 0; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





