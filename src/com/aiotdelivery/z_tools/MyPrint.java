package com.aiotdelivery.z_tools;

import java.util.List;
import java.util.Map;

public class MyPrint {
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void print2DArray(int[][] arr2D) {
        for (int[] arr : arr2D) {
            printArray(arr);
        }
    }

    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ")");
        }
        System.out.println();
    }

    public static void printList(List<?> list) {
        System.out.print("[");
        for (Object element : list) {
            System.out.print(element + ",");
        }
        System.out.println("]");
    }
}
