import java.util.Arrays;

public class 버블정렬구현 {

	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		for (int round = 0; round < arr.length; round++) {
			for (int j = 0; j < arr.length - round; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
