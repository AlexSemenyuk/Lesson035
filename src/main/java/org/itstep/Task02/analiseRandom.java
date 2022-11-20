package org.itstep.Task02;

import java.util.Arrays;
import java.util.Random;

public class analiseRandom {
    public static void main(String[] args) {
        Random random = new Random(100);
        Random random1 = new Random(100);
        Random random2 = new Random(100);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(500);
        }
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr1[i] = random1.nextInt(500);
        }
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr2[i] = random2.nextInt(500);
        }
        System.out.println(Arrays.toString(arr2));
    }

}
