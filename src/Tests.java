/*
 * Authors: Ryan Pallman & Ethan Mitchell &
 * Date: 4/24/2018
 * Overview: Tests the implementation of dynamic programming.
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void emptyArrayShouldThrowException() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {};
        int change = 1;
        int[] minimumCoins = new int[change + 1];
        int[] coinsUsed = new int[change + 1];
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            cc.getChange(arr, change, minimumCoins, coinsUsed);
        });
        assertEquals("Invalid coin array.", e.getMessage());
    }

    @Test
    public void test1() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {1, 5, 10, 25};
        int change = 42;
        int[] expectedArr = new int[]{1, 1, 5, 10, 25};
        int[] result;
        int[] minimumCoins = new int[change + 1];
        int[] coinsUsed = new int[change + 1];
        try {
            result = cc.getChange(arr, change, minimumCoins, coinsUsed);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            result = new int[]{0,1,2,3,4};
        }
        int[] changeArray = cc.getChangeArray(coinsUsed, change);
        System.out.println("Test 1: " + Arrays.toString(cc.getChangeArray(coinsUsed, change)));
        assertEquals(result[change], 5);
        assertArrayEquals(expectedArr, changeArray);
    }

    @Test
    public void test2() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {1};
        int change = 5;
        int[] expectedArr = new int[]{1,1,1,1,1};
        int[] result;
        int[] minimumCoins = new int[change + 1];
        int[] coinsUsed = new int[change + 1];
        try {
            result = cc.getChange(arr, change, minimumCoins, coinsUsed);
        } catch (Exception e) {
            result = new int[0];
        }
        int[] changeArray = cc.getChangeArray(coinsUsed, change);
        System.out.println("Test 2: " + Arrays.toString(cc.getChangeArray(coinsUsed, change)));
        assertEquals(result[change], 5);
        assertArrayEquals(expectedArr, changeArray);
    }

    @Test
    public void test3() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {1,5};
        int change = 5;
        int[] expectedArr = new int[]{5};
        int[] result;
        int[] minimumCoins = new int[change + 1];
        int[] coinsUsed = new int[change + 1];
        try {
            result = cc.getChange(arr, change, minimumCoins, coinsUsed);
        } catch (Exception e) {
            result = new int[0];
        }
        int[] changeArray = cc.getChangeArray(coinsUsed, change);
        System.out.println("Test 3: " + Arrays.toString(cc.getChangeArray(coinsUsed, change)));
        assertEquals(result[change], 1);
        assertArrayEquals(expectedArr, changeArray);
    }

    @Test
    public void test4() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = new int[]{1,4,6,10};
        int change = 9;
        int[] expectedArr = new int[]{1,4,4};
        int[] result;
        int[] minimumCoins = new int[change + 1];
        int[] coinsUsed = new int[change + 1];
        try {
            result = cc.getChange(arr, change, minimumCoins, coinsUsed);
        } catch (Exception e) {
            result = new int[0];
        }
        int[] changeArray = cc.getChangeArray(coinsUsed, change);
        System.out.println("Test 4: " + Arrays.toString(cc.getChangeArray(coinsUsed, change)));
        assertEquals(result[change], 3);
        assertArrayEquals(expectedArr, changeArray);
    }
}
