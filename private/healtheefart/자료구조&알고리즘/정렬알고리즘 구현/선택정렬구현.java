import java.util.Arrays;

public class 선택정렬구현 {

	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				// i 이상의 위치 중 최솟값을 가진 인덱스 찾기
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			swap(arr, minIdx, i);	// i 위치값과 최솟값 교환
		}
	}

	private static void swap(int[] arr, int minIdx, int i) {
		int temp = arr[minIdx];
		arr[minIdx] = arr[i];
		arr[i] = temp;
	}
}
