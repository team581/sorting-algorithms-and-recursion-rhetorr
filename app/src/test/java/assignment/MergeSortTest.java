package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MergeSortTest {
  @Test
  public void testEmptyArray() {
    int[] array = {};
    int[] expected = {};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Empty array should remain empty");
  }

  @Test
  public void testSingleElement() {
    int[] array = {42};
    int[] expected = {42};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Single element array should remain unchanged");
  }

  @Test
  public void testAlreadySorted() {
    int[] array = {1, 2, 3, 4, 5};
    int[] expected = {1, 2, 3, 4, 5};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Already sorted array should remain sorted");
  }

  @Test
  public void testReverseSorted() {
    int[] array = {5, 4, 3, 2, 1};
    int[] expected = {1, 2, 3, 4, 5};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Reverse sorted array should be sorted ascending");
  }

  @Test
  public void testRandomUnsorted() {
    int[] array = {64, 34, 25, 12, 22, 11, 90};
    int[] expected = {11, 12, 22, 25, 34, 64, 90};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Random unsorted array should be sorted ascending");
  }

  @Test
  public void testWithDuplicates() {
    int[] array = {5, 2, 8, 2, 9, 1, 5, 5};
    int[] expected = {1, 2, 2, 5, 5, 5, 8, 9};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Array with duplicates should be sorted correctly");
  }

  @Test
  public void testWithNegativeNumbers() {
    int[] array = {-3, 5, -1, 0, 2, -4};
    int[] expected = {-4, -3, -1, 0, 2, 5};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Array with negative numbers should be sorted correctly");
  }

  @Test
  public void testTwoElements() {
    int[] array = {2, 1};
    int[] expected = {1, 2};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Two element array should be sorted");
  }

  @Test
  public void testAllSameElements() {
    int[] array = {7, 7, 7, 7, 7};
    int[] expected = {7, 7, 7, 7, 7};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Array with all same elements should remain unchanged");
  }

  @Test
  public void testLargeArray() {
    int[] array = new int[1000];
    for (int i = 0; i < 1000; i++) {
      array[i] = 1000 - i; // Reverse order
    }

    int[] expected = new int[1000];
    for (int i = 0; i < 1000; i++) {
      expected[i] = i + 1; // Ascending order
    }

    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Large array should be sorted correctly");
  }

  @Test
  public void testStability() {
    // This test would require a custom object to truly test stability
    // But we can test that equal elements maintain relative order conceptually
    int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
    int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
    MergeSort.mergeSortAscending(array);
    assertArrayEquals(expected, array, "Merge sort should handle duplicate values correctly");
  }
}
