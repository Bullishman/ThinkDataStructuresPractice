package ch2;

import java.util.Arrays;

/**
 * @author downey
 *
 */
public class SelectionSort {

	/**
	 * Swaps the elements at indexes i and j.
	 * 
	 * インデックスiとjの配列の要素を交換する。
	 */
	public static void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Finds the index of the lowest value
	 * between indices low and high (inclusive).
	 * 
	 * ダイスの数字から一番小さいインデックスを探す。
	 */
	public static int indexLowest(int[] array, int start) {
		int lowIndex = start;
		for (int i = start; i < array.length; i++) {
			if (array[i] < array[lowIndex]) {
				lowIndex = i;
			}
		}
		return lowIndex;
	}

	/**
	 * Sorts the cards (in place) using selection sort.
	 * 
	 * selectionSortを使って配列を昇順に整列
	 */
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = indexLowest(array, i);
			swapElements(array, i, j);
//			swapElements(array, 0, 3);
//			swapElements(array, 1, 3);
//			swapElements(array, 2, 4);
//			swapElements(array, 3, 3);
//			swapElements(array, 4, 4);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2, 5, 6, 1, 3};
		selectionSort(array);
//		[2, 5, 6, 1, 3]
//		[1, 5, 6, 2, 3]
//		[1, 2, 6, 5, 3]
//		[1, 2, 3, 5, 6]
				
		System.out.println(Arrays.toString(array));
	}


}