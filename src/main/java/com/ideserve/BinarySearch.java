package com.ideserve;

import java.util.HashMap;
import java.util.Map;

public class BinarySearch {

	public static void main(String[] args) {
		int[] ar = { 2, 3, 4, 3, 1, 4, 5, 5, 1, 4, 4, 2, 5 };
		// int[] ar = { 1, 4, 6, 6, 6, 8, 23, 23, 23, 35 };
		// int index = binarySearch(ar, 23);
		// int index = findFirstIndexOfElementInDuplicateArray(ar, 23);
		// int index = findLastIndexOfElementInDuplicateArray(ar, 6);
		// System.out.println("element is " + ar[index] + " at this index::" + index);
		int index = findOddElementInDuplicateArray2(ar);
		System.out.println("element is " + index);
	}

	private static int findOddElementInDuplicateArray2(int[] ar) {
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < ar.length; i++) {
			if (hm.containsKey(ar[i])) {
				hm.put(ar[i], hm.get(ar[i]) + 1);
			} else {
				hm.put(ar[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			Integer val = entry.getValue();
			if (val % 2 != 0) {
				return entry.getKey();
			}
		}
		return -1;

	}

	private static int findOddElementInDuplicateArray1(int[] ar) {
		int element = ar[0];
		for (int i = 1; i < ar.length; i++) {
			element = element ^ ar[i];
		}
		return element;
	}

	private static int findLastIndexOfElementInDuplicateArray(int[] ar, int num) {
		int start = 0;
		int end = ar.length;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (ar[mid] == num && ((mid == end) || (ar[mid + 1] > num))) {
				return mid;
			} else if (num < ar[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int findFirstIndexOfElementInDuplicateArray(int[] ar, int num) {
		int start = 0;
		int end = ar.length;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (ar[mid] == num && ((mid == 0) || (ar[mid - 1] < num))) {
				return mid;
			} else if (num > ar[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] ar, int num) {
		int start = 0, end = ar.length;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (ar[mid] == num) {
				return mid;
			} else if (num < ar[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return -1;
	}

}
