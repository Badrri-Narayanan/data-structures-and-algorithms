package rough;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
    public void testMergeSortWithEmptyArray() {
        int[] arr = {};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testMergeSortWithArrayOfSizeOne() {
        int[] arr = {5};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    public void testMergeSortWithUnsortedArray() {
        int[] arr = {5, 3, 9, 1, 7};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    public void testMergeSortWithAlreadySortedArray() {
        int[] arr = {1, 3, 5, 7, 9};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    public void testMergeSortWithReverseSortedArray() {
        int[] arr = {9, 7, 5, 3, 1};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    public void testMergeSortWithDuplicateValues() {
        int[] arr = {5, 3, 9, 1, 7, 3};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 3, 3, 5, 7, 9}, arr);
    }
    
    @Test
    public void testMergeSortWithLargeRandomArray() {
        int[] arr = generateRandomArray(10000);
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
}
