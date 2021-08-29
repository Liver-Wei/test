package javatest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Liver
 * @Description
 * @date 2021/5/9 19:53
 */
public class Sort {
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public void bubbleSort(int[] array,int n){
        if (n==1){
            return;
        }
        for (int i = 0; i < n-1; i++) {
            if (array[i]>array[i+1]){
                swap(array,i,i+1);
            }
        }
        bubbleSort(array,n-1);
    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            if (i != index) {
                swap(array, i, index);
            }
        }
    }

    public void selectSort(int[] array, int index) {
        if (index == array.length) {
            return;
        }
        int min = index, i = index + 1;
        for (; i < array.length; i++) {
            if (array[i] < array[min]) min = i;
        }
        if (min != index) {
            swap(array, min, index);
        }
        selectSort(array, ++index);
    }

    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            for (; j > 0; j--) {
                if (array[j - 1] > temp) {//往后移
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }


    public static int[] creatList(int n,int min,int max){
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * (max-min) + min);
        }
        return array;
    }
}
