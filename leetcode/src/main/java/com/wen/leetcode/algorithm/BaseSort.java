package com.wen.leetcode.algorithm;

/**
 * @author huwenwen
 * @since 2019/9/7
 */
public class BaseSort {

    static int[] array = new int[] { 4, 6, 3, 2, 1, 7, 9, 3, 5 , 3};

    public static int[] bubble(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean swap = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                count++;
                if (array[j] > array[j + 1]) {
                    swap = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // 最佳的情况下循环一次，O(n)
            if (!swap) {
                break;
            }
        }
        System.out.println("[bubble] array大小: " + array.length + " 循环次数: " + count);
        return array;
    }

    public static int[] selection(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int selectIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[selectIndex] > array[j]) {
                    selectIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[selectIndex];
            array[selectIndex] = temp;
        }
        return array;
    }

    public static int[] insert(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 当前需要排序的元素
            int current = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && current < array[preIndex]) {
                // 前一个元素后移一位
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            // 当前元素插入
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static int[] shell(int[] array) {
        int grap = array.length / 2;
        while (grap > 0) {
            for (int i = grap; i < array.length; i++) {
                // 当前需要排序的元素
                int current = array[i];
                int preIndex = i - grap;
                while (preIndex >= 0 && current < array[preIndex]) {
                    // 前一个元素后移一位
                    array[preIndex + grap] = array[preIndex];
                    preIndex = preIndex - grap;
                }
                // 当前元素插入
                array[preIndex + grap] = current;
            }
            grap = grap / 2;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(printArray(bubble(new int[] { 1, 2, 3, 4, 5, 6, 7, 7, 7 })));
        System.out.println(printArray(selection(array)));
        System.out.println(printArray(insert(array)));
        System.out.println(printArray(shell(array)));
    }

    public static String printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(",");
        }
        return sb.toString();
    }

}
